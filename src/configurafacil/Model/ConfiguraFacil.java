/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author mercy
 */
public class ConfiguraFacil {
    private Stand stand;
    private Fabrica fabrica;
    private List<Utilizador> utilizadores;
    
    public ConfiguraFacil(){
        this.stand = new Stand();
        this.fabrica = new Fabrica();
        this.utilizadores = new ArrayList<>();
    }
    
    
    public ConfiguraFacil(Stand s, Fabrica f, List<Utilizador> u){
        this.stand = s.clone();
        this.fabrica = f.clone();
        this.utilizadores = u.stream().collect(Collectors.toList());
    }
    
    public Stand getStand(){
        return this.stand;
    }
    
    public Fabrica getFabrica(){
        return this.fabrica;
    }
    
    public List<Utilizador> getUtilizadores(){
        return this.utilizadores.stream().collect(Collectors.toList());
    }
    
    public void setStand(Stand s){
        this.stand = s.clone();
    }
    
    public void setFabrica(Fabrica f){
        this.fabrica = f.clone();
    }
    
    public void setUtilizadores(List<Utilizador> u){
        this.utilizadores = u.stream().map(Utilizador :: clone).collect(Collectors.toList());
    }
    
    public void addUtilizador(Utilizador u){
        this.utilizadores.add((Utilizador) u.clone());
    }
    
}
