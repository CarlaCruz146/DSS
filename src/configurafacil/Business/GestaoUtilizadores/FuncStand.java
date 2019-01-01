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
public class FuncStand extends Utilizador { 
    
    /**
     * Construtor vazio do Utilizador cuja natureza é FuncStand.
     */
    public FuncStand(){
        super();
    }
    
    /**
     * Constrói a partir dos parametros fornecidos um utilizador cuja natureza é FuncStand.
     * @param nome Nome do utilizador
     * @param pass Password do utilizador
     * @param estado Estado do utilizador
     */
    public FuncStand(String nome, String pass, int estado){
        super(nome,pass,estado);
    }
    
    /**
     * Constrói por cópia um utilizador cuja natureza é FuncStand.
     * @param fs
     */
    public FuncStand(FuncStand fs){
        super(fs);
    }
    
       /**
     * Imprime a informação de um funcionário cuja natureza é um funcionario do stand.
     * @return String com a informação
     */
     public String toString(){
        return super.toString();
    }
    
    /**
     * Compara dois utilizadores de FuncStand.
     * @param o Objeto
     * @return boolean
     */
    public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || this.getClass() != o.getClass()) return false;

       FuncStand fs = (FuncStand) o;

       return (super.equals(fs));
   }     
}
