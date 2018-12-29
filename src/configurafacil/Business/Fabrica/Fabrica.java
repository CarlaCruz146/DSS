/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica;

import configurafacil.Database.StockDAO;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author Grupo 30
 */
public class Fabrica {
    
    //Variáveis de instância
    private int id;
    private StockDAO stock;
    
    /**
     * Construtor da classe Stock sem parâmetros.
     */
    public Fabrica(){
        this.stock = new StockDAO();
    }
    
    /**
     * Devolve o id da fábrica.
     * @return int
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Altera o id da fábrica.
     * @param id Id do fábrica.
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Devolve o stock da fábrica.
     * @return Map 
     */
    public Map<String, Stock> getStock(){
        return this.stock.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));    
    }
    
     /**
     * Adiciona stock à fábrica.
     * @param c Compenente a adiconar ao stock.
     * @param s Stock da fábrica.
     */
    public void adicionaStock(String c, Stock s){
        this.stock.put(c, s);
    }
    
     /**
     * Verifica quantidade de stock da fábrica.
     * @param s Stock da fábrica.
     * @return int 
     */
    public int verificaStock(String s){
        return this.stock.get(s).getQuantidade();
    }
    
    /**
     * Atualiza stock da fábrica.
     * @param s Componente do stock a atualizar da fábrica.
     * @param q Quantidade de stock 
     */
    public void atualizaStock(String s, int q){
        Stock st = new Stock(q,s);
        this.stock.put(s, st);
    }
}
