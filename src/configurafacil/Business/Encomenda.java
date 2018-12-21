/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author utilizador
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda {
    private int id;
    private String carro;
    private int estado;
    private List <Componente> configuracao;
    private Pacote pacote;
    
    public Encomenda() {
        this.id = 0;
        this.carro = "";
        this.estado = 0; // 0 em espera
        this.configuracao = new ArrayList<>();
        this.pacote = null;
    }
    
    public Encomenda(int id, String carro, int estado, List<Componente> config, Pacote pacote){
        this.id = id;
        this.carro = carro;
        this.estado = estado;
        this.configuracao = new ArrayList<>();
        if (config != null) this.configuracao = config.stream().collect(Collectors.toList());
        this.pacote = pacote;
    }
    
    public Encomenda(Encomenda e){
        this.id = e.getId();
        this.carro = e.getCarro();
        this.estado = e.getEstado();
        this.configuracao = e.getConfig();
        this.pacote = e.getPacote();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getCarro(){
        return this.carro;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public List<Componente> getConfig(){
        return this.configuracao.stream().collect(Collectors.toList());
    }
    
    public Pacote getPacote(){
        return this.pacote;
    }
    
    public void addToConfiguracao(Componente c){
        this.configuracao.add(c);
    }
    
    public void removeDaConfiguracao(Componente c){
        this.configuracao.remove(c);
    }
    
    public void addCarro(String carro){
        this.carro = carro;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setCarro(String c){
        this.carro = c;
    }
    
    public void setEstado(int e){
        this.estado = e;
    }
    
    public void setPacote(Pacote pacote){
        this.pacote = pacote;
    }
    
    public void setConfig(List<Componente> c){
        this.configuracao = c.stream().collect(Collectors.toList());
    }
    
    public boolean verificaComponentes(){
        int i = 0;
        for(Componente c: this.configuracao){
            if(c.getTipo().equals("Pintura") || c.getTipo().equals("Motor") || c.getTipo().equals("Pneu") || c.getTipo().equals("Jante"))
                i++;
        }
        boolean n = i == 4;
        return n;
    }
    
    public Componente verificaTipo(String tipo){
        Componente comp = null;
        for(Componente c: this.configuracao){
            if(c.getTipo().equals(tipo)){
                comp = c;
                return comp;
            }       
        }
        return comp;
    }
        
    public List<String> verificaIncomp(Componente c){
        List<String> incomp = new ArrayList<String>();
        for(String i : c.getIncompativeis())
            for(Componente j : this.configuracao){
                if(i.equals(j.getNome()))
                    incomp.add(i);
                    
            }
        if(this.pacote!=null){
            for(Componente comp : this.pacote.getComponentes())
                for(String i : c.getIncompativeis())
                    if(i.equals(comp.getNome()))
                        incomp.add(i);
        }
        return incomp;
    }
    
    public List<String> verificaObrig(Componente c){
        List<String> obrig = new ArrayList<String>();
        int flag = 0;
        for(String i : c.getObrigatorias()){
            if(this.configuracao.isEmpty()) obrig.add(i);
            for(Componente j : this.configuracao){
                if(i.equals(j.getNome()))
                    flag = 1;
            }
            if(flag == 0) obrig.add(i);
            else flag = 0;
        } 
        return obrig;
    }
    
    public List<String> verficicaObrigatoria(){
        List<String> obrigatorio = new ArrayList<>();
        int flag = 0;
        for(Componente c : this.configuracao){
            for(String s : c.getObrigatorias()){
                for(Componente comp : this.configuracao)
                    if(s.equals(comp.getNome()))
                        flag = 1;
            if(flag == 0) obrigatorio.add(s);
            else flag = 0;
            }
        }
        return obrigatorio;
    }
    
    public List<String> verificaIncompativel(Pacote p){
        List<String> incomp = new ArrayList<String>();
        for(Componente c : p.getComponentes())
            for(String s : c.getIncompativeis())
                for(Componente comp : this.configuracao)
                    if(s.equals(comp.getNome()))
                        incomp.add(s);
        return incomp;
    }

    
    public boolean equals(Object o) {
        boolean b=false;

        if (o!= null && o instanceof Encomenda) {
            Encomenda e = (Encomenda)o;
            b = this.carro.equals(e.getCarro());
        }
        return b;
    }

    //Falta imprimir a lista dos arrays
    public String toString() {
        StringBuffer sb = new StringBuffer("Encomenda(");
        sb.append(this.carro);
        sb.append(this.configuracao.toString());
        return sb.toString();
    }
}
