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
public class Administrador extends Utilizador {
    
    public Administrador(){
        super();
    }
    
    public Administrador(String nome, String pass){
        super(nome,pass);
    }
    
    public Administrador(Administrador a){
        super(a);
    }
    
    public Administrador clone(){
        return new Administrador(this);
    }
    
    public boolean equals(Object o){
       if(this == o) return true;
       if(o == null || this.getClass() != o.getClass()) return false;

       Administrador a = (Administrador) o;

       return (super.equals(a));
   } 
    
}
