/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;

import configurafacil.Business.Componente;
import configurafacil.Business.Encomenda;
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
 * @author mercy
 */
public class EncomendaDAO implements Map<Integer,Encomenda> {
    
    private Connection c;

    @Override
    public int size() {
       int s = -1;
        try {
            c = Connect.connect();
            PreparedStatement stm = c.prepareStatement("SELECT count(*) FROM Encomenda");
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
            String sql = "SELECT idEncomenda FROM Encomenda WHERE idEncomenda = ?";
            PreparedStatement stm = c.prepareStatement(sql);
            stm.setString(1, Integer.toString((Integer) o));
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
        
        if(o.getClass().getName().equals("configuraFacil.Business.Encomenda")){
            Encomenda e = (Encomenda) o;
            int id = e.getId();
            Encomenda enc = this.get(id);
            if(enc.equals(e)){
                res = true;
            }
        }
       return res;
    }

    @Override
    public Encomenda get(Object o) {
       Encomenda e = new Encomenda();
        
        try{
            c = Connect.connect();
            String sql = "SELECT * FROM Encomenda WHERE idEncomenda = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, Integer.toString((Integer) o));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                e.setId(rs.getInt("idEncomenda"));
                e.setCarro(rs.getString("Carro"));   
                e.setEstado(rs.getInt("Estado"));
                e.setPacote(rs.getString("Pacote"));
                e.setCliente(rs.getString("Cliente"));
                sql = "SELECT Nome FROM Componente AS C\n" + 
                        "JOIN Encomenda_Componente AS EC ON C.nome = EC.Componente" +
                        "WHERE EC.Encomenda = ?;";
                ps = c.prepareStatement(sql);
                ps.setInt(1, (Integer) o);
                rs = ps.executeQuery();
                List<String> componentes = new ArrayList<>();
                while (rs.next()) { 
                        componentes.add(rs.getString("Componente"));
                }
                e.setConfig(componentes);
            } 
        }
        catch(Exception ex){
            System.out.printf(ex.getMessage());
        }
        finally{
            try{
               Connect.close(c);
            }
            catch(Exception ex){
                System.out.printf(ex.getMessage());
            }
        }
        return e;
    }

    @Override
    public Encomenda put(Integer k, Encomenda v) {
        Encomenda e;

        if(this.containsKey(k)){
            e = this.get(k);
        }
        else e = v;
        try{
            c = Connect.connect();
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Encomenda (IdEncomenda,Carro,Estado,Cliente,Pacote,Fabrica) VALUES (?,?,?,?,?,?)");
            ps.setString(1,Integer.toString(k));
            ps.setString(2,v.getCarro());
            ps.setString(3,Integer.toString(v.getEstado()));
            ps.setString(4, v.getCliente());
            ps.setString(5, v.getPacote());
            ps.setInt(6,1);
            ps.executeUpdate();
            
            if(v.getNConfig()>0){
                String sql = "INSERT INTO Encomenda_Componentes\n" +
                      "VALUES (? ?)\n" +
                      "ON DUPLICATE KEY UPDATE Componente = VALUES(Componente);";
                ps = c.prepareStatement(sql);
                for(String s : v.getConfig()){
                    ps.setString(1, s);
                }
            }
        }
        catch(Exception ex){
            System.out.printf(ex.getMessage() + "memememem");
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception ex){
                System.out.printf(ex.getMessage());
            }
        }
        return e;
    }

    @Override
    public Encomenda remove(Object o) {
        Encomenda e = this.get((Integer) o);
        
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Encomenda WHERE idEncomenda = ?");
            ps.setString(1, Integer.toString((Integer) o));
            ps.executeUpdate();
            
            if(e.getNConfig()>0){
                String sql = "DELETE FROM Encomenda WHERE idEncomenda = ?;";
                ps = c.prepareStatement(sql);
                ps.setString(1, (String) o);
                ps.executeUpdate();
            }
        }
        catch(Exception ex){
            System.out.printf(ex.getMessage());
        }
        finally{
            try{
                Connect.close(c);
            }
            catch(Exception ex){
                System.out.printf(ex.getMessage());
            }
        }
        return e;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Encomenda> map) {
        for(Encomenda e : map.values()) {
            put(e.getId(), e);
        }
    }

    @Override
    public void clear() {
       try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Encomenda");
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
    public Set<Integer> keySet() {
      Set<Integer> keys = null;
        
        try{
            c = Connect.connect();
            keys = new HashSet<>();
            PreparedStatement ps = c.prepareStatement("SELECT idEncomenda FROM Encomenda");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                keys.add(rs.getInt(1));
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
    public Collection<Encomenda> values() {
        Set<Encomenda> encs = new HashSet<>();
        Set<Integer> keys = new HashSet<>(this.keySet());
        for(Integer k : keys){
            encs.add(this.get(k));
        }
        return encs;
    }

    @Override
    public Set<Entry<Integer, Encomenda>> entrySet() {
        Set<Integer> keys = new HashSet<>(this.keySet());
        Map<Integer,Encomenda> map = new HashMap<>();
        
        for(Integer k : keys){
            map.put(k,this.get(k));
        }
        return map.entrySet();
    }
    
}
