/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;

import configurafacil.Business.Componente;
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
 * @author jessica
 */
public class ComponenteDAO implements Map<String,Componente> {
        
    private Connection con;
        
    @Override
    public int size() {
        int i = -1;
        try {
            con = Connect.connect();
            PreparedStatement stm = con.prepareStatement("SELECT count(*) FROM Componente");
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
            String sql = "SELECT Nome FROM Componente WHERE Nome = ?";
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
        
        if(value.getClass().getName().equals("configuraFacil.Business.Componente")){
            Componente c = (Componente)value;
            String user = c.getNome();
            Componente c2 = this.get(user);
            if(c2.equals(c)){
                res=true;
            }
        }
       return res;
    }
    
    @Override
    public Componente get(Object key) {
        Componente c = new Componente();
        
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Componente WHERE Nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                c.setNome(rs.getString("Nome"));
                c.setPreco(rs.getDouble("Preco")); 
                c.setTipo(rs.getString("Tipo"));  
                List<String> compObrigatorias = new ArrayList<>();
                ps = con.prepareStatement("SELECT Nome FROM ComponenteObrigatoria WHERE Componente = ?");
                ps.setString(1,(String) key);
                rs = ps.executeQuery();
                while(rs.next()){
                    compObrigatorias.add(rs.getString("Nome"));
                }
                c.setObrigatorias(compObrigatorias);
                List<String> compIncompativeis = new ArrayList<>();
                ps = con.prepareStatement("SELECT Nome FROM ComponenteIncompativel WHERE Componente = ?");
                ps.setString(1,(String) key);
                rs = ps.executeQuery();
                while(rs.next()){
                    compIncompativeis.add(rs.getString("Nome"));
                }
                c.setIncompativeis(compIncompativeis);
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
        return c;
    }

    @Override
    public Componente put(String key, Componente value) {
        Componente c;
        if(this.containsKey(key)){
            c = this.get(key);
        }
        else c = value;
        try{
            con = Connect.connect();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Componente (Nome,Tipo,Preco) VALUES (?,?,?)");
            ps.setString(1,key);
            ps.setString(2,value.getTipo());
            ps.setDouble(3,value.getPreco());
            ps.executeUpdate();
           
            List<String> listIncomp = value.getIncompativeis();
            if(listIncomp!=null){
                for(String s : listIncomp){
                    ps = con.prepareStatement("INSERT INTO ComponenteIncompativel (Nome) VALUES (?)");
                    ps.setString(1,s);
                    ps.executeUpdate();
                }
            }
            List<String> listObrig = value.getObrigatorias();
            if(listObrig!=null){
                for(String st : listObrig){
                    ps = con.prepareStatement("INSERT INTO ComponenteObrigatoria (Nome) VALUES (?)");
                    ps.setString(1,st);
                    ps.executeUpdate();
                }
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
        return c;
    }

    @Override
    public Componente remove(Object key) {
        Componente c = this.get((String) key);
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Componente WHERE Nome = ?");
            ps.setString(1, (String) key);
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
        return c;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Componente> m) {
        for(Componente componente : m.values()) {
            put(componente.getNome(), componente);
        }
    }
    
    @Override
    public void clear() {
        
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Componente");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Componente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                set.add(rs.getString("Nome"));
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
    public Collection<Componente> values() {
        Set<Componente> set = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String key : keys){
            set.add(this.get(key));
        }
        return set;
    }

    @Override
    public Set<Map.Entry<String, Componente>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        
        HashMap<String,Componente> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
}
