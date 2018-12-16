/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Model;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String nif;
    private String contacto;
    private ArrayList<Encomenda> encomendas;
    
    public Cliente(){
        this.nome = "";
        this.nif = ""; 
        this.contacto = "";
        this.encomendas = new ArrayList<>();
    }
    
    public Cliente(String nome, String nif, String contacto, ArrayList enc){
        this.nome = nome;
        this.nif = nif;
        this.contacto = contacto;
        this.encomendas = new ArrayList<>();
        if (enc == null) this.encomendas = null;
        else enc.forEach(a->this.encomendas.add((Encomenda) a));
    }
    
    public Cliente(Cliente c){
        this.nome = c.getNome();
        this.nif = c.getNif();
        this.contacto = c.getContacto();
        this.encomendas = c.getEncomendas();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getNif(){
        return this.nif;
    }
    
    public String getContacto(){
        return this.contacto;
    }
    
    public ArrayList<Encomenda> getEncomendas(){
        return this.encomendas;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNif(String nif){
        this.nif = nif;
    }
    
    public void setContacto(String contacto){
        this.contacto = contacto;
    }
    
    public void setEncomendas(ArrayList<Encomenda> enc){
        this.encomendas = new ArrayList<>();
        enc.forEach(a->this.encomendas.add(a));
    }
    
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
    
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Cliente c = (Cliente) o;
        return c.getNome().equals(this.nome) && c.getNif().equals(this.nif);
    }
}
