/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author mercy
 */
public class Fabrica {

    private GestaoEncomenda gestaoE;
    private Map<String,Integer> stock;
    
    public Fabrica(){
        this.gestaoE = new GestaoEncomenda();
        this.stock = new HashMap<>();
    }
    
    public GestaoEncomenda getGestaoE(){
        return this.gestaoE;
    }
    
    public Map<String, Integer> getStock(){
        return this.stock.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));    
    }
        
    public void setStock(Map<String, Integer> s){
        this.stock = new HashMap<>();
        this.stock = s.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue())); 
    }
}
