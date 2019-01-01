/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Stand;
import configurafacil.Database.ClienteDAO;
import java.util.ArrayList;
import java.util.List;

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
     * @return id
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
     * Devolve o cliente do stand com determinado nif.
     * @param nif Nif do cliente
     * @return Cliente
     */
    public Cliente getCliente(String nif){
        return this.clientes.get(nif);
    }
    
    /**
     * Altera o id do stand.
     * @param id Novo id do stand
     */
    public void setId(int id){
        this.id = id;
    }
    
    /**
     * Altera os clientes do stand.
     * @param c ClienteDAO do stand
     */
    public void setClientes(ClienteDAO c){
        this.clientes = c;
    }
    
    /**
     * Altera um cliente do stand.
     * @param nif Nif do cliente
     * @param c Cliente do stand
     */
    public void setCliente(String nif, Cliente c){
       this.clientes.replace(nif,c);
    }

    /**
     * Adiciona um cliente ao stand.
     * @param nome Nome do cliente
     * @param nif Nif do cliente
     * @param contacto Contacto do cliente
     */
    public void addCliente(String nome, String nif, String contacto){
        if(!this.clientes.containsKey(nif)){
            Cliente c = new Cliente(nome,nif,contacto);
            this.clientes.put(c.getNif(),c);
        }
    }
}
