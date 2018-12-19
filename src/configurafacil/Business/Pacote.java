/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author jessica
 */
public class Pacote {
    private String nome;
    private double preco;
    private List<Componente> componentes;
    
     public Pacote(){
        this.nome = "";
        this.preco = 0;
        this.componentes = new ArrayList<>();
    }
    
    public Pacote(String nome, double preco, List<Componente> componentes){
        this.nome = nome;
        this.preco = preco;
        setComponentes(componentes);
    }
    
    public Pacote(Pacote c){
        this.nome = c.getNome();
        this.preco = c.getPreco();
        this.componentes = c.getComponentes();
    }
    
    public String getNome(){
        return this.nome;
    }
   
    public double getPreco(){
        return this.preco;
    }
    
    public List<Componente> getComponentes(){
        return this.componentes.stream().collect(Collectors.toList());
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setComponentes(List<Componente> comp){
        this.componentes = new ArrayList<>();
        for(Componente s : comp)
            this.componentes.add(s);
    }  
    
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Pacote u = (Pacote) o;
        return u.getNome().equals(this.nome) 
                && u.getPreco() == this.preco;
    }
    
        
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("O pacote é ");
        sb.append(this.nome);
        sb.append(" com preço");
        sb.append(this.preco);
        sb.append(" .\n");

        return sb.toString();
    }
}
