/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;

import configurafacil.Business.Fabrica.Stock;
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
 * @author Grupo 30
 */
public class StockDAO implements Map<String,Stock>{
     
    private Connection con;
    
    @Override
    public int size() {
        int i = -1;
        try {
            con = Connect.connect();
            PreparedStatement stm = con.prepareStatement("SELECT count(*) FROM Stock");
            ResultSet rs = stm.executeQuery();
            if(rs.next()) {
                i = rs.getInt(1);
            }
        }
        catch (Exception e) {
            throw new NullPointerException(e.getMessage());
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
            String sql = "SELECT Componente FROM Stock WHERE Componente = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, (String)key);
            ResultSet rs = stm.executeQuery();
            r = rs.next();
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        } finally {
            Connect.close(con);
        }
        return r;
    }
    
    @Override
    public boolean containsValue(Object value) {
        boolean res = false;
        
        if(value.getClass().getName().equals("configuraFacil.Business.Fabrica.Stock")){
            Stock s = (Stock)value;
            String comp = s.getComponente();
            Stock s2 = this.get(comp);
            if(s2.equals(s)){
                res=true;
            }
        }
       return res;
    }
    
    @Override
    public Stock get(Object key) {
       Stock s = new Stock();
        
        try{
            con = Connect.connect();
            String sql = "SELECT * FROM Stock WHERE Componente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                s.setComponente(rs.getString("Componente"));
                s.setQuantidade(rs.getInt("Quantidade"));   
            } 
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
               Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return s;
    }

    @Override
    public Stock put(String key, Stock value) {
        Stock p;

        if(this.containsKey(key)){
            p = this.get(key);
        }
        else p = value;
        try{
            con = Connect.connect();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Stock (Quantidade,Componente) VALUES (?,?)\n" +  
                                                        "ON DUPLICATE KEY UPDATE Quantidade = VALUES(Quantidade);\n");
            ps.setString(1,Integer.toString(value.getQuantidade()));
            ps.setString(2,key);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return p;
    }

    @Override
    public Stock remove(Object key) {
        throw new UnsupportedOperationException("Não implementado");
    }

    @Override
    public void putAll(Map<? extends String, ? extends Stock> m) {
        for(Stock s : m.values()) {
            put(s.getComponente(), s);
        }
    }
    
    @Override
    public void clear() {
        
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Stock");
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
    }

    @Override
    public Set<String> keySet() {
        Set<String> set = null;
        
        try{
            con = Connect.connect();
            set = new HashSet<>();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Stock");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getString("Componente"));
            }   
        }
        catch(Exception e){
            System.out.printf(e.getMessage());
        }
        finally{
            try{
                Connect.close(con);
            }
            catch(Exception e){
                System.out.printf(e.getMessage());
            }
        }
        return set;
    }
    
    @Override
    public Collection<Stock> values() {
        Set<Stock> set = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String key : keys){
            set.add(this.get(key));
        }
        return set;
    }

    @Override
    public Set<Map.Entry<String, Stock>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        
        HashMap<String,Stock> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
}
