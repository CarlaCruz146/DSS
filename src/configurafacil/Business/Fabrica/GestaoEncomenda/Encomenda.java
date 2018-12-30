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
