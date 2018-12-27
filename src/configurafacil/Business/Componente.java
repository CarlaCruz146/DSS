/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Grupo 30
 */
public class Componente {
    
    //Variáveis de instância
    private String nome;
    private String tipo;
    private double preco;
    private List<String> compIncompativeis;
    private List<String> compObrigatorias;
    
    /**
     * Construtor da classe Componente sem parâmetros.
     */
    public Componente(){
        this.nome = "";
        this.tipo = "";
        this.preco = 0;
        this.compIncompativeis = new ArrayList<>();
        this.compObrigatorias = new ArrayList<>();  
    }
    
    /**
     * Construtor da classe Componente. 
     * @param nome Nome da componente.
     * @param tipo Tipo da componente.
     * @param preco Preço da componente.
     * @param incompativeis Lista de componentes incompativeis.
     * @param obrigatorias Lista de componentes obrigatórias.
     */
    public Componente(String nome, String tipo, double preco, List<String> incompativeis, List<String> obrigatorias){
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.compIncompativeis = new ArrayList<String>();
        if (incompativeis!=null) setIncompativeis(incompativeis);
        this.compObrigatorias = new ArrayList<String>();
        if (obrigatorias!=null) setObrigatorias(obrigatorias);
    }
    
    /**
     * Construtor da classe Componente pela cópia de uma classe.
     * @param c Componente.
     */
    public Componente(Componente c){
        this.nome = c.getNome();
        this.tipo = c.getTipo();
        this.preco = c.getPreco();
        this.compIncompativeis = c.getIncompativeis();
        this.compObrigatorias =  c.getObrigatorias();
    }
    
    /**
     * Devolve a nome da componente.
     * @return String 
     */
    public String getNome(){
        return this.nome;
    }
   
    /**
     * Devolve o tipo da componente.
     * @return String 
     */
    public String getTipo(){
        return this.tipo;
    }
    
    /**
     * Devolve o preço da componente.
     * @return double 
     */
    public double getPreco(){
        return this.preco;
    }
    
    
    public List<String> getIncompativeis(){
        return this.compIncompativeis.stream().collect(Collectors.toList());
    }
    
    public List<String> getObrigatorias(){
        return this.compObrigatorias.stream().collect(Collectors.toList());
    }
    
    /**
     * Altera o nome da componente.
     * @param nome Nome da componente.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o tipo da componente.
     * @param tipo Tipo da componente.
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    /**
     * Altera o preço da componente.
     * @param p Preço da componente.
     */
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setIncompativeis(List<String> incomp){
        for(String s : incomp)
            this.compIncompativeis.add(s);
    }
    
    public void setObrigatorias(List<String> obrig){
        for(String s : obrig)
            this.compObrigatorias.add(s);
    }
    
    /**
     * Função equals da classe Componente.
     * @param o Objecto
     * @return boolean
     */
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Componente c = (Componente) o;
        
        return c.getNome().equals(this.nome) && c.getPreco() == this.preco
                && c.getIncompativeis().equals(this.compIncompativeis)
                && c.getObrigatorias().equals(this.compObrigatorias);
    }
    
    public void insereObrigatoria(String c){
        this.compObrigatorias.add(c);
    }
    
    public void insereIncompativel(String c){
        this.compIncompativeis.add(c);
    }
    
    /**
     * Devolve String com a informação da classe Componente.
     * @return String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("A componente é ");
        sb.append(this.nome);
        sb.append(" que é do ");
        sb.append(this.tipo);
        sb.append(" com preço");
        sb.append(this.tipo);
        sb.append(" .\n");

        return sb.toString();
    }
   
}