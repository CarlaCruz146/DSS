/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author jessica
 */
public class Carro {
    private String nome;
    private double preco;
    
    public Carro(){
        this.nome = "";
        this.preco = 0;
    }
    
    public Carro(String c, double p){
        this.nome = c;
        this.preco = p;
    }
    
    public Carro(Carro c){
        this.nome = c.getNome();
        this.preco = c.getPreco();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
}
