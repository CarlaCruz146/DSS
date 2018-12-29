/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica.GestaoEncomenda;

/**
 *
 * @author Grupo 30
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Encomenda {
    
    //Variáveis de instância
    private int id;
    private String carro;
    private int estado;
    private List<String> configuracao;
    private String pacote;
    private String cliente;
    private double limite;
    
    /**
     * Construtor da classe Encomenda sem parâmetros.
     */
    public Encomenda() {
        this.id = 0;
        this.carro = "";
        this.estado = 0; // 0 em espera
        this.configuracao = new ArrayList<>();
        this.pacote = null;
        this.cliente = "";
        this.limite = 0;
    }
    
    /**
     * Construtor da classe Encomenda. 
     * @param id Id da encomenda.
     * @param carro Carro da encomenda.
     * @param config Configuração da encomenda.
     * @param pacote Pacote da encomenda.
     * @param cliente Cliente que pediu a encomenda.
     * @param limite Limite de preço da encomenda.
     */
    public Encomenda(int id, String carro, int estado, List<String> config, String pacote, String cliente, double limite){
        this.id = id;
        this.carro = carro;
        this.estado = estado;
        this.configuracao = new ArrayList<>();
        if (config != null) this.configuracao = config.stream().collect(Collectors.toList());
        this.pacote = pacote;
        this.cliente = cliente;
        this.limite = limite;
    }
    
    /**
     * Construtor da classe Encomenda pela cópia de uma classe.
     * @param e Encomenda.
     */
    public Encomenda(Encomenda e){
        this.id = e.getId();
        this.carro = e.getCarro();
        this.estado = e.getEstado();
        this.configuracao = e.getConfig();
        this.pacote = e.getPacote();
        this.cliente = e.getCliente();
        this.limite = e.getLimite();
    }
    
    /**
     * Devolve o nome do cliente da encomenda.
     * @return String
     */
    public String getCliente(){
        return this.cliente;
    }
    
    /**
     * Devolve o limite do preço da encomenda.
     * @return String
     */
    public double getLimite(){
        return this.limite;
    }
    
    /**
     * Devolve o id da encomenda.
     * @return String
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Devolve o carro da encomenda.
     * @return String
     */
    public String getCarro(){
        return this.carro;
    }
    
    /**
     * Devolve o estado da encomenda.
     * @return String
     */
    public int getEstado(){
        return this.estado;
    }
    
    /**
     * Devolve a confiragação da encomenda.
     * @return String
     */
    public List<String> getConfig(){
        return this.configuracao.stream().collect(Collectors.toList());
    }
    
    /**
     * Devolve o pacote da encomenda.
     * @return String
     */
    public String getPacote(){
        return this.pacote;
    }
    
    /**
     * Devolve o tamanho da configuração da encomenda.
     * @return String
     */
    public Integer getNConfig(){
        return this.configuracao.size();
    }
    
    /**
     * Devolve o nome do utilizador.
     * @return String
     */
    public void addToConfiguracao(String c){
        this.configuracao.add(c);
    }
    
    /**
     * Remove componente da configuração da encomenda.
     * @param c Componente da configuração da encomenda
     */
    public void removeDaConfiguracao(String c){
        this.configuracao.remove(c);
    }
        
    /**
     * Altera o nome do cliente.
     * @param cliente Nome do cliente.
     */
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    
    /**
     * Altera o id do encomenda.
     * @param id ID do encomenda.
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Altera o limite de preço da encomenda.
     * @param l Limite de preço da nome.
     */
    public void setLimite(double l){
        this.limite = l;
    }
    
    /**
     * Altera o carro da encomenda.
     * @param c Carro da encomenda.
     */    
    public void setCarro(String c){
        this.carro = c;
    }
    
    /**
     * Altera o estado da encomenda.
     * @param e Estado da encomenda.
     */
    public void setEstado(int e){
        this.estado = e;
    }
    
    /**
     * Altera o pacote da encomenda.
     * @param pacote Pacote da encomenda.
     */
    public void setPacote(String pacote){
        this.pacote = pacote;
    }
   
    /**
     * Altera a configuração da encomenda.
     * @param c Configuração da encomenda.
     */
    public void setConfig(List<String> c){
        this.configuracao = c.stream().collect(Collectors.toList());
    }
    
    /**
     * Verifica se todas as componetes básicas obrigatórias foram escolhidas
     * @param comp Componentes da configuração
     * @return boolean
     */
    public boolean verificaComponentes(Map<String,Componente> comp){
        int i = 0;
        for(String s: this.configuracao){
            Componente c = comp.get(s);
            if(c.getTipo().equals("Pintura") || c.getTipo().equals("Motor") || c.getTipo().equals("Pneu") || c.getTipo().equals("Jante"))
                i++;
        }
        boolean n = i == 4;
        return n;
    }
    
    /**
     * Devolve a componente de um determinado tipo
     * @param tipo Tipo da componente
     * @param comp Componentes da configuração
     */
    public Componente verificaTipo(String tipo, Map<String,Componente> componente){
        Componente comp = null, c = null;
        for(String s: this.configuracao){
            c = componente.get(s);
            if(c.getTipo().equals(tipo)){
                comp = c;
                return comp;
            }       
        }
        return comp;
    }

    /**
     * Devolve a lista de componentes incompativeis de um componente selecionado com um pacote
     * @param c Componente selecionado
     * @param p Pacote selecionado
     * @param Lista de componentes incompativeis
     */    
    public List<String> verificaIncomp(Componente c, Pacote p){
        List<String> incomp = new ArrayList<String>();
        for(String i : c.getIncompativeis())
            for(String j : this.configuracao){
                if(i.equals(j))
                    incomp.add(i); 
            }
        if(this.pacote!=null){
            for(String comp : p.getComponentes())
                for(String i : c.getIncompativeis())
                    if(i.equals(comp))
                        incomp.add(i);
        }
        return incomp;
    }

    /**
     * Devolve a lista de componentes obrigatórias que ainda não se encontram na encomenda
     * @param c Componente adicionada
     * @return Lista de componentes obrigatórias
     */    
    public List<String> verificaObrig(Componente c){
        List<String> obrig = new ArrayList<String>();
        int flag = 0;
        for(String i : c.getObrigatorias()){
            if(this.configuracao.isEmpty()) obrig.add(i);
            for(String j : this.configuracao){
                if(i.equals(j))
                    flag = 1;
            }
            if(flag == 0) obrig.add(i);
            else flag = 0;
        } 
        return obrig;
    }

    /**
     * Devolve a lista de componentes obrigatórias da encomenda não selecionadas
     * @param tipo Tipo da componente
     * @return Lista de componentes obrigatórias
     */    
    public List<String> verificaObrigatoria(Map<String,Componente> componente){
        List<String> obrigatorio = new ArrayList<>();
        int flag = 0;
        for(String c : this.configuracao){
            Componente comp = componente.get(c);
            for(String s : comp.getObrigatorias()){
                for(String n : this.configuracao)
                    if(s.equals(n))
                        flag = 1;
            if(flag == 0) obrigatorio.add(s);
            else flag = 0;
            }
        }
        return obrigatorio;
    }

    /**
     * Devolve a lista de componentes incompativeis com um pacote
     * @param p Pacote
     * @param componentes Componentes da configuração
     * @return lista de componentes incompativeis
     */    
    public List<String> verificaIncompativel(Pacote p, Map<String,Componente> componentes){
        List<String> incomp = new ArrayList<String>();
        for(String str : p.getComponentes()){
            Componente c = componentes.get(str);
            for(String s : c.getIncompativeis())
                for(String comp : this.configuracao)
                    if(s.equals(comp))
                        incomp.add(s);
        }
        return incomp;
    }

    /**
     * Função equals da classe Encomenda.
     * @param o Objecto
     * @return boolean
     */
    public boolean equals(Object o) {
        boolean b=false;

        if (o!= null && o instanceof Encomenda) {
            Encomenda e = (Encomenda)o;
            b = this.carro.equals(e.getCarro());
        }
        return b;
    }

    /**
     * Devolve String com a informação da classe Encomenda.
     * @return String
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("Encomenda(");
        sb.append(this.carro);
        sb.append(this.configuracao.toString());
        return sb.toString();
    }
}
