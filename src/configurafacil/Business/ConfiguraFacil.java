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
public class ConfiguraFacil {
    private Stand stand;
    private Fabrica fabrica;
    private Utilizador utilizador;
    private GestaoUtilizadores gestaoU;
    
    public ConfiguraFacil(){
        this.stand = new Stand();
        this.fabrica = new Fabrica();
        this.utilizador = null;
        this.gestaoU = new GestaoUtilizadores();
        addFunc();
        addComp();
        addEnc();
    }
    
    public void addFunc() {
        Utilizador stand = new Utilizador("João Silva",1,"joao");
        gestaoU.addUtilizador(stand);
        Utilizador fabrica = new Utilizador("Carlos Costa",2,"carlos");
        gestaoU.addUtilizador(fabrica);
        Utilizador admin = new Utilizador("Admin",0,"admin");
        gestaoU.addUtilizador(admin);
    }
    
    public void addComp() {
        Componente c1 = new Componente("Couro comfort carvão","Estofo",15, null, null);
        stand.addComponente(c1);
        Componente c2 = new Componente("Jantes em liga leve 17''","Jante",2,null, null);
        stand.addComponente(c2);
        Componente c3 = new Componente("D4 190cv Man. 6 Vel.","Motor",2,null, null);
        stand.addComponente(c3);
        Componente c4 = new Componente("Preto","Pintura",2,null, null);
        stand.addComponente(c4);
        Componente c5 = new Componente("Bridgestone Turanza T005 205/55 R16 91V","Pneu",2,null, null);
        stand.addComponente(c5);
        Componente c6 = new Componente("Branco","Pintura",2,null, null);
        stand.addComponente(c6);
        Componente c7 = new Componente("Vidro Escurecido","Vidro",2,null, null);
        stand.addComponente(c7);
        Componente c8 = new Componente("Pacote Comfort","Pacote",2,null, null);
        stand.addComponente(c8);
    }
        
    public void addEnc() {
        Encomenda e1 = new Encomenda(1,"BMW", 1, null);
        fabrica.getGestaoE().addEncomenda(e1);
        Encomenda e2 = new Encomenda(1,"Mercedes", 0, null);
        fabrica.getGestaoE().addEncomenda(e2);
        Encomenda e3 = new Encomenda(1,"Volvo", 1, null);
        fabrica.getGestaoE().addEncomenda(e3);
    }
        
    public Stand getStand(){
        return this.stand;
    }
    
    public Fabrica getFabrica(){
        return this.fabrica;
    }
    
    public Utilizador getUtilizador(){
        return this.utilizador;
    }
    
    public GestaoUtilizadores getGestaoU(){
        return this.gestaoU;
    }
    
    public void login(String nome, String password){
        try{
            this.utilizador = gestaoU.verificaUtilizador(nome, password);
        }
        catch(Exception e){}
    }
    
    public void logout(){
        this.utilizador = null;
    }
}
