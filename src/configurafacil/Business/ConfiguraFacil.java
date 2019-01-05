/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import configurafacil.Business.Fabrica.Fabrica;
import configurafacil.Business.Fabrica.GestaoEncomenda.*;
import configurafacil.Business.GestaoUtilizadores.Administrador;
import configurafacil.Business.GestaoUtilizadores.GestaoUtilizadores;
import configurafacil.Business.GestaoUtilizadores.NomeInexistenteException;
import configurafacil.Business.GestaoUtilizadores.Utilizador;
import configurafacil.Business.Stand.Cliente;
import configurafacil.Business.Stand.Stand;
import configurafacil.Database.ComponenteDAO;
import configurafacil.Database.PacoteDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Grupo 30
 */
public class ConfiguraFacil {
    
    /** Administrador da aplicação */
    private Administrador administrador;
    /** Stand da aplicação */
    private Stand stand;
    /** Fábrica da aplicação */
    private Fabrica fabrica;
    /** Utilizador que está a usar a aplicação */
    private Utilizador utilizador;
    /** Gestão dos utilizadores da aplicação */
    private GestaoUtilizadores gestaoU;
    /** Gestão das encomendas da aplicação */
    private GestaoEncomenda gestaoE;
    /** Componentes disponíveis na aplicação */
    private ComponenteDAO componentes;
    /** Pacotes disponíveis na aplicação */
    private PacoteDAO pacotes;
    
    /**
     * Construtor da classe ConfiguraFacil sem parâmetros.
     */
    public ConfiguraFacil(){
        this.stand = new Stand();
        this.fabrica = new Fabrica();
        this.utilizador = null;
        this.administrador = new Administrador();
        this.gestaoU = new GestaoUtilizadores();
        this.gestaoE = new GestaoEncomenda();
        this.componentes = new ComponenteDAO();
        this.pacotes = new PacoteDAO();
    }

