/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String nif;
    private String contacto;
    private double limite;
    private ArrayList<Integer> encomendas;
    
    public Cliente(){
        this.nome = "";
        this.nif = ""; 
        this.contacto = "";
        this.limite = 0;
        this.encomendas = new ArrayList<>();
    }
    
    public Cliente(String nome, String nif, String contacto, double limite, ArrayList<Integer> enc){
        this.nome = nome;
        this.nif = nif;
        this.contacto = contacto;
        this.limite = limite;
        this.encomendas = new ArrayList<>();
        if (enc == null) this.encomendas = null;
        else enc.forEach(a->this.encomendas.add((Integer) a));
    }
    
    public Cliente(Cliente c){
        this.nome = c.getNome();
        this.nif = c.getNif();
        this.contacto = c.getContacto();
        this.limite = c.getLimite();
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
    
    public double getLimite(){
        return this.limite;
    }
    
    public ArrayList<Integer> getEncomendas(){
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
    
    public void setLimite(double l){
        this.limite = l;
    }
    
    public void setEncomendas(ArrayList<Integer> enc){
        this.encomendas = new ArrayList<>();
        enc.forEach(a->this.encomendas.add(a));
    }
    
    public void addEncomenda(Encomenda e){
        if (this.encomendas == null) this.encomendas = new ArrayList<>();
        this.encomendas.add(e.getId());
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
        return c.getNome().equals(this.nome) && c.getNif().equals(this.nif) && c.getLimite()==this.limite;
    }
}
