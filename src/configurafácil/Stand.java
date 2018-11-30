/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafácil;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author utilizador
 */
public class Stand {
    Map<String,Cliente> clientes;
    
    public Stand() {
        this.clientes = new HashMap<String,Cliente>();
    }

    public Map<String,Cliente> getClientes(){
        return this.clientes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Cliente getCliente(String nif){
        return this.clientes.get(nif);
    }
   
   public void setCliente(String nif, Cliente c){
       this.clientes.replace(nif,c);
   }

    public void addCliente(Cliente c){
        this.clientes.put(c.getNif(),c);
    }
    
}
