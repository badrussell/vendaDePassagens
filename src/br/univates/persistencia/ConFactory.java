package br.univates.persistencia;

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

      private static final String servidor = "107.170.5.223:3306";
      private static final String login = "root";
      private static final String senha = "smolareck";
      private static final  String banco = "trabalho";


//        private static final String servidor = "localhost";
//        private static final String login = "root";
//        private static final String senha = "root";
//        private static final String banco = "trabalho";
    
    /**
     * 
     * @return Retorna uma conexão com o BD
     * @throws ClassNotFoundException 
     */
    public static Connection getConnection() throws ClassNotFoundException {
     
        String url = "jdbc:mysql://" + servidor + "/" + banco;
        
        Connection connection;
        
        try {
            connection = DriverManager.getConnection(url, login, senha);
            System.out.println(url);
        } catch (SQLException ex) {
            Logger.getLogger(ConFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao conectar com o BD!!!", ex);
        }

        return connection;

    }

    public static String getBanco() {
        return banco;
    }
    
    
}
