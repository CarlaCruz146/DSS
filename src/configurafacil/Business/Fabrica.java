/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Model;

import java.util.HashMap;
/**
 *
 * @author mercy
 */
public class Fabrica {

    private HashMap<Integer,Encomenda> encomendas;
    private int stock;
    
    public Fabrica(){
        this.encomendas = new HashMap<>();
        this.stock = 0;
    }
    
    public Fabrica(int s, HashMap<Integer,Encomenda> encs){
        this.stock = s;
        setEncomendas(encs);
    }
    
    public Fabrica(Fabrica f){
        this.encomendas = f.getEncomendas();
        this.stock = f.getStock();
    }
    
    public Fabrica clone(){
        return new Fabrica(this);
    }
    
    public int getStock(){
        return this.stock;
    }
    
    public HashMap<Integer,Encomenda> getEncomendas(){
        // return this.encomendas.values()
        //                      .stream()
        //                      .map(Encomenda:: clone)
        //                      .collect(Collectors.toMap(e->e.getId(), e->e.clone()));
        HashMap<Integer,Encomenda> res = new HashMap<>();
        for(Encomenda e : this.encomendas.values())
            res.put(e.getId(), (Encomenda) e.clone()); //pus assim pq o collect estava a dar erros
        return res;
    }
        
    public void setStock(int s){
        this.stock = s;
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
