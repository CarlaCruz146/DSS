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
    /** Username do administrador */
    private final String username = "Admin";
    /** Password do administrador */
    private final String password = "admin";
    
    /**
     * Construtor da classe Administrador sem parâmetros.
     */
    public Administrador(){}
    
    /**
     * Verifica o login do administrador.
     * @param nome Nome do administrador
     * @param password Password do administrador
     * @return Administrador autenticado
     * @throws PasswordInvalidaException Exception
     * @throws NomeInexistenteException Exception
     */
    public Administrador verificaAdmin(String nome, String password) throws PasswordInvalidaException, NomeInexistenteException{
        if(this.username.equals(nome)){
            if(this.password.equals(password)) return this;
            else throw new PasswordInvalidaException("Password inválida");
        }
        else throw new NomeInexistenteException("Utilizador inexistente");
    }
}
