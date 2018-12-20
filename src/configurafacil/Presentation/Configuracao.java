/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Presentation;

import configurafacil.Business.Componente;
import configurafacil.Business.Cliente;
import configurafacil.Business.ConfiguraFacil;
import configurafacil.Business.Encomenda;
import configurafacil.Business.Pacote;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jessica
 */
public class Configuracao extends javax.swing.JDialog {
    private ConfiguraFacil configura;
    private EscolherCarro parent;
    private DadosCliente parent2;
    
    /**
     * Creates new form Configuracao
     */
    public Configuracao(javax.swing.JDialog parent, javax.swing.JDialog parent2, boolean modal, ConfiguraFacil c) {
       super(parent, modal);
       this.configura = c;
       initComponents();
       this.parent = (EscolherCarro) parent;
       this.parent2 = (DadosCliente) parent2;
    }
    
    public boolean verificaComponentes(Encomenda e){
        int i = 0;
        for(Componente c: e.getConfig()){
            if(c.getTipo().equals("Pintura") || c.getTipo().equals("Motor") || c.getTipo().equals("Pneu") || c.getTipo().equals("Jante"))
                i++;
        }
        boolean n = i == 4;
        return n;
    }
    
    public Componente verificaTipo(Encomenda e, String tipo){
        Componente comp = null;
        for(Componente c: e.getConfig()){
            if(c.getTipo().equals(tipo)){
                comp = c;
                return comp;
            }       
        }
        return comp;
    }
    
    public List<String> verificaIncomp(Componente c, Encomenda e){
        List<String> incomp = new ArrayList<String>();
        for(String i : c.getIncompativeis())
            for(Componente j : e.getConfig()){
                if(i.equals(j.getNome()))
                    incomp.add(i);
                    
            }
        if(e.getPacote()!=null){
            for(Componente comp : e.getPacote().getComponentes())
                for(String i : c.getIncompativeis())
                    if(i.equals(comp.getNome()))
                        incomp.add(i);
        }
        return incomp;
    }
    
    public List<String> verificaObrig(Componente c, Encomenda e){
        List<String> obrig = new ArrayList<String>();
        int flag = 0;
        for(String i : c.getObrigatorias()){
            if(e.getConfig().isEmpty()) obrig.add(i);
            for(Componente j : e.getConfig()){
                if(i.equals(j.getNome()))
                    flag = 1;
            }
            if(flag == 0) obrig.add(i);
            else flag = 0;
        } 
        return obrig;
    }
    
    public List<String> verificaIncompativel(Pacote p, Encomenda e){
        List<String> incomp = new ArrayList<String>();
        for(Componente c : p.getComponentes())
            for(String s : c.getIncompativeis())
                for(Componente comp : e.getConfig())
                    if(s.equals(comp.getNome()))
                        incomp.add(s);
        return incomp;
    }
    
    public List<String> verficicaObrigatoria(Encomenda e){
        List<String> obrigatorio = new ArrayList<>();
        int flag = 0;
        for(Componente c : e.getConfig()){
            for(String s : c.getObrigatorias()){
                for(Componente comp : e.getConfig())
                    if(s.equals(comp.getNome()))
                        flag = 1;
            if(flag == 0) obrigatorio.add(s);
            else flag = 0;
            }
        }
        return obrigatorio;
    }
    
