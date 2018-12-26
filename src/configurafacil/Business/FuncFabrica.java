/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Business;

/**
 *
 * @author mercy
 */
public class FuncFabrica extends Utilizador {
    
    public FuncFabrica(){
        super();
    }
    
    public FuncFabrica(String nome, String pass, int estado){
        super(nome,pass,estado);
    }
    
    public FuncFabrica(FuncFabrica f){
        super(f);
    }
    
    public FuncFabrica clone(){
        return new FuncFabrica(this);
    }
    
    public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || this.getClass() != o.getClass()) return false;

       FuncFabrica f = (FuncFabrica) o;

       return (super.equals(f));
   } 
    
}
