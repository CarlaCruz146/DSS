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
public class FuncStand extends Utilizador { //FuncFabrica e Administrador
    
    public FuncStand(){
        super();
    }
    
    public FuncStand(String nome, String pass){
        super(nome,pass);
    }
    
    public FuncStand(FuncStand fs){
        super(fs);
    }
    
    public FuncStand clone(){
        return new FuncStand(this);
    }
    
    public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || this.getClass() != o.getClass()) return false;

       FuncStand fs = (FuncStand) o;

       return (super.equals(fs));
   }     
}
