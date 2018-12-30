/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica.GestaoEncomenda;

import configurafacil.Database.EncomendaDAO;
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
    
    /**
     * Altera o estado de uma encomenda.
     * @param e Encomenda.
     * @param estado Estado da encomenda.
     */
    public void alterarEstado(Encomenda e, int estado){
        e.setEstado(estado);
        this.encomendas.put(e.getId(), e);
    }
}
