/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author Grupo 30
 */
public class Carro {
    
    //Variáveis de decisão
    private String nome;
    private double preco;
    
    /**
     * Construtor da classe Utilizador sem parâmetros.
     */
    public Carro(){
        this.nome = "";
        this.preco = 0;
    }
    
    /**
     * Construtor da classe Carro. 
     * @param c Nome do carro.
     * @param p Preço do carrp.
     */
    public Carro(String c, double p){
        this.nome = c;
        this.preco = p;
    }
    
    /**
     * Construtor da classe Carro pela cópia de uma classe.
     * @param c Carro.
     */
    public Carro(Carro c){
        this.nome = c.getNome();
        this.preco = c.getPreco();
    }
    
    /**
     * Devolve o nome do carro.
     * @return String
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Devolve o preço do carro.
     * @return double
     */
    public double getPreco(){
        return this.preco;
    }
    
    /**
     * Altera o nome do carro.
     * @param nome Nome do carro.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o preço do carro.
     * @param preco Preço do carro.
     */
    public void setPreco(double preco){
        this.preco = preco;
    }
}
