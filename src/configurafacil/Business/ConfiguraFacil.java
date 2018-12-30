/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import configurafacil.Business.Fabrica.Fabrica;
import configurafacil.Business.Fabrica.GestaoEncomenda.*;
import configurafacil.Business.GestaoUtilizadores.Administrador;
import configurafacil.Business.GestaoUtilizadores.GestaoUtilizadores;
import configurafacil.Business.GestaoUtilizadores.Utilizador;
import configurafacil.Business.Stand.Cliente;
import configurafacil.Business.Stand.Stand;
import configurafacil.Database.ComponenteDAO;
import configurafacil.Database.PacoteDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Grupo 30
 */
public class ConfiguraFacil {
    
    //Variáveis de instância
    private Administrador administrador;
    private Stand stand;
    private Fabrica fabrica;
    private Utilizador utilizador;
    private GestaoUtilizadores gestaoU;
    private GestaoEncomenda gestaoE;
    private ComponenteDAO componentes;
    private PacoteDAO pacotes;
    
    /**
     * Construtor da classe ConfiguraFacil sem parâmetros.
     */
    public ConfiguraFacil(){
        this.stand = new Stand();
        this.fabrica = new Fabrica();
        this.utilizador = null;
        this.administrador = new Administrador();
        this.gestaoU = new GestaoUtilizadores();
        this.gestaoE = new GestaoEncomenda();
        this.componentes = new ComponenteDAO();
        this.pacotes = new PacoteDAO();
    }

