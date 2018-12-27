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
public class Stock {
    
    //Variáveis de intância
    private int quantidade;
    private String componente;
    
    /**
     * Construtor da classe Stock sem parâmetros.
     */
    public Stock(){
        this.componente = "";
        this.quantidade = 0;
    }
    
    /**
     * Construtor da classe Stock. 
     * @param q Quantidade de stock.
     * @param c Componente do stock.
     */
    public Stock(int q, String c){
        this.quantidade = q;
        this.componente = c;
    }
    
    /**
     * Construtor da classe Stock pela cópia de uma classe.
     * @param c Stock.
     */
    public Stock(Stock c){
        this.quantidade = c.getQuantidade();
        this.componente = c.getComponente();
    }
    
    /**
     * Devolve a quantidade de stock.
     * @return int
     */
    public int getQuantidade(){
        return this.quantidade;
    }
    
    /**
     * Devolve a componente do stock.
     * @return String
     */
    public String getComponente(){
        return this.componente;
    }
    
    /**
     * Altera o quantidade do stock.
     * @param q Quantidade do stock.
     */
    public void setQuantidade(int q){
        this.quantidade = q;
    }
    
    /**
     * Altera a componente do stock.
     * @param c Componente do stock.
     */
    public void setComponente(String c){
        this.componente = c;
    }
    
}
