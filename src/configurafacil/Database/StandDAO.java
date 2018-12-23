/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;

import configurafacil.Business.Cliente;
import configurafacil.Business.Pacote;
import configurafacil.Business.Stand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jessica
 */
public class StandDAO{
    private Connection c;

    //@Override
    public int size() {
       int s = -1;
        try {
            c = Connect.connect();
            PreparedStatement stm = c.prepareStatement("SELECT count(*) FROM Stand");
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
            String sql = "SELECT idStand FROM Stand WHERE idStand = ?";
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
    public Stand get(Object o) {
        Stand s = new Stand();
        
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Stand WHERE idStand = ?");
            ps.setInt(1,(Integer) o);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){ // se existir
                s.setId(rs.getInt("idStand"));
                s.setClientes(new ClienteDAO(rs.getInt("idStand")));
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
        return s;
    }

    //@Override
    public Stand put(String k, Stand v) {
        Stand s;

        if(this.containsKey(k)){
            s = this.get(k);
        }
        else s = v;
        try{
            c = Connect.connect();
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Stand (idStand) VALUES (?)");
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
        return s;
    }

    //@Override
    public Stand remove(Object o) {
        Stand s = this.get((Integer) o);
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Stand WHERE idStand = ?");
            ps.setInt(1, (Integer) o);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Stand");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Stand");
            }
        }
        return s;
    }

    //@Override
    public void clear() {
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Stand");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Stand");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Stand");
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
