/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author Grupo 30
 */
public abstract class Utilizador {
    
    //Variáveis de intância
    private String nome;
    private String password;
    private int estado; //0 - ativo
    
    /**
     * Construtor da classe Utilizador sem parâmetros.
     */
    public Utilizador(){
        this.nome = "";
        this.password = "";
        this.estado = 0;
    }
    
    /**
     * Construtor da classe Utilizador. 
     * @param nome Nome do utilizador.
     * @param password Password do utilizador.
     * @param estado Estado do utilizador.
     */
    public Utilizador(String nome, String password, int estado){
        this.nome = nome;
        this.password = password;
        this.estado = estado;
    }
    
    /**
     * Construtor da classe Utilizador pela cópia de uma classe.
     * @param u Utilizador.
     */
    public Utilizador(Utilizador u){
        this.nome = u.getNome();
        this.password = u.getPassword();
        this.estado = u.getEstado();
    }
    
    /**
     * Devolve o nome do utilizador.
     * @return String
     */
    public String getNome(){
        return this.nome;
    }
    
    /**
     * Devolve a password do utilizador.
     * @return String 
     */
    public String getPassword(){
        return this.password;
    }
    
    /**
     * Devolve a estado do utilizador.
     * @return int 
     */
    public int getEstado(){
        return this.estado;
    }
    
    /**
     * Altera o nome do utilizador.
     * @param nome Nome do utilizador.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Altera o estado do utilizador.
     * @param estado Estado do utilizador.
     */
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    /**
     * Altera a password do utilizador.
     * @param password Password do utilizador.
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Devolve String com a informação da classe Utilizador.
     * @return String
     */
     public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O utilizador ");
        sb.append(this.nome);
        sb.append(" .\n");

        return sb.toString();
    }
    
     /**
     * Função equals da classe Utilizador.
     * @param o Objecto
     * @return boolean
     */
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Utilizador u = (Utilizador) o;
        return u.getNome().equals(this.nome) && u.getPassword().equals(this.password);
    }
   
}
