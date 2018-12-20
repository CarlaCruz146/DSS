/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 *
 * @author utilizador
 */
public class Stand {
    private Map<String,Cliente> clientes;
    private Map<String,Componente> componentes;
    private Map<String,Pacote> pacotes;
    
    public Stand() {
        this.clientes = new HashMap<>();
        this.componentes = new HashMap<>();
        this.pacotes = new HashMap<>();
    }

    public Map<String,Cliente> getClientes(){
        return this.clientes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Map<String,Componente> getComponentes(){
        return this.componentes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Map<String,Pacote> getPacote(){
        return this.pacotes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Cliente getCliente(String nif){
        return this.clientes.get(nif);
    }
    
    public Componente getComponente(String nome){
        return this.componentes.get(nome);
    }
    
    public Pacote getPacote(String nome){
        return this.pacotes.get(nome);
    }
   
   public void setCliente(String nif, Cliente c){
       this.clientes.replace(nif,c);
   }

    public void addCliente(Cliente c){
        this.clientes.put(c.getNif(),c);
    }
    
    public void addComponente(Componente c){
        this.componentes.put(c.getNome(),c);
    }
    
    public void addPacote(Pacote p){
        this.pacotes.put(p.getNome(),p);
    }
    
    public void addEncomendaCliente(Cliente c, Encomenda e) {
        this.clientes.get(c.getNif()).addEncomenda(e);
    }
    
       public Encomenda sugestao(double limite){
        Encomenda e = new Encomenda();
        double valor = 0;
        if(limite >= 1800 && limite <2700) {
            Pacote p = this.pacotes.get("Pacote Comfort");
            valor = p.getPreco();
            e.setPacote(p);
            for(Componente c : this.componentes.values()){
                boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                double v = c.getPreco();
                if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && e.verificaIncomp(c).isEmpty()){
                    e.addToConfiguracao(c);
                    valor += v;
                }
            }   
        }
        else {
            if (limite >= 2700) {
                double max = 0;
                Componente comp = null;
                Pacote p = this.pacotes.get("Pacote Sport");
                valor = p.getPreco();
                e.setPacote(p);
                for(Componente c : this.componentes.values()){
                    boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                    double v = c.getPreco();
                    if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && e.verificaIncomp(c).isEmpty()){
                        if(c.getTipo().equals("Estofo")){
                            if(max < v){
                                max = v;
                                if (comp == null){
                                    e.addToConfiguracao(c);
                                    comp = c;
                                    valor += v;
                                }
                                else {
                                    e.removeDaConfiguracao(comp);
                                    e.addToConfiguracao(c);
                                    valor -= comp.getPreco();
                                    valor += v;
                                    comp = c;
                                }
                            }
                        }  
                        else {
                            valor += v;
                            e.addToConfiguracao(c);
                        }
                    }
                }
            }
            else {
                for(Componente c : this.componentes.values()){
                    boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                    double v = c.getPreco();
                    if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && e.verificaIncomp(c).isEmpty()){
                       e.addToConfiguracao(c);
                       valor += v;
                    }
                }
            }
        }
        return e;
    }
}
