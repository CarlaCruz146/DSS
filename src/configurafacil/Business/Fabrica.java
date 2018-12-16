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

    private HashMap<Integer,Encomenda> encomendas;
    private Map<String,Integer> stock;
    
    public Fabrica(){
        this.encomendas = new HashMap<>();
        this.stock = new HashMap<>();
    }
    
    public Fabrica(Map<String,Integer> s, HashMap<Integer,Encomenda> encs){
        setStock(s);
        setEncomendas(encs);
    }
    
    public Fabrica(Fabrica f){
        this.encomendas = f.getEncomendas();
        this.stock = f.getStock();
    }
    
    public Fabrica clone(){
        return new Fabrica(this);
    }
    
    public Map<String, Integer> getStock(){
        return this.stock.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));    
    }
    
    public HashMap<Integer,Encomenda> getEncomendas(){
        HashMap<Integer,Encomenda> res = new HashMap<>();
        for(Encomenda e : this.encomendas.values())
            res.put(e.getId(), (Encomenda) e.clone());
        return res;
    }
        
    public void setStock(Map<String, Integer> s){
        this.stock = new HashMap<>();
        this.stock = s.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue())); 
    }
    
    public void setEncomendas(HashMap<Integer,Encomenda> novasEncs){
        this.encomendas = new HashMap<>();
        for(Encomenda e : novasEncs.values())
            this.encomendas.put(e.getId(),(Encomenda)e.clone());
        
    }
    
    public void addEncomenda(Encomenda e){
        this.encomendas.put(e.getId(),(Encomenda)e.clone());
    }
    
    public void removeEncomenda(Integer id){
        this.encomendas.remove(id);
    }
    
}
