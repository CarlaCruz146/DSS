/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import configurafacil.Database.StockDAO;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author mercy
 */
public class Fabrica {
    private int id;
    private StockDAO stock;
    
    public Fabrica(){
        this.stock = new StockDAO();
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Map<String, Stock> getStock(){
        return this.stock.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));    
    }
    
    public void adicionaStock(String c, Stock s){
        this.stock.put(c, s);
    }
    
    public int verificaStock(String s){
        return this.stock.get(s).getQuantidade();
    }
    
    public void atualizaStock(String s, int q){
        Stock st = new Stock(q,s);
        this.stock.put(s, st);
    }
}
