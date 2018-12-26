/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author jessica
 */
public abstract class Utilizador {
    private String nome;
    private String password;
    private int estado; //0 - ativo
    
    public Utilizador(){
        this.nome = "";
        this.password = "";
        this.estado = 0;
    }
    
    public Utilizador(String nome, String password, int estado){
        this.nome = nome;
        this.password = password;
        this.estado = estado;
    }
    
    public Utilizador(Utilizador u){
        this.nome = u.getNome();
        this.password = u.getPassword();
        this.estado = u.getEstado();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public int getEstado(){
        return this.estado;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setEstado(int estado){
        this.estado = estado;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
     public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O utilizador ");
        sb.append(this.nome);
        sb.append(" .\n");

        return sb.toString();
    }
    
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Utilizador u = (Utilizador) o;
        return u.getNome().equals(this.nome) && u.getPassword().equals(this.password);
    }
   
}
