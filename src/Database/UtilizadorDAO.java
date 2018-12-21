/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import configurafacil.Business.Utilizador;
import configurafacil.Business.FuncStand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author mercy
 */
public class UtilizadorDAO implements Map<String,Utilizador> {
    
    private Connection c;
    
    @Override
    public int size() {
         int s = -1;
        try {
            c = Connect.connect();
            PreparedStatement stm = c.prepareStatement("SELECT count(*) FROM Utilizador");
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

    @Override
    public boolean isEmpty() {
       return (this.size() == 0);
    }

    @Override
    public boolean containsKey(Object o) {
        boolean res = false;
        try {
            c = Connect.connect();
            String sql = "SELECT Nome FROM Utilizador WHERE Nome = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, (String)o);
            ResultSet rs = stm.executeQuery();
            res = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(c);
        }
        return res;
    }

    @Override
    public boolean containsValue(Object o) {
        boolean res = false;
        
        if(o.getClass().getName().equals("configuraFacil.Business.Utilizador")){
            Utilizador u = (Utilizador) o;
            String nome = u.getNome();
            Utilizador utilizador = this.get(nome);
            if(utilizador.equals(u)){
                res=true;
            }
        }
       return res;
    }

    @Override
    public Utilizador get(Object o) {
        //ta mal, so pus assim para n dar erro a compilar
        Utilizador u = new FuncStand();
        
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilizador WHERE Nome = ?");
            ps.setString(1,(String) o);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                u.setNome(rs.getNString("Nome"));
                u.setPassword(rs.getNString("Password"));
            } 
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
               Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return u;
    }

    @Override
    public Utilizador put(String k, Utilizador v) {
        Utilizador u;

        if(this.containsKey(k)){
            u = this.get(k);
        }
        else u = v;
        try{
            c = Connect.connect();
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Utilizador (Nome,Password) VALUES (?,?)");
            ps.setString(1,k);
            ps.setString(2,v.getPassword());
            ps.executeUpdate();
            
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return u;
        
    }

    @Override
    public Utilizador remove(Object o) {
        Utilizador u = this.get((String) o);
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Utilizador WHERE Nome = ?");
            ps.setString(1, (String) o);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return u;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> map) {
        for(Utilizador u : map.values()) {
            put(u.getNome(), u);
        }
    }

    @Override
    public void clear() {
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Utilizador");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> keys = null;
        
        try{
            c = Connect.connect();
            keys = new HashSet<>();
            PreparedStatement ps = c.prepareStatement("SELECT Nome FROM Utilizador");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                keys.add(rs.getString(1));
            }   
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return keys;
    }

    @Override
    public Collection<Utilizador> values() {
        Set<Utilizador> utilizadores = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String k : keys){
            utilizadores.add(this.get(k));
        }
        return utilizadores;
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        Map<String,Utilizador> map = new HashMap<>();
        
        for(String k : keys){
            map.put(k,this.get(k));
        }
        return map.entrySet();
    }
    
}
