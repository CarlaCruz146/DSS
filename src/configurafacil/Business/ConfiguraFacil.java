/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;
import configurafacil.Database.CarroDAO;
import configurafacil.Database.ComponenteDAO;
import configurafacil.Database.FabricaDAO;
import configurafacil.Database.PacoteDAO;
import configurafacil.Database.StandDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author mercy
 */
public class ConfiguraFacil {
    private Administrador administrador;
    private StandDAO stand;
    private FabricaDAO fabrica;
    private Utilizador utilizador;
    private GestaoUtilizadores gestaoU;
    private GestaoEncomenda gestaoE;
    private ComponenteDAO componentes;
    private PacoteDAO pacotes;
    private CarroDAO carro;
    
    public ConfiguraFacil(){
        this.stand = new StandDAO();
        this.fabrica = new FabricaDAO();
        this.utilizador = null;
        this.administrador = new Administrador();
        this.gestaoU = new GestaoUtilizadores();
        this.gestaoE = new GestaoEncomenda();
        this.componentes = new ComponenteDAO();
        this.pacotes = new PacoteDAO();
        this.carro = new CarroDAO();
    }

    public Map<String,Componente> getComponentes(){
        return this.componentes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Map<String,Pacote> getPacote(){
        return this.pacotes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    public Componente getComponente(String nome){
        return this.componentes.get(nome);
    }
    
    public Pacote getPacote(String nome){
        return this.pacotes.get(nome);
    }
    
    public Carro getCarro(String nome){
        return this.carro.get(nome);
    }
           
    public Stand getStand(){
        return this.stand.get(1);
    }
    
    public Cliente getCliente(String nif){
        return this.stand.get(1).getCliente(nif);
    }
    
    public Fabrica getFabrica(){
        return this.fabrica.get(1);
    }
    
    public Administrador getAdministrador(){
        return this.administrador;
    }
    
    public Utilizador getUtilizador(){
        return this.utilizador;
    }
    
    public Utilizador getUser(String nome){
        return this.gestaoU.getUtilizador(nome);
    }
    
    public GestaoUtilizadores getGestaoU(){
        return this.gestaoU;
    }
    
    public GestaoEncomenda getGestaoE(){
        return this.gestaoE;
    }
    
    public Map<String,Utilizador> getUtilizadores(){
        return this.gestaoU.getUtilizadores();
    }
    
    public void setEstado(Utilizador u, int estado){
        this.gestaoU.setEstado(u, estado);
    }
    
    public void addComponente(Componente c){
        this.componentes.put(c.getNome(),c);
    }
    
    public void addPacote(Pacote p){
        this.pacotes.put(p.getNome(),p);
    }
    
    public void addUtilizador(Utilizador u) {
        this.gestaoU.addUtilizador(u);
    }
    
    public boolean verificaUserName(String nome){
        return this.gestaoU.verificaUserName(nome);
    }
    public boolean verificaComponentes(Encomenda e){
        return e.verificaComponentes(this.componentes);
    }
    
    public Componente verificaTipo(String tipo, Encomenda e){
       return e.verificaTipo(tipo,this.componentes);
    }
    
    public List<String> verificaObrigatoria(Encomenda e){
        return e.verificaObrigatoria(this.componentes);
    }
    
    public List<String> verificaIncompativel(Pacote p, Encomenda e){
        return e.verificaIncompativel(p, this.componentes);
    }
    
    public int verificaStock(String s){
        return this.fabrica.get(1).verificaStock(s);
    } 
    
    public Encomenda getEncomenda(int id){
        return this.gestaoE.getEncomenda(id);
    }
    
    public Map<Integer,Encomenda> getEncomendas(){
        return this.gestaoE.getEncomendas();
    }
    
    public void atualizaStock(String s, int q){
        this.fabrica.get(1).atualizaStock(s,q);
    }
    
    public void alterarEstado(Encomenda e, int estado){
        this.gestaoE.alterarEstado(e, estado);
    }
    
    public void login(String nome, String password){
        try{
            if(!nome.equals("Admin")) this.utilizador = this.gestaoU.verificaUtilizador(nome, password);
            else this.administrador = this.administrador.verificaAdmin(nome,password);
        }
        catch(Exception e){}
    }
    
    public void logout(){
        if(this.utilizador!=null) this.utilizador = null;
        else this.administrador = null;
    }
    
    public String listaComponentes(List<String> componentes){
        StringBuilder sb = new StringBuilder();
        for (String i : componentes){
            sb.append(i);
            sb.append("; ");
        }
        return sb.toString();
    }
    
    public Encomenda sugestao(double limite){
        Encomenda e = new Encomenda();
        double valor = 0;
        if(limite >= 1800 && limite <2700) {
            Pacote p = this.pacotes.get("Pacote Comfort");
            valor = p.getPreco();
            e.setPacote(p.getNome());
            for(Componente c : this.componentes.values()){
                boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                double v = c.getPreco();
                if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && e.verificaIncomp(c,p).isEmpty()){
                    e.addToConfiguracao(c.getNome());
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
                e.setPacote(p.getNome());
                for(Componente c : this.componentes.values()){
                    boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                    double v = c.getPreco();
                    if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && e.verificaIncomp(c,p).isEmpty()){
                        if(c.getTipo().equals("Estofo")){
                            if(max < v){
                                max = v;
                                if (comp == null){
                                    e.addToConfiguracao(c.getNome());
                                    comp = c;
                                    valor += v;
                                }
                                else {
                                    e.removeDaConfiguracao(comp.getNome());
                                    e.addToConfiguracao(c.getNome());
                                    valor -= comp.getPreco();
                                    valor += v;
                                    comp = c;
                                }
                            }
                        }  
                        else {
                            valor += v;
                            e.addToConfiguracao(c.getNome());
                        }
                    }
                }
            }
            else {
                for(Componente c : this.componentes.values()){
                    boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                        !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante");
                    double v = c.getPreco();
                    if(!c.getTipo().equals("Pacote") && b && valor + v <= limite && e.verificaIncomp(c,null).isEmpty()){
                       e.addToConfiguracao(c.getNome());
                       valor += v;
                    }
                }
            }
        }
        return e;
    }
}
