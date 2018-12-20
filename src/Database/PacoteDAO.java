/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import configurafacil.Business.Componente;
import configurafacil.Business.Pacote;
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
public class PacoteDAO implements Map<String,Pacote> {
    
    private Connection con;
        
    @Override
    public int size() {
        int i = -1;
        try {
            con = Connect.connect();
            PreparedStatement stm = con.prepareStatement("SELECT count(*) FROM Pacote");
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
            String sql = "SELECT Nome FROM Pacote WHERE Nome = ?";
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
        
        if(value.getClass().getName().equals("configuraFacil.Business.Pacote")){
            Pacote p = (Pacote)value;
            String user = p.getNome();
            Pacote p2 = this.get(user);
            if(p2.equals(p)){
                res=true;
            }
        }
       return res;
    }
    
    @Override
    public Pacote get(Object key) {
        Pacote p = new Pacote();
        
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Pacote WHERE Nome = ?");
            ps.setString(1,(String) key);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
              //  p.setNome(rs.getString("Nome"));
                p.setPreco(rs.getDouble("Preco"));   
                List<Componente> componentes = new ArrayList();
                ps = con.prepareStatement("SELECT * FROM Componente WHERE Pacote = ?");
                ps.setString(1,(String) key);
                rs = ps.executeQuery();
                while(rs.next()){
                    componentes.add(new Componente(rs.getString("Nome"),rs.getString("Tipo"),rs.getDouble("Preco"),null,null));
                }
                p.setComponentes(componentes);
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
        return p;
    }

    @Override
    public Pacote put(String key, Pacote value) {
        Pacote p;

        if(this.containsKey(key)){
            p = this.get(key);
        }
        else p = value;
        try{
            con = Connect.connect();
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO Pacote (Nome,Preco) VALUES (?,?)");
            ps.setString(1,key);
            ps.setDouble(2,value.getPreco());
            ps.executeUpdate();
           
            List<Componente> list = value.getComponentes();
            if(list!=null){
                for(Componente c : list){
                    ps = con.prepareStatement("INSERT INTO Componente (Nome,Tipo,Preco,null,null) VALUES (?,?,?,?,?)");
                    ps.setString(1,key);
                    ps.setString(3,c.getTipo());
                    ps.setDouble(4,c.getPreco());
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
        return p;
    }

    @Override
    public Pacote remove(Object key) {
        Pacote p = this.get((String) key);
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Pacote WHERE Nome = ?");
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
        return p;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Pacote> m) {
        for(Pacote pacote : m.values()) {
            put(pacote.getNome(), pacote);
        }
    }
    
    @Override
    public void clear() {
        
        try{
            con = Connect.connect();
            PreparedStatement ps = con.prepareStatement("DELETE FROM Pacote");
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
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Pacote");
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
    public Collection<Pacote> values() {
        Set<Pacote> set = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String key : keys){
            set.add(this.get(key));
        }
        return set;
    }

    @Override
    public Set<Entry<String, Pacote>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        
        HashMap<String,Pacote> map = new HashMap<>();
        for(String key : keys){
            map.put(key,this.get(key));
        }
        return map.entrySet();
    }
}
