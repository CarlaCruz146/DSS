/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author utilizador
 */
public class GestaoUtilizadores {
    private Map<String,Utilizador> utilizadores;
    
    public GestaoUtilizadores(){
        this.utilizadores = new HashMap<>();
    }
    
    public Utilizador verificaUtilizador(String nome, String password) throws PasswordInvalidaException, UtilizadorInvalidoException{
        Utilizador u;
        if(this.utilizadores.containsKey(nome)){
            u = this.utilizadores.get(nome);
            if (u.getPassword().equals(password)) return u;
            else throw new PasswordInvalidaException("Password inválida");
        }
        else throw new UtilizadorInvalidoException("Utilizador inexistente");
    }
    
    public int tipoFuncionario(String nome, String password) {
        for(Utilizador u : this.utilizadores.values()){
            if(u.getNome().equals(nome) && u.getPassword().equals(password))
                return u.getTipo();
        }
        return -1;
    }
    
    public void addUtilizador(Utilizador u){
        utilizadores.put(u.getNome(),u);
    }
}
