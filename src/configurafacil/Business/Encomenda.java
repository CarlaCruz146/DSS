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
import java.util.Map;
import java.util.stream.Collectors;

public class Encomenda {
    private int id;
    private String carro;
    private int estado;
    private List<String> configuracao;
    private String pacote;
    private String cliente;
    
    public Encomenda() {
        this.id = 0;
        this.carro = "";
        this.estado = 0; // 0 em espera
        this.configuracao = new ArrayList<>();
        this.pacote = "";
        this.cliente = "";
    }
    
    public Encomenda(int id, String carro, int estado, List<String> config, String pacote, String cliente){
        this.id = id;
        this.carro = carro;
        this.estado = estado;
        this.configuracao = new ArrayList<>();
        if (config != null) this.configuracao = config.stream().collect(Collectors.toList());
        this.pacote = pacote;
        this.cliente = cliente;
    }
    
    public Encomenda(Encomenda e){
        this.id = e.getId();
        this.carro = e.getCarro();
        this.estado = e.getEstado();
        this.configuracao = e.getConfig();
        this.pacote = e.getPacote();
        this.cliente = e.getCliente();
    }
    
    public String getCliente(){
        return this.cliente;
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
    
    public List<String> getConfig(){
        return this.configuracao.stream().collect(Collectors.toList());
    }
    
    public String getPacote(){
        return this.pacote;
    }
    
    public Integer getNConfig(){
        return this.configuracao.size();
    }
    public void addToConfiguracao(String c){
        this.configuracao.add(c);
    }
    
    public void removeDaConfiguracao(String c){
        this.configuracao.remove(c);
    }
    
    public void addCarro(String carro){
        this.carro = carro;
    }
    
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public void setCarro(String c){
        this.carro = c;
    }
    
    public void setEstado(int e){
        this.estado = e;
    }
    
    public void setPacote(String pacote){
        this.pacote = pacote;
    }
   
    
    public void setConfig(List<String> c){
        this.configuracao = c.stream().collect(Collectors.toList());
    }
    
    public boolean verificaComponentes(Map<String,Componente> comp){
        int i = 0;
        for(String s: this.configuracao){
            Componente c = comp.get(s);
            if(c.getTipo().equals("Pintura") || c.getTipo().equals("Motor") || c.getTipo().equals("Pneu") || c.getTipo().equals("Jante"))
                i++;
        }
        boolean n = i == 4;
        return n;
    }
    
    public Componente verificaTipo(String tipo, Map<String,Componente> componente){
        Componente comp = null, c = null;
        for(String s: this.configuracao){
            c = componente.get(s);
            if(c.getTipo().equals(tipo)){
                comp = c;
                return comp;
            }       
        }
        return comp;
    }
        
    public List<String> verificaIncomp(Componente c, Pacote p){
        List<String> incomp = new ArrayList<String>();
        for(String i : c.getIncompativeis())
            for(String j : this.configuracao){
                if(i.equals(j))
                    incomp.add(i); 
            }
        if(this.pacote!=null){
            for(String comp : p.getComponentes())
                for(String i : c.getIncompativeis())
                    if(i.equals(comp))
                        incomp.add(i);
        }
        return incomp;
    }
    
    public List<String> verificaObrig(Componente c){
        List<String> obrig = new ArrayList<String>();
        int flag = 0;
        for(String i : c.getObrigatorias()){
            if(this.configuracao.isEmpty()) obrig.add(i);
            for(String j : this.configuracao){
                if(i.equals(j))
                    flag = 1;
            }
            if(flag == 0) obrig.add(i);
            else flag = 0;
        } 
        return obrig;
    }
    
    public List<String> verificaObrigatoria(Map<String,Componente> componente){
        List<String> obrigatorio = new ArrayList<>();
        int flag = 0;
        for(String c : this.configuracao){
            Componente comp = componente.get(c);
            for(String s : comp.getObrigatorias()){
                for(String n : this.configuracao)
                    if(s.equals(n))
                        flag = 1;
            if(flag == 0) obrigatorio.add(s);
            else flag = 0;
            }
        }
        return obrigatorio;
    }
    
    public List<String> verificaIncompativel(Pacote p, Map<String,Componente> componentes){
        List<String> incomp = new ArrayList<String>();
        for(String str : p.getComponentes()){
            Componente c = componentes.get(str);
            for(String s : c.getIncompativeis())
                for(String comp : this.configuracao)
                    if(s.equals(comp))
                        incomp.add(s);
        }
        return incomp;
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
        sb.append(this.configuracao.toString());
        return sb.toString();
    }
}
