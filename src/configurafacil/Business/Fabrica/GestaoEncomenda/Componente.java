/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica.GestaoEncomenda;

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
     * @param incompativeis Lista dos nomes das componentes incompativeis.
     * @param obrigatorias Lista dos nomes das componentes obrigatórias.
     */
    public Componente(String nome, String tipo, double preco, List<String> incompativeis, List<String> obrigatorias){
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.compIncompativeis = new ArrayList<>();
        if (incompativeis!=null) setIncompativeis(incompativeis);
        this.compObrigatorias = new ArrayList<>();
        if (obrigatorias!=null) setObrigatorias(obrigatorias);
    }
    
    /**
     * Construtor por cópia da classe Componente.
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
     * Devolve o nome da componente.
     * @return nome
     */
    public String getNome(){
        return this.nome;
    }
   
    /**
     * Devolve o tipo da componente.
     * @return tipo
     */
    public String getTipo(){
        return this.tipo;
    }
    
    /**
     * Devolve o preço da componente.
     * @return preço 
     */
    public double getPreco(){
        return this.preco;
    }
    
     /**
     * Devolve a lista dos nomes das componentes incompatíveis.
     * @return List
     */   
    public List<String> getIncompativeis(){
        return this.compIncompativeis.stream().collect(Collectors.toList());
    }
    
    /**
     * Devolve a lista dos nomes das componentes obrigatórias.
     * @return List
     */
    public List<String> getObrigatorias(){
        return this.compObrigatorias.stream().collect(Collectors.toList());
    }
    
    /**
     * Altera o nome da componente.
     * @param nome Novo nome da componente
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o tipo da componente.
     * @param tipo Novo tipo da componente
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    /**
     * Altera o preço da componente.
     * @param p Novo preço da componente
     */
    public void setPreco(double p){
        this.preco = p;
    }
    
    /**
     * Altera as componentes incompatíveis da componente.
     * @param incomp Nomes das novas componentes incompatíveis
     */
    public void setIncompativeis(List<String> incomp){
        for(String s : incomp)
            this.compIncompativeis.add(s);
    }
    
    /**
     * Altera as componentes obrigatórias da componente.
     * @param obrig Nomes das novas componentes obrigatórias
     */
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
    /**
     * Insere o nome de dada componente obrigatória.
     * @param c Nome da componente obrigatória a adicionar
     */
    public void insereObrigatoria(String c){
        this.compObrigatorias.add(c);
    }
    
    /**
     * Insere o nome de dada componente incompatível.
     * @param c Nome da componente incompatível a adicionar
     */
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