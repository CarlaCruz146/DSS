/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.Fabrica;

import configurafacil.Database.StockDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
/**
 *
 * @author Grupo 30
 */
public class Fabrica {
    
    /** Stock da fábrica */
    private StockDAO stock;
    
    /**
     * Construtor da classe Fabrica sem parâmetros.
     */
    public Fabrica(){
        this.stock = new StockDAO();
    }
    
    /**
     * Devolve o stock da fábrica.
     * @return Map 
     */
    public Map<String, Stock> getStock(){
        return this.stock.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), e->e.getValue()));    
    }
    
     /**
     * Devolve a lista das quantidades em stock.
     * @return List
     */
    public List<Integer> obtemQuantidadeS(){
        List<Integer> quantidades = new ArrayList<>();
        Set<String> chaves = this.stock.keySet();
        for(Iterator<String> iterator = chaves.iterator(); iterator.hasNext();){
            String chave = iterator.next();
            if(chave != null)
                quantidades.add(this.stock.get(chave).getQuantidade());
        }
        return quantidades;
        
    }
    
    /**
     * Devolve a lista dos nomes das componentes.
     * @return List
     */
    public List<String> obtemNomeC(){
        List<String> nomes = new ArrayList<>();
        Set<String> chaves = this.stock.keySet();
        for(Iterator<String> iterator = chaves.iterator(); iterator.hasNext();){
            String chave = iterator.next();
            if(chave != null)
                nomes.add(this.stock.get(chave).getComponente());
       }
        return nomes;
    }
    
     /**
     * Adiciona stock à fábrica.
     * @param c Componente a adicionar ao stock
     * @param s Novo stock a adicionar
     */
    public void adicionaStock(String c, Stock s){
        this.stock.put(c, s);
    }
    
     /**
     * Devolve a quantidade em stock de uma determinada componente.
     * @param s Nome da componente
     * @return quantidade em stock da componente
     */
    public int verificaStock(String s){
        return this.stock.get(s).getQuantidade();
    }
    
    /**
     * Atualiza o stock de uma determinada componente.
     * @param s Nome da componente
     * @param q Quantidade da componente
     */
    public void atualizaStock(String s, int q){
        Stock st = new Stock(q,s);
        this.stock.put(s, st);
    }
}
