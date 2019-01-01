/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.GestaoUtilizadores;
import configurafacil.Database.UtilizadorDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

/**
 *
 * @author Grupo 30
 */
public class GestaoUtilizadores {
    
    //Variáveis de instância
    private UtilizadorDAO utilizadores;
    
    /**
     * Construtor da classe GestaoUtilizadores sem parâmetros.
     */
    public GestaoUtilizadores(){
        this.utilizadores = new UtilizadorDAO();
    }
    
    /**
     * Verifica o login de um dado utilizador.
     * @param nome Nome do utilizador
     * @param password Password do utilizador
     * @return Utilizador
     * @throws PasswordInvalidaException Exception
     * @throws NomeInexistenteException Exception
     */
    public Utilizador verificaUtilizador(String nome, String password) throws PasswordInvalidaException, NomeInexistenteException{
        Utilizador u;
        if(this.utilizadores.containsKey(nome)){
            u = this.utilizadores.get(nome);
            if (u.getPassword().equals(password)) return u;
            else throw new PasswordInvalidaException("Password inválida");
        }
        else throw new NomeInexistenteException("Utilizador inexistente");
    }
    
    /**
     * Verifica a existência do nome de um utilizador.
     * @param nome Nome do utilizador.
     * @return boolean
     */
    public boolean verificaUserName(String nome){
        return this.utilizadores.containsKey(nome);
    }

    /**
     * Adiciona um utilizador.
     * @param nome Nome do utilizador
     * @param password Password do utilizador
     * @param estado Estado do utilizador
     * @param tipo Tipo de utilizador
     */
    public void adicionaUtilizador(String nome, String password, int estado, int tipo){
        if(tipo == 1){
            FuncStand f  = new FuncStand(nome, password, estado);
            utilizadores.put(f.getNome(),f);
        }
        else{
            FuncFabrica f = new FuncFabrica(nome, password, estado);
            utilizadores.put(f.getNome(),f);
        }
    }
    
    /**
     * Devolve a lista dos nomes dos utilizadores ativos.
     * @return List
     */
    public List<String> getAtivos(){
        List<String> list = new ArrayList<>();
        for(Utilizador u : this.utilizadores.values())
            if(u.getEstado() == 0)
                list.add(u.getNome());
        return list;
    }
    
    /**
     * Devolve o Utilizador com dado nome.
     * @param nome Nome do utilizador.
     * @return Utilizador
     */
    public Utilizador getUtilizador(String nome){
       return utilizadores.get(nome);
    }
    
    /**
     * Devolve os utilizadores existentes.
     * @return Map
     */
    public Map<String,Utilizador> getUtilizadores(){
        Map<String,Utilizador> u = new HashMap<>();
        for(Map.Entry<String,Utilizador> entry: this.utilizadores.entrySet()){
            u.put(entry.getKey(), entry.getValue());
        }
        return u;
    }
    
    /**
     * Altera o estado de um utilizador.
     * @param nome Nome do utilizador
     * @param estado Novo estado do utilizador.
     */
    public void setEstado(String nome, int estado){
        Utilizador u = this.getUtilizador(nome);
        u.setEstado(estado);
        this.utilizadores.put(u.getNome(), u);
    }
    
    /**
     * Devolve o tipo de utilizador
     * @param nome Nome do utilizador
     * @return tipo
     */
    public int getUserTipo(String nome){
        if(this.utilizadores.get(nome) instanceof FuncStand) return 0;
        else if (this.utilizadores.get(nome) instanceof FuncFabrica) return 1;
        return -1;
    }
}
