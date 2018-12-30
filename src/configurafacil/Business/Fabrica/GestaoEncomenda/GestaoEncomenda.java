/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica.GestaoEncomenda;

import configurafacil.Database.EncomendaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Grupo 30
 */
public class GestaoEncomenda {
    
    //Variáveis de instância
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
    
    public void geraEncomenda(String nif, String carro, List<String> comp, String pacote, double limite){
        int id = encomendas.size()+1;
        Encomenda e = new Encomenda(id, carro, 0, comp, pacote, nif, limite);
        this.encomendas.put(id,e);
    }
    
    public String getPacote(Encomenda e){
        return e.getPacote();
    }
    
    /**
     * Remove uma encomenda da lista de encomendas.
     * @param e Encomenda.
     */
    public void removeEncomenda(Encomenda e){
        this.encomendas.remove(e.getId());
    }
    
    /**
     * Devolve o Encomenda com dado id.
     * @param id Id da encomenda.
     * @return Encomenda
     */
    public Encomenda getEncomenda(int id){
        return this.encomendas.get(id);
    }
    
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
     * @param id Identificador encomenda.
     * @param estado Estado da encomenda.
     */
    public void alterarEstado(int id, int estado){
        Encomenda e = this.encomendas.get(id);
        e.setEstado(estado);
        this.encomendas.put(id, e);
    }
    
    public int estadoEnc(int id){
        return this.encomendas.get(id).getEstado();
    }
}
