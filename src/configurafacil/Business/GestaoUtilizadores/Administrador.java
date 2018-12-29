/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business.GestaoUtilizadores;

/**
 *
 * @author Grupo 30
 */
public class Administrador {
    
    private final String username = "Admin";
    private final String password = "admin";
    
    public Administrador(){}
    
    public Administrador verificaAdmin(String nome, String password) throws PasswordInvalidaException, NomeInexistenteException{
        Administrador a;
        if(this.username.equals(nome)){
            if(this.password.equals(password)) return this;
            else throw new PasswordInvalidaException("Password inválida");
        }
        else throw new NomeInexistenteException("Utilizador inexistente");
    }
}
