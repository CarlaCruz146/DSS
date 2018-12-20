/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.Map;
import configurafacil.Business.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mercy
 */
public class ClienteDAO implements Map<String,Cliente>{
    private Connection c;

    @Override
    public int size() {
       int s = -1;
        try {
            c = Connect.connect();
            PreparedStatement stm = c.prepareStatement("SELECT count(*) FROM Cliente");
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
            String sql = "SELECT Nif FROM Cliente WHERE Nif = ?";
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
        
        if(o.getClass().getName().equals("configuraFacil.Business.Cliente")){
            Cliente cl = (Cliente) o;
            String nif = cl.getNif();
            Cliente cliente = this.get(nif);
            if(cliente.equals(cl)){
                res=true;
            }
        }
       return res;
    }

    @Override
    public Cliente get(Object o) {
        Cliente cl = new Cliente();
        
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("SELECT  FROM Cliente WHERE Nif = ?");
            ps.setString(1,(String) o);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){ // se existir
                cl.setNif(rs.getString("Nif"));
                cl.setNome(rs.getNString("Nome"));
                cl.setContacto(rs.getNString("Contacto"));
                cl.setLimite(rs.getDouble("Limite"));
                ArrayList<Integer> encomendas = new ArrayList();
                
                ps = c.prepareStatement("SELECT idEncomenda FROM Encomenda WHERE Nif = ?");
                ps.setString(1,(String)o);
                rs = ps.executeQuery();
                while(rs.next()){
                    encomendas.add(rs.getInt("idEncomenda"));
                }
                
                cl.setEncomendas(encomendas);
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
        return cl;
    }

    @Override
    public Cliente put(String k, Cliente v) {
        Cliente cl;

        if(this.containsKey(k)){
            cl = this.get(k);
        }
        else cl = v;
        try{
            c = Connect.connect();
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Cliente (Nome,Nif,Contacto,Limite) VALUES (?,?,?,?)");
            ps.setString(1,v.getNome());
            ps.setString(2,k);
            ps.setString(3,v.getContacto());
            ps.setDouble(4,v.getLimite());
            ps.executeUpdate();
           
            ArrayList<Integer> encs = v.getEncomendas();
            if(encs != null){
                //n sei se tenho de fazer alguma coisa com as encomendas??
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
        return cl;
    }

    @Override
    public Cliente remove(Object o) {
        Cliente cl = this.get((String) o);
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Cliente WHERE Nif = ?");
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
        return cl;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Cliente> map) {
        for(Cliente cl : map.values()) {
            put(cl.getNif(), cl);
        }
    }

    @Override
    public void clear() {
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("DELETE FROM Cliente");
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
            PreparedStatement ps = c.prepareStatement("SELECT Nif FROM Cliente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                keys.add(rs.getString("Nif"));
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
    public Collection<Cliente> values() {
        Set<Cliente> clientes = new HashSet<>();
        Set<String> keys = new HashSet<>(this.keySet());
        for(String k : keys){
            clientes.add(this.get(k));
        }
        return clientes;
    }

    @Override
    public Set<Entry<String, Cliente>> entrySet() {
        Set<String> keys = new HashSet<>(this.keySet());
        Map<String,Cliente> map = new HashMap<>();
        
        for(String k : keys){
            map.put(k,this.get(k));
        }
        return map.entrySet();
    }
    
    
    
    
}
