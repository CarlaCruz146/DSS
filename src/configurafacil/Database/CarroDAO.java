/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;

import configurafacil.Business.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Grupo 30
 */
public class CarroDAO implements Map<String,Carro>{
     
    private Connection con;
    
    @Override
    public int size() {
        int i = -1;
        try {
            con = Connect.connect();
            PreparedStatement stm = con.prepareStatement("SELECT count(*) FROM Carro");
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            throw new NullPointerException(e.getMessage() + "Carro");
        }
        finally {
            Connect.close(con);
        }
        return i;
    }
    
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    @Override
    public boolean containsKey(Object key) {
        boolean r = false;
        try {
            con = Connect.connect();
            String sql = "SELECT Nome FROM Carro WHERE Nome = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, (String)key);
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage() + "Carro");
        } finally {
            Connect.close(con);
        }
        return r;
    }
    
    @Override
    public boolean containsValue(Object value) {
        boolean res = false;
        
        if(value.getClass().getName().equals("configuraFacil.Business.Carro")){
            Carro p = (Carro)value;
            String user = p.getNome();
            Carro p2 = this.get(user);
            if(p2.equals(p)){
                res=true;
            }
        }
       return res;
    }
    
    @Override
    public Carro get(Object key) {
        Carro p = new Carro();
        
        try{
            con = Connect.connect();
            String sql = "SELECT * FROM Carro WHERE Nome = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setNome(rs.getString("Nome"));
                p.setPreco(rs.getDouble("Preco"));   
            } 
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "pacotemememe");
        }
        finally{
            try{
               Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Carro");
            }
        }
        return p;
    }

    @Override
    public Carro put(String key, Carro value) {
        Carro p;

        if(this.containsKey(key)){
            p = this.get(key);
        }
        else p = value;
        try{
            con = Connect.connect();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Carro (Nome,Preco) VALUES (?,?)");
            ps.setString(1,key);
            ps.setString(2,Double.toString(value.getPreco()));
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Carro2");
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Carro");
            }
        }
        return p;
    }

    @Override
    public Carro remove(Object key) {
        Carro p = this.get((String) key);
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Carro WHERE Nome = ?");
            ps.setString(1, (String) key);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Carro");
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Carro");
            }
        }
        return p;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Carro> m) {
        for(Carro pacote : m.values()) {
            put(pacote.getNome(), pacote);
        }
    }
    
    @Override
    public void clear() {
        
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Carro");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Carro");
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Carro");
            }
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> set = null;
        
        try{
            con = Connect.connect();
            set = new HashSet<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Carro");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getString("Nome"));
            }   
        }
        catch(Exception e){
            System.out.printf(e.getMessage() + "Carro");
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage() + "Carro");
            }
        }
        return set;
    }
    
    @Override
    public Collection<Carro> values() {
        Set<Carro> set = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String key : keys){
            set.add(this.get(key));
        }
        return set;
    }

    @Override
    public Set<Map.Entry<String, Carro>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        
        HashMap<String,Carro> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
}
