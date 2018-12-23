/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;
import configurafacil.Database.ClienteDAO;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author utilizador
 */
public class Stand {
    private int id;
    private ClienteDAO clientes;

    
    public Stand() {
        this.clientes = null;
    }
    
    public int getId(){
        return this.id;
    }
    
    public Map<String,Cliente> getClientes(){
        return this.clientes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Cliente getCliente(String nif){
        return this.clientes.get(nif);
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setClientes(ClienteDAO c){
        this.clientes = c;
    }
    
   public void setCliente(String nif, Cliente c){
       this.clientes.replace(nif,c);
   }

    public void addCliente(Cliente c){
        this.clientes.put(c.getNif(),c);
    }
    /*
    public void addEncomendaCliente(Cliente c, Encomenda e) {
        this.clientes.get(c.getNif()).addEncomenda(e);
    }*/
}