    public Encomenda sugestao(double limite){
        Encomenda e = new Encomenda();
        double valor = 0;
        e.setCarro(this.parent.encomenda.getCarro());
        if(limite >= 1800 && limite <2700) {
            Pacote p = configura.getStand().getPacote("Pacote Comfort");
            valor = p.getPreco();
            e.setPacote(p);
            for(Componente c : configura.getStand().getComponentes().values()){
                boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                double v = c.getPreco();
                if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && this.verificaIncomp(c,e).isEmpty()){
                    e.addToConfiguracao(c);
                    valor += v;
                }
            }   
        }
        else {
            if (limite >= 2700) {
                double max = 0;
                Componente comp = null;
                Pacote p = configura.getStand().getPacote("Pacote Sport");
                valor = p.getPreco();
                e.setPacote(p);
                for(Componente c : configura.getStand().getComponentes().values()){
                    boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                    double v = c.getPreco();
                    if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && this.verificaIncomp(c,e).isEmpty()){
                        if(c.getTipo().equals("Estofo")){
                            if(max < v){
                                max = v;
                                if (comp == null){
                                    e.addToConfiguracao(c);
                                    comp = c;
                                    valor += v;
                                }
                                else {
                                    e.removeDaConfiguracao(comp);
                                    e.addToConfiguracao(c);
                                    valor -= comp.getPreco();
                                    valor += v;
                                    comp = c;
                                }
                            }
                        }  
                        else {
                            valor += v;
                            e.addToConfiguracao(c);
                        }
                    }
                }
            }
            else {
                for(Componente c : configura.getStand().getComponentes().values()){
                    boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                    double v = c.getPreco();
                    if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && this.verificaIncomp(c,e).isEmpty()){
                       e.addToConfiguracao(c);
                       valor += v;
                    }
                }
            }
        }
        return e;
    }
    
    public void setPacotes(){
            this.Sport.setEnabled(true);
            this.Comfort.setEnabled(true);
    }
    
    public void setVidro(){
            this.Vidro.setEnabled(true);
    }
    
    public void setParaChoques(){
            this.Parachoques.setEnabled(true);
    }
    
    public void setTeto(){
            this.Teto.setEnabled(true);
    }
    
    public void setLuz(){
            this.Luz.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Vidro = new javax.swing.JButton();
        Parachoques = new javax.swing.JButton();
        Teto = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Luz = new javax.swing.JButton();
        Comfort = new javax.swing.JButton();
        Sport = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton1.setText("Motor");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pintura");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Pneus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Jantes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Vidro.setText("Vidro Escurecido");
        Vidro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VidroActionPerformed(evt);
            }
        });

        Parachoques.setText("Pára-choques");
        Parachoques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParachoquesActionPerformed(evt);
            }
        });

        Teto.setText("Teto de abrir");
        Teto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TetoActionPerformed(evt);
            }
        });

        jButton8.setText("Estofos");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        Luz.setText("Pacotes de luz");
        Luz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuzActionPerformed(evt);
            }
        });

        Comfort.setText("Comfort");
        Comfort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComfortActionPerformed(evt);
            }
        });

        Sport.setText("Sport");
        Sport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SportActionPerformed(evt);
            }
        });

        jLabel1.setText("Obrigatórias");

        jLabel2.setText("Interior");

        jLabel3.setText("Exterior");

        jLabel4.setText("Pacotes");

        jButton12.setText("Consultar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Sugestão");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Guardar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/pneu.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/jantes.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/motor.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/pacoteLuz.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/tetoAbrir.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/estofos.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/configurafacil/paraChoques.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel5)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel7)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(Vidro, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)))
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(39, 39, 39))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Comfort, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabel10)
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Parachoques, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(Teto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(41, 41, 41)
                                            .addComponent(jLabel9)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Sport, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Luz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)))
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel4)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Parachoques)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Vidro)
                                .addComponent(Teto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel9)))
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Luz)
                    .addComponent(jButton8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton13)
                            .addComponent(jButton12)
                            .addComponent(jButton14))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Comfort)
                            .addComponent(Sport))
                        .addGap(66, 66, 66))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Pintura(this,this.parent, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new Estofos(this,this.parent, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void ComfortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComfortActionPerformed
        // TODO add your handling code here:
        new PacoteConfort(this,this.parent, true, configura).setVisible(true);
        if(this.parent.encomenda.getPacote()!=null) {
            this.Comfort.setEnabled(false);
            this.Sport.setEnabled(false);
        }
    }//GEN-LAST:event_ComfortActionPerformed

    private void SportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SportActionPerformed
        // TODO add your handling code here:
        new PacoteSport(this,this.parent, true, configura).setVisible(true);
        if(this.parent.encomenda.getPacote()!=null) {
            this.Comfort.setEnabled(false);
            this.Sport.setEnabled(false);
        }
    }//GEN-LAST:event_SportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Motor(this,this.parent, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Pneu(this,this.parent, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new Jantes(this,this.parent, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void VidroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VidroActionPerformed
        // TODO add your handling code here:
        Componente comp = configura.getStand().getComponente("Vidro Escurecido");
        List<String> listInc = this.verificaIncomp(comp, this.parent.encomenda);
        List<String> listObrig = this.verificaObrig(comp, this.parent.encomenda);
        StringBuilder sbInc = new StringBuilder();
        StringBuilder sbObrig = new StringBuilder();
        for (String i : listObrig){
            sbObrig.append(i);
            sbObrig.append("; ");
        }
        if(!listObrig.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Obrigatórias: " + sbObrig , "Componentes obrigatórias",0);
        }
        for (String i : listInc){
            sbInc.append(i);
            sbInc.append("; ");
        }
        if(!listInc.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Incompatível com: " + sbInc , "Componentes incompatíveis",0);
        }
        else {
            this.parent.encomenda.addToConfiguracao(comp);
            this.Vidro.setEnabled(false);
        }
    }//GEN-LAST:event_VidroActionPerformed

    private void ParachoquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParachoquesActionPerformed
        // TODO add your handling code here:
        Componente comp = configura.getStand().getComponente("Pára-choques");
        List<String> listInc = this.verificaIncomp(comp, this.parent.encomenda);
        List<String> listObrig = this.verificaObrig(comp, this.parent.encomenda);
        StringBuilder sbInc = new StringBuilder();
        StringBuilder sbObrig = new StringBuilder();
        for (String i : listObrig){
            sbObrig.append(i);
            sbObrig.append("; ");
        }
        if(!listObrig.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Obrigatórias: " + sbObrig , "Componentes obrigatórias",0);
        }
        for (String i : listInc){
            sbInc.append(i);
            sbInc.append("; ");
        }
        if(!listInc.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Incompatível com: " + sbInc , "Componentes incompatíveis",0);
        }
        else {
            this.parent.encomenda.addToConfiguracao(comp);
            this.Parachoques.setEnabled(false);
        }
    }//GEN-LAST:event_ParachoquesActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        new SugestaoConfiguracao(this, parent, parent2, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        new ConfiguracaoFinal(this, parent, true, configura).setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void TetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TetoActionPerformed
        // TODO add your handling code here:
        Componente comp = configura.getStand().getComponente("Teto de abrir");
        List<String> listInc = this.verificaIncomp(comp, this.parent.encomenda);
        List<String> listObrig = this.verificaObrig(comp, this.parent.encomenda);
        StringBuilder sbInc = new StringBuilder();
        StringBuilder sbObrig = new StringBuilder();
        for (String i : listObrig){
            sbObrig.append(i);
            sbObrig.append("; ");
        }
        if(!listObrig.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Obrigatórias: " + sbObrig , "Componentes obrigatórias",0);
        }
        for (String i : listInc){
            sbInc.append(i);
            sbInc.append("; ");
        }
        if(!listInc.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Incompatível com: " + sbInc , "Componentes incompatíveis",0);
        }
        else{
            this.parent.encomenda.addToConfiguracao(comp);
            this.Teto.setEnabled(false);
        }
    }//GEN-LAST:event_TetoActionPerformed

    private void LuzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuzActionPerformed
        // TODO add your handling code here:
        Componente comp = configura.getStand().getComponente("Pacotes de luz");
        List<String> listInc = this.verificaIncomp(comp, this.parent.encomenda);
        List<String> listObrig = this.verificaObrig(comp, this.parent.encomenda);
        StringBuilder sbInc = new StringBuilder();
        StringBuilder sbObrig = new StringBuilder();
        for (String i : listObrig){
            sbObrig.append(i);
            sbObrig.append("; ");
        }
        if(!listObrig.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Obrigatórias: " + sbObrig , "Componentes obrigatórias",0);
        }
        for (String i : listInc){
            sbInc.append(i);
            sbInc.append("; ");
        }
        if(!listInc.isEmpty()){
            javax.swing.JOptionPane.showMessageDialog(this, "Incompatível com: " + sbInc , "Componentes incompatíveis",0);
        }
        else{
            this.parent.encomenda.addToConfiguracao(comp);
            this.Luz.setEnabled(false);
        }
    }//GEN-LAST:event_LuzActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(verificaComponentes(this.parent.encomenda)){
            Cliente c = configura.getStand().getClientes().get(this.parent2.getCliente());
            List<String> listObrig = new ArrayList<>();
            for(Componente comp : this.parent.encomenda.getConfig()){
                listObrig = this.verficicaObrigatoria(this.parent.encomenda);
            }
            StringBuilder sb = new StringBuilder();
            for(String i : listObrig){
                sb.append(i);
                sb.append("; ");
            }
            if(listObrig.isEmpty()){
                configura.getStand().addEncomendaCliente(c,this.parent.encomenda);
                configura.getFabrica().getGestaoE().addEncomenda(this.parent.encomenda);
                this.setVisible(false);
                new DadosCliente(this, true, configura).setVisible(true);
            }
            else javax.swing.JOptionPane.showMessageDialog(this, "Obrigatória: " + sb,"Componente obrigatória não selecionada", 0);
        }
        else javax.swing.JOptionPane.showMessageDialog(this, "Por favor escolha as componentes obrigatórias","Componente obrigatória não selecionada", 0);
    }//GEN-LAST:event_jButton14ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Comfort;
    private javax.swing.JButton Luz;
    private javax.swing.JButton Parachoques;
    private javax.swing.JButton Sport;
    private javax.swing.JButton Teto;
    private javax.swing.JButton Vidro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
