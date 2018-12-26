/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;
import configurafacil.Database.UtilizadorDAO;
import java.util.HashMap;

import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author utilizador
 */
public class GestaoUtilizadores {
    private UtilizadorDAO utilizadores;
    
    public GestaoUtilizadores(){
        this.utilizadores = new UtilizadorDAO(1,1);
    }
    
    public Utilizador verificaUtilizador(String nome, String password) throws PasswordInvalidaException, NomeInexistenteException{
        Utilizador u;
        if(this.utilizadores.containsKey(nome)){
            u = this.utilizadores.get(nome);
            if (u.getPassword().equals(password)) return u;
            else throw new PasswordInvalidaException("Password inválida");
        }
        else throw new NomeInexistenteException("Utilizador inexistente");
    }
    
    public boolean verificaUserName(String nome){
        return this.utilizadores.containsKey(nome);
    }
    /*
    public int tipoFuncionario(String nome, String password) {
        for(Utilizador u : this.utilizadores.values()){
            if(u.getNome().equals(nome) && u.getPassword().equals(password))
                return u.getTipo();
        }
        return -1;
    }*/
    
    public void addUtilizador(Utilizador u){
        utilizadores.put(u.getNome(),u);
    }
    
    public Utilizador getUtilizador(String nome){
       return utilizadores.get(nome);
    }
    
    public Map<String,Utilizador> getUtilizadores(){
        Map<String,Utilizador> u = new HashMap<>();
        for(Map.Entry<String,Utilizador> entry: this.utilizadores.entrySet()){
            u.put(entry.getKey(), entry.getValue());
        }
        return u;
    }
    
    public void setEstado(Utilizador u, int estado){
        u.setEstado(estado);
        this.utilizadores.put(u.getNome(), u);
    }
    
    public void setUtilizador(String nome, Utilizador u){
       this.utilizadores.replace(nome,u);
   }
    public void removeUtilizador(String nome){
        this.utilizadores.remove(nome);
    }
}