    /**
     * Devolve as componentes existente na aplicação.
     * @return Map
     */
    public Map<String,Componente> getComponentes(){
        return this.componentes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
     * Devolve os pacotes existentes na aplicação.
     * @return Map
     */
    public Map<String,Pacote> getPacote(){
        return this.pacotes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
     * Devolve uma das componentes da aplicação.
     * @param nome Nome da componente
     * @return Componente
     */
    public Componente getComponente(String nome){
        return this.componentes.get(nome);
    }
    
    /**
     * Devolve um dos pacotes da aplicação.
     * @param nome Nome do pacote
     * @return Pacote
     */
    public Pacote getPacote(String nome){
        return this.pacotes.get(nome);
    }
    
    /**
     * Devolve o stand da aplicação.
     * @return Stand
     */
    public Stand getStand(){
        return this.stand;
    }
    
    /**
     * Devolve um cliente da aplicação com dado nif.
     * @param nif Nif do cliente
     * @return Cliente
     */
    public Cliente getCliente(String nif){
        return this.stand.getCliente(nif);
    }
    
    /**
     * Devolve a fabrica da aplicação.
     * @return Fabrica
     */
    public Fabrica getFabrica(){
        return this.fabrica;
    }
    
    /**
     * Devolve o adminstrador da aplicação.
     * @return Administrador
     */
    public Administrador getAdministrador(){
        return this.administrador;
    }
    
    /**
     * Devolve o utilizador da aplicação.
     * @return Utilizador
     */
    public Utilizador getUtilizador(){
        return this.utilizador;
    }
    /**
     * Devolve o utilizador da aplicação com dado nome.
     * @param nome Nome do utilizador
     * @return Utilizador
     */
    public Utilizador getUser(String nome){
        return this.gestaoU.getUtilizador(nome);
    }

    /**
     * Devolve a gestão de utilizadores.
     * @return GestaoU
     */    
    public GestaoUtilizadores getGestaoU(){
        return this.gestaoU;
    }

     /**
     * Devolve a gestão de encomendas.
     * @return GestaoE
     */   
    public GestaoEncomenda getGestaoE(){
        return this.gestaoE;
    }
    
    /**
     * Devolve os utilizadores da aplicação.
     * @return Map
     */
    public Map<String,Utilizador> getUtilizadores(){
        return this.gestaoU.getUtilizadores();
    }

    /**
     * Devolve as componentes existente na aplicação. 
     * @param u Utilizador
     * @param estado Estado a alterar
     * @return Map
     */    
    public void setEstado(String nome, int estado){
        this.gestaoU.setEstado(nome,estado);
    }

    /**
     * Adiciona uma componente.
     * @param c Componente a adicionar
     * @return Map
     */    
    public void addComponente(Componente c){
        this.componentes.put(c.getNome(),c);
    }

    /**
     * Devolve as componentes existente na aplicação.
     * @param p Pacote a adicionar
     * @return Map
     */    
    public void addPacote(Pacote p){
        this.pacotes.put(p.getNome(),p);
    }
    
    public void addCliente(String nome, String nif, String contacto){
        this.stand.addCliente(nome,nif,contacto);
    }

    /**
     * Adiciona um utilizador.
     * @param u Utilizador
     */    
    public void addUtilizador(Utilizador u) {
        this.gestaoU.addUtilizador(u);
    }
    
    public void adicionaUtilizador(String nome, String password, int estado, int tipo){
            this.gestaoU.adicionaUtilizador(nome, password, estado, tipo);
    }
    
    public List<String> getAtivos(){
        return this.gestaoU.getAtivos();
    }
    
    public void geraEncomenda(String nif, String carro, List<String> comp, String pacote, double limite){
        this.gestaoE.geraEncomenda(nif, carro, comp, pacote, limite);
    }
    
   public List<String> getComponentesPacote(String nome){
       return this.pacotes.get(nome).getComponentes();
   }

    /**
     * Verifica se é um utilizador.
     * @param nome Nome a verificar
     * @return Se existe ou não
     */      
    public boolean verificaUserName(String nome){
        return this.gestaoU.verificaUserName(nome);
    }

    /**
     * Verifica se todas as componetes básicas obrigatórias foram escolhidas
     * @param comp Componentes da configuração
     * @return boolean
     */
    public boolean verificaComponentes(List<String> comp){
        int i = 0;
        for(String s: comp){
            Componente c = this.componentes.get(s);
            if(c.getTipo().equals("Pintura") || c.getTipo().equals("Motor") || c.getTipo().equals("Pneu") || c.getTipo().equals("Jante"))
                i++;
        }
        boolean n = i == 4;
        return n;
    }
    
    /**
     * Devolve uma componente de um determinado tipo na encomenda.
     * @param tipo Tipo da componente
     * @param comp Componentes da configuração
     * @return Componente
     */
    public boolean verificaTipo(String tipo, String c){
       Componente comp = this.componentes.get(c);
       if(comp.getTipo().equals(tipo)) return true;
       return false;
    }
    
    
    /**
     * Devolve a componente de um determinado tipo
     * @param tipo Tipo da componente
     * @param comp Componentes da configuração
     */
    public String verificaTipo(String tipo, List<String> componente){
        String comp = null;
        Componente c = null;
        for(String s: componente){
            c = this.componentes.get(s);
            if(c.getTipo().equals(tipo)){
                comp = c.getNome();
                return comp;
            }       
        }
        return comp;
    }

    
    /**
     * Devolve a lista de componentes obrigatórias da encomenda não selecionadas
     * @param tipo Tipo da componente
     * @return Lista de componentes obrigatórias
     */    
    public List<String> verificaObrigatoria(List<String> componente){
        List<String> obrigatorio = new ArrayList<>();
        int flag = 0;
        for(String string : componente){
            Componente c = this.componentes.get(string);
            for(String s : c.getObrigatorias()){
                for(String n : componente)
                    if(s.equals(n))
                        flag = 1;
            if(flag == 0) obrigatorio.add(s);
            else flag = 0;
            }
        }
        return obrigatorio;
    }

    /**
     * Devolve a lista de componentes incompativeis de um componente e um pacote
     * @param c Componente selecionado 
     * @param comp Componentes a serem adicionadas na configuracao
     * @param p Pacote selecionado
     * @param Lista de componentes incompativeis
     */    
    public List<String> verificaIncomp(String componente, List<String> comp, String p){
        List<String> incomp = new ArrayList<String>();
        Componente c = this.componentes.get(componente);
        for(String i : c.getIncompativeis())
            for(String j : comp){
                if(i.equals(j))
                    incomp.add(i); 
            }
        if(p!=null){
            Pacote pacote = this.pacotes.get(p);
            for(String s : pacote.getComponentes())
                for(String i : c.getIncompativeis())
                    if(i.equals(s))
                        incomp.add(i);
        }
        return incomp;
    }
    
    
    /**
     * Devolve a lista de componentes obrigatórias que ainda não se encontram na encomenda
     * @param cnome Componente adicionada
     * @param comp Componentes a serem adicionadas na configuracao
     * @return Lista de componentes obrigatórias
     */    
    public List<String> verificaObrig(String cnome, List<String> comp){
        List<String> obrig = new ArrayList<String>();
        Componente componente = this.componentes.get(cnome);
        int flag = 0;
        for(String i : componente.getObrigatorias()){
            if(comp.isEmpty()) obrig.add(i);
            for(String j : comp){
                if(i.equals(j))
                    flag = 1;
            }
            if(flag == 0) obrig.add(i);
            else flag = 0;
        } 
        return obrig;
    }

    /**
     * Devolve a lista de componentes incompativeis com um pacote presentes na configuração
     * @param p Pacote
     * @param componente Componentes da configuração
     * @return lista de componentes incompativeis
     */    
    public List<String> verificaIncompativel(String pacote, List<String> componente){
        List<String> incomp = new ArrayList<String>();
        Pacote p = this.pacotes.get(pacote);
        for(String str : p.getComponentes()){
            Componente c = componentes.get(str);
            for(String s : c.getIncompativeis())
                for(String comp : componente)
                    if(s.equals(comp))
                        incomp.add(s);
        }
        return incomp;
    }
    
    /**
     * Verifica se existe stock de uma determinada componente.
     * @param s Nome da componente
     * @return Se existe ou não
     */
    public int verificaStock(String s){
        return this.fabrica.verificaStock(s);
    } 
    
    /**
     * Devolve uma determinada encomenda.
     * @param id Identificador da encomenda
     * @return Encomenda
     */
    public Encomenda getEncomenda(int id){
        return this.gestaoE.getEncomenda(id);
    }
    
    public String getPacote(Encomenda e){
        return this.gestaoE.getPacote(e);
    }
    
    /**
     * Devolve todas as encomendas na aplicação.
     * @return Map
     */
    public Map<Integer,Encomenda> getEncomendas(){
        return this.gestaoE.getEncomendas();
    }
    
    /**
     * Atualiza o stock de uma determinada componente.
     * @param s Nome da componente
     * @param q Quantidade da componente
     */
    public void atualizaStock(String s, int q){
        this.fabrica.atualizaStock(s,q);
    }
    /*
    public void setCliente(Encomenda e,String cliente){
        e.setCliente(cliente);
    }*/

    /**
     * Altera o estado de uma determinada encomenda.
     * @param e Encomenda
     * @param estado Estado da encomenda
     */    
    public void alterarEstado(Encomenda e, int estado){
        this.gestaoE.alterarEstado(e, estado);
    }
    
    public double getComponentePreco(String nome){
        return this.componentes.get(nome).getPreco();
    }
    
    public double getPacotePreco(String nome){
        return this.pacotes.get(nome).getPreco();
    }
    
    public boolean isPacote(String nome){
        return this.pacotes.containsKey(nome);
    }

    /**
     * Inicia sessão de um utilizador.
     * @param nome Nome do utilizador
     * @param password Password do utilizador
     */     
    public void login(String nome, String password){
        try{
            if(!nome.equals("Admin")) this.utilizador = this.gestaoU.verificaUtilizador(nome, password);
            else this.administrador = this.administrador.verificaAdmin(nome,password);
        }
        catch(Exception e){}
    }

    /**
     * Termina sessão de um utilizador.
     */  
    public void logout(){
        this.utilizador = null;
    }

    /**
     * Constroi uma string com a lista de componentes.
     * @param componentes Lista dos nomes das componentes a listar
     * @return string com as componentes
     */  
    public String listaComponentes(List<String> componentes){
        StringBuilder sb = new StringBuilder();
        for (String i : componentes){
            sb.append(i);
            sb.append("; ");
        }
        return sb.toString();
    }
    
    public List<String> sugestao2(double limite){
        List<String> l = new ArrayList<>();
        String pacote = null;
        double valor = 0;
        double v;
        double max = 0;
  
        for(Pacote p: this.pacotes.values()){
            v = p.getPreco();
            if(valor+v<= limite && max<v){
                pacote = p.getNome();
                max = v;
            }
        }
        if(pacote!=null){
            valor+=max;
        }
        List<Componente> cl = new ArrayList<>();       
        if(valor<limite){
            for(Componente c : this.componentes.values()){
                boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                 !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante") && !c.getTipo().equals("Pacote"); 
                if(b) cl.add(c);
            }
             Collections.sort(cl, new ComponenteComparator());
             for(Componente cp: cl){
                 v = cp.getPreco();
                 if(valor + v <= limite && verificaIncomp(cp.getNome(), l, pacote).isEmpty() && verificaObrig(cp.getNome(),l).isEmpty() && verificaTipo(cp.getTipo(), l)==null){
                    valor+=v;
                    l.add(cp.getNome());
                }
                 else if(!verificaObrig(cp.getNome(),l).isEmpty()){
                     int flag = 1;
                     for(String s : verificaObrig(cp.getNome(),l)){
                        Componente componente = this.componentes.get(s);
                        v = componente.getPreco();
                        boolean b = !componente.getTipo().equals("Motor") && !componente.getTipo().equals("Pintura") && 
                                    !componente.getTipo().equals("Pneu") && !componente.getTipo().equals("Jante"); 
                        if(v+valor+cp.getPreco()<= limite && b && verificaTipo(cp.getTipo(), l)==null){
                            valor+=v;
                            l.add(cp.getNome());
                        }
                        else {flag = 0; break;}
                    }
                    if(flag == 1){
                        valor+=cp.getPreco();
                        l.add(cp.getNome());
                    }
                 }
             }
             if(pacote != null) l.add(pacote);
        }
        return l;
    }
    
    /**
     * Atualiza o stock quando uma encomenda é colocada em execução.
     * @param config Lista do nome das componentes a diminuir o stock
     */  
    public void diminuiStock(List<String> config){        
        for(String s : config){
            int qt = fabrica.getStock().get(s).getQuantidade();
            fabrica.atualizaStock(s, qt-1);
        }
    }
}
