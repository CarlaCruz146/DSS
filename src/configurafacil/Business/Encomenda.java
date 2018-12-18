/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author utilizador
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda {
    private int id;
    private String carro;
    private int estado;
    private List <Componente> configuracao;
    
    public Encomenda() {
        this.id = 0;
        this.carro = "";
        this.estado = 0; // 0 em espera
        this.configuracao = new ArrayList<>();
    }
    
    public Encomenda(int id, String carro, int estado, List<Componente> config){
        this.id = id;
        this.carro = carro;
        this.estado = estado;
        this.configuracao = new ArrayList<>();
        if (config != null) this.configuracao = config.stream().collect(Collectors.toList());
    }
    
    public Encomenda(Encomenda e){
        this.id = e.getId();
        this.carro = e.getCarro();
        this.estado = e.getEstado();
        this.configuracao = e.getConfig();
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getCarro(){
        return this.carro;
    }
    
    public int getEstado(){
        return this.estado;
    }
    public List<Componente> getConfig(){
        return this.configuracao.stream().collect(Collectors.toList());
    }
    
    public void addToConfiguracao(Componente c){
        this.configuracao.add(c);
    }
    
    public void removeDaConfiguracao(Componente c){
        this.configuracao.remove(c);
    }
    
    public void addCarro(String carro){
        this.carro = carro;
    }
    
    public void setCarro(String c){
        this.carro = c;
    }
    
    public void setEstado(int e){
        this.estado = e;
    }
    
    public void setConfig(List<Componente> c){
        this.configuracao = c.stream().collect(Collectors.toList());
    }
    
    public boolean equals(Object o) {
        boolean b=false;

        if (o!= null && o instanceof Encomenda) {
            Encomenda e = (Encomenda)o;
            b = this.carro.equals(e.getCarro());
        }
        return b;
    }

    //Falta imprimir a lista dos arrays
    public String toString() {
        StringBuffer sb = new StringBuffer("Encomenda(");
        sb.append(this.carro);
        return sb.toString();
    }
}
