/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica.GestaoEncomenda;

import configurafacil.Database.EncomendaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Grupo 30
 */
public class GestaoEncomenda {
    
    /** Encomendas da aplicação */
    private EncomendaDAO encomendas;
    
    /**
     * Construtor da classe GestaoEncomenda sem parâmetros.
     */
    public GestaoEncomenda(){
        this.encomendas = new EncomendaDAO();
    }
    
    /**
     * Devolve as encomendas existentes.
     * @return Map
     */
    public Map<Integer,Encomenda> getEncomendas(){
        Map<Integer,Encomenda> e = new HashMap<>();
        for(Map.Entry<Integer,Encomenda> entry: this.encomendas.entrySet()){
            e.put(entry.getKey(), entry.getValue());
        }
        return e;
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
        int id = encomendas.size()+1;
        Encomenda e = new Encomenda(id, carro, 0, comp, pacote, nif, limite);
        this.encomendas.put(id,e);
    }
    
    /**
     * Devolve o nome do pacote de dada encomenda.
     * @param e Encomenda
     * @return nome do pacote
     */
    public String getPacote(Encomenda e){
        return e.getPacote();
    }
    
    /**
     * Remove uma encomenda da lista de encomendas
     * @param e Encomenda
     */
    public void removeEncomenda(Encomenda e){
        this.encomendas.remove(e.getId());
    }
    
    /**
     * Devolve a encomenda com dado id.
     * @param id Id da encomenda
     * @return Encomenda
     */
    public Encomenda getEncomenda(int id){
        return this.encomendas.get(id);
    }
    
    /**
     * Devolve a lista dos nomes das componentes de uma encomenda com um certo id.
     * @param id Id da encomenda
     * @return List
     */
    public List<String> getCompEncomenda(int id){
        Encomenda e = this.encomendas.get(id);
        List<String> comp = new ArrayList<>();
        for(String s : e.getConfig())
            comp.add(s);
        String pacote = e.getPacote();
        if(pacote!=null) comp.add(pacote);
        comp.add(e.getCarro());
        return comp;
    }
    
     /**
     * Devolve a lista dos nomes de todas as componentes de uma encomenda com um certo id.
     * @param id Id da encomenda
     * @param pacotes Map dos pacotes
     * @return List
     */
    public List<String> getAllCompEncomenda(int id, Map<String,Pacote> pacotes){
        Encomenda e = this.encomendas.get(id);
        List<String> comp = new ArrayList<>();
        for(String s : e.getConfig())
            comp.add(s);
        String pacote = e.getPacote();
        if(pacote!=null){
            for(String ss : pacotes.get(pacote).getComponentes())
                comp.add(ss);
        }
        return comp;
    }
    
    /**
     * Altera o estado de uma encomenda.
     * @param id Id da encomenda
     * @param estado Novo estado da encomenda
     */
    public void alterarEstado(int id, int estado){
        Encomenda e = this.encomendas.get(id);
        e.setEstado(estado);
        this.encomendas.put(id, e);
    }
    
    /**
     * Devolve o estado de dada encomenda.
     * @param id Id da encomenda
     * @return estado da encomenda
     */
    public int estadoEnc(int id){
        return this.encomendas.get(id).getEstado();
    }
   
    /**
     * Devolve a lista dos ids das encomendas com determindado estado.
     * @param estado Estado da encomenda
     * @return List
     */
    public List<Integer> getEncEstado(int estado){
        List<Integer> ids = new ArrayList<>();
        Set<Integer> chaves = this.encomendas.keySet();
        for(Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();){
            int chave = iterator.next();
            if(chave>=0){
                Encomenda e = this.encomendas.get(chave);
                if(e.getEstado() == estado)  
                    ids.add(e.getId());
            }           
        }
        return ids;
    }
    
    /**
     * Devolve a lista dos nomes dos clientes com encomendas prontas.
     * @return List
     */    
    public List<String> obtemClienteEncProntas(){
        List<String> nifs = new ArrayList<>();
        Set<Integer> chaves = this.encomendas.keySet();
        for(Iterator<Integer> iterator = chaves.iterator(); iterator.hasNext();){
            int chave = iterator.next();
            if(chave>=0){
                Encomenda e = this.encomendas.get(chave);
                if(e.getEstado() == 2)  
                    nifs.add(e.getCliente());
            }           
        }
        return nifs;
    }
}
