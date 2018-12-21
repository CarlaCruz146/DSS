/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;
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
        addStock();
        addPacote();
    }
    
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
      
        stand.addComponente(c1);
        stand.addComponente(c2);
        stand.addComponente(c3);
        stand.addComponente(c4);
        stand.addComponente(c5);
        stand.addComponente(c6);
        stand.addComponente(c7);
        stand.addComponente(c8);
        stand.addComponente(c9);
        stand.addComponente(c10);
        stand.addComponente(c11);
        stand.addComponente(c12);
        stand.addComponente(c13);
        stand.addComponente(c14);
        stand.addComponente(c15);
        stand.addComponente(c16);
        stand.addComponente(c17);
        stand.addComponente(c18);
        stand.addComponente(c19);
        stand.addComponente(c20);
        stand.addComponente(c21);
        stand.addComponente(c22);
        stand.addComponente(c23);
        stand.addComponente(c24);
        stand.addComponente(c25);
        stand.addComponente(c26);
        stand.addComponente(c27);
        stand.addComponente(c28);
        stand.addComponente(c29);
        stand.addComponente(c30);
       
    }
      
    public void addPacote() {
        ArrayList<Componente> componentesC = new ArrayList<>();
        ArrayList<Componente> componentesS = new ArrayList<>();

        Componente c1 = stand.getComponente("Bancos elétricos");
        Componente c2 = stand.getComponente("Ar condicionado de 4 Zonas");
        Componente c3 = stand.getComponente("Pacotes de Luzes Interiores");
        Componente c4 = stand.getComponente("Espelhos Retrovisores com Mecanismo Anti-Encadeamento");
        
        Componente c5 = stand.getComponente("Jantes personalizadas");
        Componente c6 = stand.getComponente("Amortecedores Resistentes");
        Componente c7 = stand.getComponente("Spoilers");
        Componente c8 = stand.getComponente("Escape com 2 ponteiras");
        
        componentesC.add(c1);
        componentesC.add(c2);
        componentesC.add(c3);
        componentesC.add(c4);
        componentesS.add(c5);
        componentesS.add(c6);
        componentesS.add(c7);
        componentesS.add(c8);
        
        Pacote p1 = new Pacote("Pacote Comfort",1800,componentesC);
        Pacote p2 = new Pacote("Pacote Sport",2700,componentesS);
        stand.addPacote(p1);
        stand.addPacote(p2);
    }
    
    public void addEnc() {
        List<Componente> config1 = new ArrayList<>();
        List<Componente> config2 = new ArrayList<>();
        List<Componente> config3 = new ArrayList<>();
        //ENCOMENDA 1
        Componente c1 = stand.getComponente("Azul");
        Componente c2 = stand.getComponente("D4 190cv Man. 6 Vel.");
        Componente c3 = stand.getComponente("Firestone Roadhawk 205/55 R16 91H");
        Componente c4 = stand.getComponente("Jantes em liga leve 17''");
        Componente c5 = stand.getComponente("Couro comfort carvão");
        Componente c6 = stand.getComponente("Pára-choques");
        config1.add(c1);
        config1.add(c2);
        config1.add(c3);
        config1.add(c4);
        config1.add(c5);
        config1.add(c6);
        //ENCOMENDA 2
        Componente c7 = stand.getComponente("Preto");
        Componente c8 = stand.getComponente("D4 190cv Geatronic 8 Vel.");
        Componente c9 = stand.getComponente("Continental ContiEcoContact 5 205/55 R16 91V");
        Componente c10 = stand.getComponente("Jantes em liga leve 19'' 255/40 R19");
        Componente c11 = stand.getComponente("Couro comfort blond");
        Componente c12 = stand.getComponente("Pacotes de luz");
        Componente c13 = stand.getComponente("Teto de abrir");
        
        config2.add(c7);
        config2.add(c8);
        config2.add(c9);
        config2.add(c10);
        config2.add(c11);
        config2.add(c12);
        config2.add(c13);
        
        //ENCOMENDA 3
        Componente c14 = stand.getComponente("Branco");
        Componente c15 = stand.getComponente("D5 235cv Geatronic 8 Vel.");
        Componente c16 = stand.getComponente("Continental PremiumContact 6 205/55 R16 91H");
        Componente c17 = stand.getComponente("Jantes em liga leve 18'' 245/45 R18");
        Componente c18 = stand.getComponente("Couro comfort maroon brown");
        Componente c19 = stand.getComponente("Vidro Escurecido");
        Pacote p = stand.getPacote("Pacote Comfort");
        
        config3.add(c14);
        config3.add(c15);
        config3.add(c16);
        config3.add(c17);
        config3.add(c18);
        config3.add(c19);
        
        Encomenda e1 = new Encomenda(1,"BMW", 1, config1,null);
        fabrica.getGestaoE().addEncomenda(e1);
        Encomenda e2 = new Encomenda(2,"Mercedes", 0, config2,null);
        fabrica.getGestaoE().addEncomenda(e2);
        Encomenda e3 = new Encomenda(3,"Volvo", 1, config3,p);
        fabrica.getGestaoE().addEncomenda(e3);
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
    
    public Encomenda sugestao(double limite){
        return this.stand.sugestao(limite);
    }
}
