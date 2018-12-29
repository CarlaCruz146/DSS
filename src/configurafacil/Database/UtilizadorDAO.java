/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil.Database;



import configurafacil.Business.GestaoUtilizadores.FuncFabrica;
import configurafacil.Business.GestaoUtilizadores.FuncStand;
import configurafacil.Business.GestaoUtilizadores.Utilizador;
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
            String sql = "SELECT * FROM Utilizador WHERE Nome = ?";
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
        
        if(o.getClass().getName().equals("configuraFacil.Business.GestaoUtilizadores.Utilizador")){
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

        Utilizador utilizador = null;
        
        try{
            c = Connect.connect();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilizador WHERE Nome = ?");
            ps.setString(1,(String) o);
            ResultSet rs = ps.executeQuery();
             if(rs.next()){
                String nome, password;
                int estado;
                nome = rs.getString("Nome");
                password = rs.getString("Password");
                estado = rs.getInt("Estado");
                
                PreparedStatement stmFF = c.prepareStatement("SELECT * FROM FuncFabrica WHERE Utilizador = ?");
                stmFF.setString(1, nome);
                ResultSet rsFF = stmFF.executeQuery();
                if (rsFF.next()) {
                   FuncFabrica f = new FuncFabrica();
                   f.setNome(nome);
                   f.setPassword(password);
                   f.setEstado(estado);
                   utilizador = f;
                }
                else{
                    PreparedStatement stmFS = c.prepareStatement("SELECT * FROM FuncStand WHERE Utilizador = ?");
                    stmFS.setString(1, nome);
                    ResultSet rsFS = stmFS.executeQuery();
                    if (rsFS.next()) {
                       FuncStand f = new FuncStand();
                       f.setNome(nome);
                       f.setPassword(password);
                       f.setEstado(estado);
                       utilizador = f;
                    }
                }
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
        return utilizador;
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
            
            PreparedStatement ps = c.prepareStatement("INSERT INTO Utilizador (Nome,Password,Estado) VALUES (?,?,?)\n" +
                                                     "ON DUPLICATE KEY UPDATE Estado = VALUES(Estado);\n");
            ps.setString(1,k);
            ps.setString(2,v.getPassword());
            ps.setInt(3,v.getEstado());
            
            ps.executeUpdate();
            
             if(v instanceof FuncStand){
                PreparedStatement stm = c.prepareStatement("INSERT INTO FuncStand (Utilizador) VALUES (?)\n" +
                                                            "ON DUPLICATE KEY UPDATE Utilizador = VALUES(Utilizador);\n");
                stm.setString(1, v.getNome());
                stm.executeUpdate();
            }
            else{
                if(v instanceof FuncFabrica){
                    PreparedStatement stm = c.prepareStatement("INSERT INTO FuncFabrica (Utilizador) VALUES (?)\n" +
                                                               "ON DUPLICATE KEY UPDATE Utilizador = VALUES(Utilizador);\n");
                    stm.setString(1, v.getNome());
                    stm.executeUpdate();
                    System.out.print(v.getEstado());
                }
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
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Utilizador");
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
