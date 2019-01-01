/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Stand;

/**
 *
 * @author Grupo 30
 */

public class Cliente {
    
    //Variáveis de instância
    private String nome;
    private String nif;
    private String contacto;
    
    /**
     * Construtor da classe Utilizador sem parâmetros.
     */
    public Cliente(){
        this.nome = "";
        this.nif = ""; 
        this.contacto = "";
    }
    
    /**
     * Construtor da classe Cliente. 
     * @param nome Nome do cliente.
     * @param nif Nif do cliente.
     * @param contacto Contacto do cliente.
     */
    public Cliente(String nome, String nif, String contacto){
        this.nome = nome;
        this.nif = nif;
        this.contacto = contacto;
    }
    
    /**
     * Construtor por cópia da classe Cliente.
     * @param c Cliente.
     */
    public Cliente(Cliente c){
        this.nome = c.getNome();
        this.nif = c.getNif();
        this.contacto = c.getContacto();
    }
    
    /**
     * Devolve o nome do cliente.
     * @return nome
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Devolve o nif do cliente.
     * @return nif
     */
    public String getNif(){
        return this.nif;
    }
    
    /**
     * Devolve o contacto do cliente.
     * @return contacto
     */
    public String getContacto(){
        return this.contacto;
    }
    
    /**
     * Altera o nome do cliente.
     * @param nome Novo nome do cliente
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o nif do cliente.
     * @param nif Novo nif do cliente
     */
    public void setNif(String nif){
        this.nif = nif;
    }
    
    /**
     * Altera o contacto do cliente.
     * @param contacto Novo contacto do cliente
     */
    public void setContacto(String contacto){
        this.contacto = contacto;
    }

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