    /**
     * Devolve as componentes existentes na aplicação.
     * @return Map
     */
    public Map<String,Componente> getComponentes(){
        return this.componentes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
     * Devolve os pacotes existentes na aplicação.
     * @return Map
     */
    public Map<String,Pacote> getPacotes(){
        return this.pacotes.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));
    }
    
    /**
     * Devolve uma das componentes da aplicação.
     * @param nome Nome da componente
     * @return Componente
     */
    public Componente getComponente(String nome){
        return this.componentes.get(nome);
    }
    
    /**
     * Devolve um dos pacotes da aplicação.
     * @param nome Nome do pacote
     * @return Pacote
     */
    public Pacote getPacote(String nome){
        return this.pacotes.get(nome);
    }
    
    /**
     * Devolve o stand da aplicação.
     * @return Stand
     */
    public Stand getStand(){
        return this.stand;
    }
    
    /**
     * Devolve um cliente da aplicação com dado nif.
     * @param nif Nif do cliente
     * @return Cliente
     */
    public Cliente getCliente(String nif){
        return this.stand.getCliente(nif);
    }
    
    /**
     * Devolve a fábrica da aplicação.
     * @return Fabrica
     */
    public Fabrica getFabrica(){
        return this.fabrica;
    }
    
    /**
     * Devolve o administrador da aplicação.
     * @return Administrador
     */
    public Administrador getAdministrador(){
        return this.administrador;
    }
    
    /**
     * Devolve o utilizador da aplicação.
     * @return Utilizador
     */
    public Utilizador getUtilizador(){
        return this.utilizador;
    }
    /**
     * Devolve o utilizador da aplicação com dado nome.
     * @param nome Nome do utilizador
     * @return Utilizador
     */
    public Utilizador getUser(String nome){
        return this.gestaoU.getUtilizador(nome);
    }

    /**
     * Devolve a gestão de utilizadores.
     * @return GestaoU
     */    
    public GestaoUtilizadores getGestaoU(){
        return this.gestaoU;
    }

     /**
     * Devolve a gestão de encomendas.
     * @return GestaoE
     */   
    public GestaoEncomenda getGestaoE(){
        return this.gestaoE;
    }
    
    /**
     * Atualiza o estado de um utilizador.
     * @param nome Nome do utilizador
     * @param estado Novo estado
     */    
    public void setEstado(String nome, int estado){
        this.gestaoU.setEstado(nome,estado);
    }

    /**
     * Adiciona um cliente.
     * @param nome Nome do cliente
     * @param nif Nif do cliente
     * @param contacto Contacto do cliente
     */ 
    public void addCliente(String nome, String nif, String contacto){
        this.stand.addCliente(nome,nif,contacto);
    }

    /**
     * Adiciona um utilizador.
     * @param nome Nome do utilizador
     * @param password Password do utilizador
     * @param estado Estado do utilizador
     * @param tipo Tipo de utilizador
     */
    public void adicionaUtilizador(String nome, String password, int estado, int tipo){
            this.gestaoU.adicionaUtilizador(nome, password, estado, tipo);
    }
    
    
    /**
     * Devolve a lista dos nomes dos utilizadores ativos.
     * @return List
     */
    public List<String> getAtivos(){
        return this.gestaoU.getAtivos();
    }
    
    /**
     * Devolve a lista dos nomes das componentes de uma encomenda com um certo id.
     * @param id Id da encomenda
     * @return List
     */
    public List<String> getCompEncomenda(int id){
        return this.gestaoE.getCompEncomenda(id);
    }
    
     /**
     * Devolve a lista dos nomes de todas as componentes de uma encomenda com um certo id.
     * @param id Id da encomenda
     * @return List
     */
    public List<String> getAllCompEncomenda(int id){
        return this.gestaoE.getAllCompEncomenda(id,this.pacotes);
    }
     /**
     * Cria uma nova encomenda.
     * @param nif Nif do cliente que fez a encomenda
     * @param carro Carro encomendado
     * @param comp Nomes das componentes da configuração da encomenda
     * @param pacote Nome do pacote da encomenda
     * @param limite Limite de preço da encomenda
     */
    public void geraEncomenda(String nif, String carro, List<String> comp, String pacote, double limite){
        this.gestaoE.geraEncomenda(nif, carro, comp, pacote, limite);
    }
    
     /**
     * Devolve a lista dos nomes das componentes de um pacote com dado nome.
     * @param nome Nome do pacote
     * @return List
     */
    public List<String> getComponentesPacote(String nome){
       return this.pacotes.get(nome).getComponentes();
   }

    /**
     * Verifica se é um utilizador.
     * @param nome Nome a verificar
     * @return Se existe ou não
     */      
    public boolean verificaUserName(String nome){
        return this.gestaoU.verificaUserName(nome);
    }

    /**
     * Verifica se todas as componentes básicas obrigatórias foram escolhidas.
     * @param comp Nomes das componentes da configuração
     * @return Se foram escolhidas ou não
     */
    public boolean verificaComponentes(List<String> comp){
        int i = 0;
        for(String s: comp){
            Componente c = this.componentes.get(s);
            if(c.getTipo().equals("Pintura") || c.getTipo().equals("Motor") || c.getTipo().equals("Pneu") || c.getTipo().equals("Jante"))
                i++;
        }
        boolean n = i == 4;
        return n;
    }
    
    /**
     * Verifica se uma componente é de um determinado tipo.
     * @param tipo Tipo 
     * @param c Nome da componente a verificar
     * @return Se é ou não do tipo fornecido
     */
    public boolean verificaTipoComp(String tipo, String c){
       Componente comp = this.componentes.get(c);
       if(comp.getTipo().equals(tipo)) return true;
       return false;
    }
    
    
    /**
     * Devolve a componente de um determinado tipo presente numa dada lista de componentes.
     * @param tipo Tipo
     * @param componente Lista dos nomes das componentes
     * @return Nome da componente do tipo dado
     */
    public String verificaTipo(String tipo, List<String> componente){
        String comp = null;
        Componente c = null;
        for(String s: componente){
            c = this.componentes.get(s);
            if(c.getTipo().equals(tipo)){
                comp = c.getNome();
                return comp;
            }       
        }
        return comp;
    }

    
    /**
     * Devolve a lista dos nomes das componentes obrigatórias da encomenda não selecionadas.
     * @param componente Lista dos nomes das componentes
     * @return List
     */    
    public List<String> verificaObrigatoria(List<String> componente){
        List<String> obrigatorio = new ArrayList<>();
        int flag = 0;
        for(String string : componente){
            Componente c = this.componentes.get(string);
            for(String s : c.getObrigatorias()){
                for(String n : componente)
                    if(s.equals(n))
                        flag = 1;
            if(flag == 0) obrigatorio.add(s);
            else flag = 0;
            }
        }
        return obrigatorio;
    }

    /**
     * Devolve a lista dos nomes das componentes incompativeis de dada componente e pacote.
     * @param componente Nome da componente
     * @param comp Nomes das componentes a serem adicionadas na configuração
     * @param p Nome do pacote selecionado
     * @return List
     */    
    public List<String> verificaIncomp(String componente, List<String> comp, String p){
        List<String> incomp = new ArrayList<>();
        Componente c = this.componentes.get(componente);
        for(String i : c.getIncompativeis())
            for(String j : comp){
                if(i.equals(j))
                    incomp.add(i); 
            }
        if(p!=null){
            Pacote pacote = this.pacotes.get(p);
            for(String s : pacote.getComponentes())
                for(String i : c.getIncompativeis())
                    if(i.equals(s))
                        incomp.add(i);
        }
        return incomp;
    }
    
    
    /**
     * Devolve a lista dos nomes das componentes obrigatórias ao escolher certa componente.
     * @param cnome Nome da componente adicionada
     * @param comp Nomes das componentes a serem adicionadas na configuração
     * @return List
     */    
    public List<String> verificaObrig(String cnome, List<String> comp){
        List<String> obrig = new ArrayList<>();
        Componente componente = this.componentes.get(cnome);
        int flag = 0;
        for(String i : componente.getObrigatorias()){
            if(comp.isEmpty()) obrig.add(i);
            for(String j : comp){
                if(i.equals(j))
                    flag = 1;
            }
            if(flag == 0) obrig.add(i);
            else flag = 0;
        } 
        return obrig;
    }

    /**
     * Devolve a lista dos nomes das componentes incompativeis com um pacote presentes na configuração.
     * @param pacote Nome do pacote
     * @param componente Nomes das componentes da configuração
     * @return List
     */    
    public List<String> verificaIncompativel(String pacote, List<String> componente){
        List<String> incomp = new ArrayList<>();
        Pacote p = this.pacotes.get(pacote);
        for(String str : p.getComponentes()){
            Componente c = componentes.get(str);
            for(String s : c.getIncompativeis())
                for(String comp : componente)
                    if(s.equals(comp))
                        incomp.add(s);
        }
        return incomp;
    }
    
    /**
     * Devolve a quantidade em stock de uma determinada componente.
     * @param s Nome da componente
     * @return quantidade em stock da componente
     */
    public int verificaStock(String s){
        return this.fabrica.verificaStock(s);
    } 
    
    /**
     * Devolve encomenda com certo id.
     * @param id Id da encomenda
     * @return Encomenda
     */
    public Encomenda getEncomenda(int id){
        return this.gestaoE.getEncomenda(id);
    }
   
    /**
     * Atualiza o stock de uma determinada componente.
     * @param s Nome da componente
     * @param q Quantidade da componente
     */
    public void atualizaStock(String s, int q){
        this.fabrica.atualizaStock(s,q);
    }
    
    /**
     * Altera o estado de uma determinada encomenda.
     * @param id Id da encomenda
     * @param estado Novo estado da encomenda
     */    
    public void alterarEstado(int id, int estado){
        this.gestaoE.alterarEstado(id, estado);
    }
    
    /**
     * Devolve o estado de dada encomenda.
     * @param id Id da encomenda
     * @return estado da encomenda
     */
    public int estadoEnc(int id){
        return this.gestaoE.estadoEnc(id);
    }
    
    /**
     * Devolve o preço de dada componente.
     * @param nome Nome da componente
     * @return preço
     */
    public double getComponentePreco(String nome){
        return this.componentes.get(nome).getPreco();
    }
    
    /**
     * Devolve o preço de determinado pacote.
     * @param nome Nome do pacote
     * @return preço
     */
    public double getPacotePreco(String nome){
        return this.pacotes.get(nome).getPreco();
    }
    
    /**
     * Verifica se é pacote.
     * @param nome Nome do pacote a verificar
     * @return se é pacote ou nao
     */
    public boolean isPacote(String nome){
        return this.pacotes.containsKey(nome);
    }
    
    /**
     * Devolve a lista dos nifs dos clientes com encomendas prontas.
     * @return List
     */    
    public List<String> obtemClienteEncProntas(){
        return this.gestaoE.obtemClienteEncProntas();
    }
    
    /**
     * Devolve a lista das quantidades em stock.
     * @return List
     */
    public List<Integer> obtemQuantidadeS(){
        return this.fabrica.obtemQuantidadeS();
    }
    
    /**
     * Devolve a lista dos ids das encomendas com determindado estado.
     * @param estado Estado da encomenda
     * @return List
     */
    public List<Integer> getEncEstado(int estado){
        return this.gestaoE.getEncEstado(estado);
    }
    
    /**
     * Devolve o tipo de utilizador com determinado nome.
     * @param nome Nome do utilizador
     * @return tipo
     */
    public int getUserTipo(String nome){
       return this.gestaoU.getUserTipo(nome);
    }
    
    /**
     * Devolve a lista dos nomes das componentes.
     * @return List
     */
    public List<String> obtemNomeC(){
        return this.fabrica.obtemNomeC();
    }
    
    /**
     * Inicia sessão de um utilizador.
     * @param nome Nome do utilizador
     * @param password Password do utilizador
     * @throws NomeInexistenteException
     */     
    public void login(String nome, String password) throws NomeInexistenteException{
        try{
            if(!nome.equals("Admin")) this.utilizador = this.gestaoU.verificaUtilizador(nome, password);
            else this.administrador = this.administrador.verificaAdmin(nome,password);
        }
        catch(Exception e){
            throw new NomeInexistenteException(e.getMessage());
        }
    }

    /**
     * Termina sessão de um utilizador.
     */  
    public void logout(){
        this.utilizador = null;
    }

    /**
     * Constrói uma string com a lista dos nomes das componentes.
     * @param componentes Lista dos nomes das componentes a listar
     * @return string 
     */ 
    public String listaComponentes(List<String> componentes){
        StringBuilder sb = new StringBuilder();
        for (String i : componentes){
            sb.append(i);
            sb.append("; ");
        }
        return sb.toString();
    }
    
    /**
     * Devolve a lista dos nomes das componentes da configuração sugerida dado um limite de preço.
     * @param limite Limite de preço da encomenda
     * @return List
     */
    public List<String> sugestao(double limite){
        List<String> l = new ArrayList<>();
        String pacote = null;
        double valor = 0;
        double v;
        double max = 0;
  
        for(Pacote p: this.pacotes.values()){
            v = p.getPreco();
            if(valor+v<= limite && max<v){
                pacote = p.getNome();
                max = v;
            }
        }
        if(pacote!=null){
            valor+=max;
        }
        List<Componente> cl = new ArrayList<>();       
        if(valor<limite){
            for(Componente c : this.componentes.values()){
                boolean b = !c.getTipo().equals("Motor") && !c.getTipo().equals("Pintura") && 
                 !c.getTipo().equals("Pneu") && !c.getTipo().equals("Jante") && !c.getTipo().equals("Pacote"); 
                if(b) cl.add(c);
            }
             Collections.sort(cl, new ComponenteComparator());
             for(Componente cp: cl){
                 v = cp.getPreco();
                 if(valor + v <= limite && verificaIncomp(cp.getNome(), l, pacote).isEmpty() && verificaObrig(cp.getNome(),l).isEmpty() && verificaTipo(cp.getTipo(), l)==null){
                    valor+=v;
                    l.add(cp.getNome());
                }
                 else if(!verificaObrig(cp.getNome(),l).isEmpty()){
                     int flag = 1;
                     for(String s : verificaObrig(cp.getNome(),l)){
                        Componente componente = this.componentes.get(s);
                        v = componente.getPreco();
                        boolean b = !componente.getTipo().equals("Motor") && !componente.getTipo().equals("Pintura") && 
                                    !componente.getTipo().equals("Pneu") && !componente.getTipo().equals("Jante"); 
                        if(v+valor+cp.getPreco()<= limite && b && verificaTipo(cp.getTipo(), l)==null){
                            valor+=v;
                            l.add(cp.getNome());
                        }
                        else {flag = 0; break;}
                    }
                    if(flag == 1){
                        valor+=cp.getPreco();
                        l.add(cp.getNome());
                    }
                 }
             }
             if(pacote != null) l.add(pacote);
        }
        return l;
    }
    
    /**
     * Atualiza o stock quando uma encomenda é colocada em execução.
     * @param config Lista do nome das componentes a diminuir em stock
     */  
    public void diminuiStock(List<String> config){        
        for(String s : config){
            int qt = fabrica.getStock().get(s).getQuantidade();
            fabrica.atualizaStock(s, qt-1);
        }
    }
}
