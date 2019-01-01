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
public class Pacote {
    
    //Variáveis de instância
    private String nome;
    private double preco;
    private List<String> componentes;
    
    /**
     * Construtor da classe Pacote sem parâmetros.
     */
     public Pacote(){
        this.nome = "";
        this.preco = 0;
        this.componentes = new ArrayList<>();
    }
    
    /**
     * Construtor da classe Pacote. 
     * @param nome Nome do pacote.
     * @param preco Preço do pacote.
     * @param componentes Componentes do pacote.
     */
    public Pacote(String nome, double preco, List<String> componentes){
        this.nome = nome;
        this.preco = preco;
        this.componentes = new ArrayList<>();
        if(componentes!=null) setComponentes(componentes);
    }
   
    /**
     * Construtor por cópia da classe Pacote.
     * @param c Pacote.
     */
    public Pacote(Pacote c){
        this.nome = c.getNome();
        this.preco = c.getPreco();
        this.componentes = c.getComponentes();
    }
    
    /**
     * Devolve o nome do pacote.
     * @return nome
     */
    public String getNome(){
        return this.nome;
    }
   
    /**
     * Devolve o número de componentes do pacote.
     * @return número de componentes
     */
    public int getNComp(){
        return this.componentes.size();
    }
    
    /**
     * Devolve o preço do pacote.
     * @return preço
     */
    public double getPreco(){
        return this.preco;
    }
    
    /**
     * Devolve os nomes das componentes do pacote.
     * @return List
     */
    public List<String> getComponentes(){
        return this.componentes.stream().collect(Collectors.toList());
    }
    
    /**
     * Altera o nome do pacote.
     * @param nome Novo nome do pacote
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o preço do pacote.
     * @param p Novo preço do pacote
     */
    public void setPreco(double p){
        this.preco = p;
    }
    
    /**
     * Altera as componentes do pacote.
     * @param comp Lista dos nomes das novas componentes do pacote
     */
    public void setComponentes(List<String> comp){
        for (String s : comp){
           this.componentes.add(s);
        }
    }  
    
    /**
     * Função equals da classe Pacote.
     * @param o Objecto
     * @return boolean
     */
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Pacote u = (Pacote) o;
        return u.getNome().equals(this.nome) 
                && u.getPreco() == this.preco;
    }
    
    /**
     * Devolve String com a informação da classe Pacote.
     * @return String
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O pacote é ");
        sb.append(this.nome);
        sb.append(" com preço");
        sb.append(this.preco);
        sb.append(" .\n");

        return sb.toString();
    }
}
