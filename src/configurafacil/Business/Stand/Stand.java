/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Stand;
import configurafacil.Database.ClienteDAO;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Grupo 30
 */
public class Stand {

    //Variáveis de intância    
    private int id;
    private ClienteDAO clientes;

    /**
     * Construtor da classe Stand sem parâmetros.
     */
    public Stand() {
        this.clientes = new ClienteDAO();
    }
    
    /**
     * Devolve o id do stand.
     * @return int
     */
    public int getId(){
        return this.id;
    }
    
    /**
     * Devolve os clientes do stand.
     * @return Map 
     */
    public Map<String,Cliente> getClientes(){
        return this.clientes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
     * Devolve um cliente do stando com certo nif.
     * @param nif String.
     * @return int
     */
    public Cliente getCliente(String nif){
        return this.clientes.get(nif);
    }
    
    /**
     * Altera o id do stand.
     * @param id Id do stand.
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Altera os clientes do stand.
     * @param c ClienteDAO do stand.
     */
    public void setClientes(ClienteDAO c){
        this.clientes = c;
    }
    
    /**
     * Altera um cliente do stand.
     * @param nif Nif do cliente do stand.
     * @param c Cliente do stand.
     */
    public void setCliente(String nif, Cliente c){
       this.clientes.replace(nif,c);
    }

    /**
     * Adiciona um cliente ao stand.
     * @param c Cliente do stand.
     */
    public void addCliente(Cliente c){
        this.clientes.put(c.getNif(),c);
    }
    public void addCliente(String nome, String nif, String contacto){
        if(!this.clientes.containsKey(nif)){
            Cliente c = new Cliente(nome,nif,contacto);
            this.clientes.put(c.getNif(),c);
        }
    }
}
