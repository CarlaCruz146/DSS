/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grupo 30
 */

public class Cliente {
    
    //Variáveis de instância
    private String nome;
    private String nif;
    private String contacto;
   // private List<Integer> encomendas;
    
    /**
     * Construtor da classe Utilizador sem parâmetros.
     */
    public Cliente(){
        this.nome = "";
        this.nif = ""; 
        this.contacto = "";
     //   this.encomendas = new ArrayList<>();
    }
    
    /**
     * Construtor da classe Cliente. 
     * @param nome Nome do cliente.
     * @param nif Nif do cliente.
     * @param contacto Contacto do cliente.
     * @param enc Encomendas do cliente.
     */
    public Cliente(String nome, String nif, String contacto, ArrayList<Integer> enc){
        this.nome = nome;
        this.nif = nif;
        this.contacto = contacto;
      //  this.encomendas = new ArrayList<>();
      //  if (enc == null) this.encomendas = null;
      //  else enc.forEach(a->this.encomendas.add((Integer) a));
    }
    
    /**
     * Construtor da classe Cliente pela cópia de uma classe.
     * @param c Cliente.
     */
    public Cliente(Cliente c){
        this.nome = c.getNome();
        this.nif = c.getNif();
        this.contacto = c.getContacto();
      //  this.encomendas = c.getEncomendas();
    }
    
    /**
     * Devolve o nome do cliente.
     * @return String 
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Devolve o nif do cliente.
     * @return String 
     */
    public String getNif(){
        return this.nif;
    }
    
    /**
     * Devolve o contacto do cliente.
     * @return String 
     */
    public String getContacto(){
        return this.contacto;
    }
    
   /* 
    public List<Integer> getEncomendas(){
        return this.encomendas;
    }*/
    
    /**
     * Altera o nome do cliente.
     * @param nome Nome do cliente.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o nif do cliente.
     * @param nif Nif do cliente.
     */
    public void setNif(String nif){
        this.nif = nif;
    }
    
    /**
     * Altera o contacto do cliente.
     * @param contacto Contacto do cliente.
     */
    public void setContacto(String contacto){
        this.contacto = contacto;
    }
    
    /*
    public void setEncomendas(ArrayList<Integer> enc){
        this.encomendas = new ArrayList<>();
        enc.forEach(a->this.encomendas.add(a));
    }
    
    public void addEncomenda(Encomenda e){
        if (this.encomendas == null) this.encomendas = new ArrayList<>();
        this.encomendas.add(e.getId());
    }*/
    
    /**
     * Devolve String com a informação da classe Cliente.
     * @return String
     */
     public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O utilizador ");
        sb.append(this.nome);
        sb.append(" tem ");
        sb.append(this.nif);
        sb.append(" e ");
        sb.append(this.contacto);
        sb.append(" .\n");

        return sb.toString();
    }
    
     /**
     * Função equals da classe Cliente.
     * @param o Objecto
     * @return boolean
     */
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Cliente c = (Cliente) o;
        return c.getNome().equals(this.nome) && c.getNif().equals(this.nif);
    }
}
