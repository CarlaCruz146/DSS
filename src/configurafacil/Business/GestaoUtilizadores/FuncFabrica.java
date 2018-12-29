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
public class FuncFabrica extends Utilizador {
    
    /**
     * Construtor vazio do Utilizador cuja natureza é FuncFabrica
     */
    public FuncFabrica(){
        super();
    }
    
    /**
     * Constrói a partir dos parametros fornecidos um utilizador cuja natureza é FuncFabrica
     * @param nome Nome do utilizador
     * @param pass Password do utilizador
     * @param estado Estado do utilizador
     */
    public FuncFabrica(String nome, String pass, int estado){
        super(nome,pass,estado);
    }
    
    /**
     * Constroi um utilizador cuja natureza é FuncFabrica a partir de uma definida
     * @param f
     */
    public FuncFabrica(FuncFabrica f){
        super(f);
    }
    
   /**
     * Imprime a informação de um funcionário cuja natureza é um funcionario de fábrica
     * @return String com a informação
     */
     public String toString(){
        return super.toString();
    }
    
    /**
     * Compara dois utilizadores de FuncFabrica
     * @param o Objeto
     * @return boolean
     */
    public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || this.getClass() != o.getClass()) return false;

       FuncFabrica f = (FuncFabrica) o;

       return (super.equals(f));
   } 
    
}
