/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class ConFactory {

    public static Connection getConnection() throws ClassNotFoundException {

        String servidor = "107.170.5.223:3306";
        String login = "root";
        String senha = "smolareck";
        String banco = "trabalho";

        String url = "jdbc:mysql://" + servidor + "/" + banco;
        
        Connection connection;
        
        try {
            connection = DriverManager.getConnection(url, login, senha);
            System.out.println("Conectado ao " + url);
        } catch (SQLException ex) {
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao conectar com o BD!!!", ex);
        }

        return connection;

    }
}
