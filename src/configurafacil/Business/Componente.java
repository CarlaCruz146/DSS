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
 * @author mercy
 */
public class Componente {
    private String nome;
    private double preco;
    private List<String> compIncompativeis;
    private List<String> compObrigatorias;
    
    
    public Componente(){
        this.nome = "";
        this.preco = 0;
        this.compIncompativeis = new ArrayList<>();
        this.compObrigatorias = new ArrayList<>();  
    }
    
    public Componente(String nome, double preco, List<String> incompativeis, List<String> obrigatorias){
        this.nome = nome;
        this.preco = preco;
        setIncompativeis(incompativeis);
        setObrigatorias(obrigatorias);
    }
    
    public Componente(Componente c){
        this.nome = c.getNome();
        this.preco = c.getPreco();
        this.compIncompativeis = c.getIncompativeis();
        this.compObrigatorias =  c.getObrigatorias();
    }
    
    public String getNome(){
        return this.nome;
    }
   
    public double getPreco(){
        return this.preco;
    }
    
    public List<String> getIncompativeis(){
        return this.compIncompativeis.stream().collect(Collectors.toList());
    }
    
    public List<String> getObrigatorias(){
        return this.compObrigatorias.stream().collect(Collectors.toList());
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(double p){
        this.preco = p;
    }
    
    public void setIncompativeis(List<String> incomp){
        this.compIncompativeis = new ArrayList<>();
        for(String s : compIncompativeis)
            this.compIncompativeis.add(s);
    }
    
    public void setObrigatorias(List<String> obrig){
        this.compObrigatorias = new ArrayList<>();
        for(String s : compObrigatorias)
            this.compObrigatorias.add(s);
    }
    
    public Componente clone(){
        return new Componente(this);
    }
    
    public boolean equals (Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Componente c = (Componente) o;
        
        return c.getNome().equals(this.nome) && c.getPreco() == this.preco
                && c.getIncompativeis().equals(this.compIncompativeis)
                && c.getObrigatorias().equals(this.compObrigatorias);
    }
    
    public void insereObrigatoria(String c){
        if (this.compObrigatorias == null) this.compObrigatorias = new ArrayList<>();
        this.compObrigatorias.add(c);
    }
    
    public void insereIncompativel(String c){
        if (this.compIncompativeis == null) this.compIncompativeis = new ArrayList<>();
        this.compIncompativeis.add(c);
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("A componente ");
        sb.append(this.nome);
        sb.append(" custa ");
        sb.append(this.preco);
        sb.append(" euros.");
        sb.append(" Componentes Incompativeis: ");
        sb.append(this.compIncompativeis);
        sb.append(" Componentes Obrigatorias: ");
        sb.append(this.compObrigatorias);
        sb.append(" .\n");
        return sb.toString();
    }
}