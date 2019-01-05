/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configurafacil;

import configurafacil.Business.ConfiguraFacil;
import configurafacil.Presentation.Login;

/**
 *
 * @author Grupo 30
 */
public class ConfiguraFacilApp {
    public static void main(String[] args){
        ConfiguraFacil c = new ConfiguraFacil();
        Login l = new Login(c);
        l.setVisible(true);
    }
}
