package br.univates.dao;

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

    /**
     * 
     * @return Retorna uma conexão com o BD
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws ClassNotFoundException {

        
        String servidor = "107.170.5.223:3306";
        String login = "root";
        String senha = "smolareck";
        String banco = "trabalho";
        
        String url = "jdbc:mysql://" + servidor + "/" + banco;
        
        Connection connection;
        
        try {
            connection = DriverManager.getConnection(url, login, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao conectar com o BD!!!", ex);
        }

        return connection;

    }
}
