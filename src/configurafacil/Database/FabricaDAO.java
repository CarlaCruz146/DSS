/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;

import configurafacil.Business.Fabrica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author jessica
 */
public class FabricaDAO {
    private Connection c;

    //@Override
    public int size() {
       int s = -1;
        try {
            c = Connect.connect();
            PreparedStatement stm = c.prepareStatement("SELECT count(*) FROM Fabrica");
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
               s = rs.getInt(1);
            }
        }
        catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
        finally {
            Connect.close(c);
        }
        return s;
    }

    //@Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    //@Override
    public boolean containsKey(Object o) {
        boolean res = false;
        try {
            c = Connect.connect();
            String sql = "SELECT idFabrica FROM Fabrica WHERE idFabrica = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setInt(1, (Integer) o);
            ResultSet rs = stm.executeQuery();
            res = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(c);
        }
        return res;
    }

    //@Override
    public boolean containsValue(Object o) {
        return false; //nao faz sentido este método
    }

    //@Override
    public Fabrica get(Object o) {
        Fabrica f = new Fabrica();
        
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Fabrica WHERE idFabrica = ?");
            ps.setInt(1,(Integer) o);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){ // se existir
                f.setId(rs.getInt("idFabrica"));
            } 
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Cliente");
        }
        finally{
            try{
               Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Cliente");
            }
        }
        return f;
    }

    //@Override
    public Fabrica put(String k, Fabrica v) {
        Fabrica f;

        if(this.containsKey(k)){
            f = this.get(k);
        }
        else f = v;
        try{
            c = Connect.connect();
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Fabrica (idFabrica) VALUES (?)");
            ps.setString(1,k);
            ps.executeUpdate();         
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Cliente");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Cliente");
            }
        }
        return f;
    }

    //@Override
    public Fabrica remove(Object o) {
        Fabrica f = this.get((Integer) o);
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Fabrica WHERE idFabrica = ?");
            ps.setInt(1, (Integer) o);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Fabrica");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Fabrica");
            }
        }
        return f;
    }

    //@Override
    public void clear() {
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Fabrica");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Fabrica");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Fabrica");
            }
        }
    }
/**
    @Override
    public Set<String> keySet() {
       Set<String> keys = null;
        
        try{
            c = Connect.connect();
            keys = new HashSet<>();
            PreparedStatement ps = c.prepareStatement("SELECT Nif FROM Cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                keys.add(rs.getString(1));
            }   
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Cliente");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Cliente");
            }
        }
        return keys;
    }

    @Override
    public Collection<Cliente> values() {
        Set<Cliente> clientes = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String k : keys){
            clientes.add(this.get(k));
        }
        return clientes;
    }

    @Override
    public Set<Map.Entry<String, Cliente>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        Map<String,Cliente> map = new HashMap<>();
        
        for(String k : keys){
            map.put(k,this.get(k));
        }
        return map.entrySet();
    }*/
}
