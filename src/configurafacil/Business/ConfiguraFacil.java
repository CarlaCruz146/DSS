/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;
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
    private StandDAO stand;
    private FabricaDAO fabrica;
    private Utilizador utilizador;
    private GestaoUtilizadores gestaoU;
    private GestaoEncomenda gestaoE;
    private ComponenteDAO componentes;
    private PacoteDAO pacotes;
    
    public ConfiguraFacil(){
        this.stand = new StandDAO();
        this.fabrica = new FabricaDAO();
        this.utilizador = null;
        this.gestaoU = new GestaoUtilizadores();
        this.gestaoE = new GestaoEncomenda();
        this.componentes = new ComponenteDAO();
        this.pacotes = new PacoteDAO();

       // addFunc();
       // addComp();
       // addEnc();
      //  addStock();
      //  addPacote();
    }
    /**
    public void addFunc() {
        FuncStand st = new FuncStand("João Silva","joao");
        gestaoU.addUtilizador(st);
        FuncFabrica f = new FuncFabrica("Carlos Costa","carlos");
        gestaoU.addUtilizador(f);
        Administrador admin = new Administrador("Admin","admin");
        gestaoU.addUtilizador(admin);
    }
    
    public void addComp() {
        //PINTURA
        Componente c1 = new Componente("Preto","Pintura",1500,null, null);
        Componente c2 = new Componente("Branco","Pintura",1200,null, null);
        Componente c3 = new Componente("Cinzento","Pintura",1300,null, null);
        Componente c4 = new Componente("Azul","Pintura",1000,null, null);
        //MOTOR
        Componente c5 = new Componente("D4 190cv Man. 6 Vel.","Motor",3500,null, null);
        Componente c6 = new Componente("D4 190cv Geatronic 8 Vel.","Motor",3700,null, null);
        Componente c7 = new Componente("D5 235cv Geatronic 8 Vel.","Motor",4200,null, null);
        c7.insereIncompativel("Bridgestone Turanza T005 205/55 R16 91V");
        //PNEU
        Componente c8 = new Componente("Bridgestone Turanza T005 205/55 R16 91V","Pneu",480,null, null);
        Componente c9 = new Componente("Continental ContiEcoContact 5 205/55 R16 91V","Pneu",450,null, null);
        Componente c10 = new Componente("Continental PremiumContact 6 205/55 R16 91H","Pneu",500,null, null);
        Componente c11 = new Componente("Firestone Roadhawk 205/55 R16 91H","Pneu",580,null, null);
        c8.insereIncompativel("Jantes em liga leve 17''");
        c9.insereObrigatoria("Jantes em liga leve 19'' 255/40 R19");
        //JANTE
        Componente c12 = new Componente("Jantes em liga leve 17''","Jante",270,null, null);
        Componente c13 = new Componente("Jantes em liga leve 18'' 245/45 R18","Jante",340,null, null);
        Componente c14 = new Componente("Jantes em liga leve 19'' 255/40 R19","Jante",330,null, null);
        //ESTOFOS
        Componente c15 = new Componente("Couro comfort carvão","Estofo",2800, null, null);
        Componente c16 = new Componente("Couro comfort âmbar","Estofo",3000, null, null);
        Componente c17 = new Componente("Couro comfort maroon brown","Estofo",2600, null, null);
        Componente c18 = new Componente("Couro comfort blond","Estofo",1800, null, null);
        c15.insereIncompativel("Bancos elétricos");
        //PARA-CHOQUES
        Componente c19 = new Componente("Pára-choques","Pára-choque",270,null, null);
        //VIDRO
        Componente c20 = new Componente("Vidro Escurecido","Vidro",500,null, null);
        //TETO
        Componente c21 = new Componente("Teto de abrir","Teto",390,null, null);
        //LUZES
        Componente c22 = new Componente("Pacotes de luz","Luzes",600, null, null);
        c22.insereIncompativel("Pacotes de Luzes Interiores");
        //PACOTE COMFORT
        Componente c23 = new Componente("Bancos elétricos","Pacote",650, null, null);
        c23.insereIncompativel("Couro comfort carvão");
        Componente c24 = new Componente("Ar condicionado de 4 Zonas","Pacote",550, null, null);
        Componente c25 = new Componente("Pacotes de Luzes Interiores","Pacote",500, null, null);
        c25.insereIncompativel("Pacotes de luz");
        Componente c26 = new Componente("Espelhos Retrovisores com Mecanismo Anti-Encadeamento","Pacote",600, null, null);

        //PACOTE SPORT
        Componente c27 = new Componente("Jantes personalizadas","Pacote",600, null, null);
        Componente c28 = new Componente("Amortecedores Resistentes","Pacote",700, null, null);
        Componente c29 = new Componente("Spoilers","Pacote",1000, null, null);
        Componente c30 = new Componente("Escape com 2 ponteiras","Pacote",800, null, null);
      
        addComponente(c1);
        addComponente(c2);
        addComponente(c3);
        addComponente(c4);
        addComponente(c5);
        addComponente(c6);
        addComponente(c7);
        addComponente(c8);
        addComponente(c9);
        addComponente(c10);
        addComponente(c11);
        addComponente(c12);
        addComponente(c13);
        addComponente(c14);
        addComponente(c15);
        addComponente(c16);
        addComponente(c17);
        addComponente(c18);
        addComponente(c19);
        addComponente(c20);
        addComponente(c21);
        addComponente(c22);
        addComponente(c23);
        addComponente(c24);
        addComponente(c25);
        addComponente(c26);
        addComponente(c27);
        addComponente(c28);
        addComponente(c29);
        addComponente(c30);
       
    }
      
    public void addPacote() {
        Map<String,Componente> componentesC = new HashMap<>();
        Map<String,Componente> componentesS = new HashMap<>();

        Componente c1 = getComponente("Bancos elétricos");
        Componente c2 = getComponente("Ar condicionado de 4 Zonas");
        Componente c3 = getComponente("Pacotes de Luzes Interiores");
        Componente c4 = getComponente("Espelhos Retrovisores com Mecanismo Anti-Encadeamento");
        
        Componente c5 = getComponente("Jantes personalizadas");
        Componente c6 = getComponente("Amortecedores Resistentes");
        Componente c7 = getComponente("Spoilers");
        Componente c8 = getComponente("Escape com 2 ponteiras");
        
        componentesC.put(c1.getNome(),c1);
        componentesC.put(c2.getNome(),c2);
        componentesC.put(c3.getNome(),c3);
        componentesC.put(c4.getNome(),c4);
        componentesS.put(c5.getNome(),c5);
        componentesS.put(c6.getNome(),c6);
        componentesS.put(c7.getNome(),c7);
        componentesS.put(c8.getNome(),c8);
        
        Pacote p1 = new Pacote("Pacote Comfort",1800);
        p1.setComponentes(componentesC);
        Pacote p2 = new Pacote("Pacote Sport",2700);
        p2.setComponentes(componentesS);
        addPacote(p1);
        addPacote(p2);
    }
    
    public void addEnc() {
        Map<String,Componente> config1 = new HashMap<>();
        Map<String,Componente> config2 = new HashMap<>();
        Map<String,Componente> config3 = new HashMap<>();
        //ENCOMENDA 1
        Componente c1 = getComponente("Azul");
        Componente c2 = getComponente("D4 190cv Man. 6 Vel.");
        Componente c3 = getComponente("Firestone Roadhawk 205/55 R16 91H");
        Componente c4 = getComponente("Jantes em liga leve 17''");
        Componente c5 = getComponente("Couro comfort carvão");
        Componente c6 = getComponente("Pára-choques");
        config1.put(c1.getNome(),c1);
        config1.put(c2.getNome(),c2);
        config1.put(c3.getNome(),c3);
        config1.put(c4.getNome(),c4);
        config1.put(c5.getNome(),c5);
        config1.put(c6.getNome(),c6);
        //ENCOMENDA 2
        Componente c7 = getComponente("Preto");
        Componente c8 = getComponente("D4 190cv Geatronic 8 Vel.");
        Componente c9 = getComponente("Continental ContiEcoContact 5 205/55 R16 91V");
        Componente c10 = getComponente("Jantes em liga leve 19'' 255/40 R19");
        Componente c11 = getComponente("Couro comfort blond");
        Componente c12 = getComponente("Pacotes de luz");
        Componente c13 = getComponente("Teto de abrir");
        
        config2.put(c7.getNome(),c7);
        config2.put(c8.getNome(),c8);
        config2.put(c9.getNome(),c9);
        config2.put(c10.getNome(),c10);
        config2.put(c11.getNome(),c11);
        config2.put(c12.getNome(),c12);
        config2.put(c13.getNome(),c13);
        
        //ENCOMENDA 3
        Componente c14 = getComponente("Branco");
        Componente c15 = getComponente("D5 235cv Geatronic 8 Vel.");
        Componente c16 = getComponente("Continental PremiumContact 6 205/55 R16 91H");
        Componente c17 = getComponente("Jantes em liga leve 18'' 245/45 R18");
        Componente c18 = getComponente("Couro comfort maroon brown");
        Componente c19 = getComponente("Vidro Escurecido");
        Pacote p = getPacote("Pacote Comfort");
        
        config3.put(c14.getNome(),c14);
        config3.put(c15.getNome(),c15);
        config3.put(c16.getNome(),c16);
        config3.put(c17.getNome(),c17);
        config3.put(c18.getNome(),c18);
        config3.put(c19.getNome(),c19);
        
        Encomenda e1 = new Encomenda(1,"BMW", 1, null);
        e1.setConfig(config1);
        gestaoE.addEncomenda(e1);
        Encomenda e2 = new Encomenda(2,"Mercedes", 0, null);
        e1.setConfig(config2);
        gestaoE.addEncomenda(e2);
        Encomenda e3 = new Encomenda(3,"Volvo", 1, p.getNome());
        e1.setConfig(config3);
        gestaoE.addEncomenda(e3);
    }
    
    public void addStock() {
        
        //PINTURA
        fabrica.adicionaStock("Branco", 60);
        fabrica.adicionaStock("Cinzento", 60);
        fabrica.adicionaStock("Preto", 60);
        fabrica.adicionaStock("Azul", 60);
        
        //MOTOR
        fabrica.adicionaStock("D4 190cv Man. 6 Vel.", 50);
        fabrica.adicionaStock("D4 190cv Geatronic 8 Vel.", 45);
        fabrica.adicionaStock("D5 235cv Geatronic 8 Vel.", 48);
        
        //PNEU
        fabrica.adicionaStock("Bridgestone Turanza T005 205/55 R16 91V", 30);
        fabrica.adicionaStock("Continental ContiEcoContact 5 205/55 R16 91V", 30);
        fabrica.adicionaStock("Continental PremiumContact 6 205/55 R16 91H", 32);
        fabrica.adicionaStock("Firestone Roadhawk 205/55 R16 91H", 25);
        
        //JANTE
        fabrica.adicionaStock("Jantes em liga leve 17''", 20);
        fabrica.adicionaStock("Jantes em liga leve 18'' 245/45 R18", 20);
        fabrica.adicionaStock("Jantes em liga leve 19'' 255/40 R19", 28);
        
        //ESTOFOS
        fabrica.adicionaStock("Couro comfort carvão", 22);
        fabrica.adicionaStock("Couro comfort âmbar", 20);
        fabrica.adicionaStock("Couro comfort maroon brown", 18);
        fabrica.adicionaStock("Couro comfort blond", 25);
        
        //PARA-CHOQUES
        fabrica.adicionaStock("Pára-choques", 30);
        //VIDRO
        fabrica.adicionaStock("Vidro Escurecido", 10);
        //TETO
        fabrica.adicionaStock("Teto de abrir", 5);
        //LUZES
        fabrica.adicionaStock("Pacotes de luz", 12);
        
         //PACOTE COMFORT
        fabrica.adicionaStock("Bancos elétricos", 5);
        fabrica.adicionaStock("Ar condicionado de 4 Zonas", 3);
        fabrica.adicionaStock("Pacotes de Luzes Interiores", 9);
        fabrica.adicionaStock("Espelhos Retrovisores com Mecanismo Anti-Encadeamento", 4);
        
        //PACOTE SPORT
        fabrica.adicionaStock("Jantes personalizadas", 15);
        fabrica.adicionaStock("Amortecedores Resistentes", 15);
        fabrica.adicionaStock("Spoilers", 8);
        fabrica.adicionaStock("Escape com 2 ponteiras", 10);   
    }*/
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
        
    public Stand getStand(){
        return this.stand.get(1);
    }
    
    public Fabrica getFabrica(){
        return this.fabrica.get(1);
    }
    
    public Utilizador getUtilizador(){
        return this.utilizador;
    }
    
    public GestaoUtilizadores getGestaoU(){
        return this.gestaoU;
    }
    
    public GestaoEncomenda getGestaoE(){
        return this.gestaoE;
    }
        
    public void addComponente(Componente c){
        this.componentes.put(c.getNome(),c);
    }
    
    public void addPacote(Pacote p){
        this.pacotes.put(p.getNome(),p);
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
    public void login(String nome, String password){
        try{
            this.utilizador = gestaoU.verificaUtilizador(nome, password);
        }
        catch(Exception e){}
    }
    
    public void logout(){
        this.utilizador = null;
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
