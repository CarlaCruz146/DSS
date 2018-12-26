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
public class Stock {
    private int quantidade;
    private String componente;
    
        public Stock(){
        this.componente = "";
        this.quantidade = 0;
    }
    
    public Stock(int q, String c){
        this.quantidade = q;
        this.componente = c;
    }
    
    public Stock(Stock c){
        this.quantidade = c.getQuantidade();
        this.componente = c.getComponente();
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public String getComponente(){
        return this.componente;
    }
    
    public void setQuantidade(int q){
        this.quantidade = q;
    }
    
    public void setComponente(String c){
        this.componente = c;
    }
    
}
