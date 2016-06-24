/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.univates.persistencia.query.GetQuery;
import br.univates.persistencia.query.SetQuery;

/**
 *
 * @author Matheus
 */
public class Dao {

    public static ArrayList<String[]> get(GetQuery query) {
        //Imprime no Console a variavel
        System.out.println(query.getQuery());
        //Variavel auxiliar
        int j = 0, i = 0;
        //Array de retorno
        ArrayList<String[]> aValues = new ArrayList();
        //Busca: Número de Linhas a retornar na consulta
        int lines = DaoUtil.getContLinesSelect(query.getQuery());
        //Se a consulta não retornar nenhuma linha retorna null
        if (lines != 0) {
            //Cria conexão
            try (Connection con = ConFactory.getConnection()) {
                Statement statement = con.createStatement();
                statement.execute(query.getQuery());

                System.out.println("Query: " + query.getQuery());
                
                ResultSet rs = statement.getResultSet();
                //Verifica o tipo de GetQuery
                if (query.getTypeQuery() == 0) { 
                    ArrayList<String> aColumns = DaoUtil.getNameColumns(query.getTable());
                    String[][] linha = new String[lines][aColumns.size()];

                    while (rs.next()) {

                        for (String string : aColumns) {
                            linha[j][i] = rs.getString(aColumns.get(i));
                            i++;
                        }
                        aValues.add(linha[j]);
                        j++;
                        i = 0;
                    }

                    con.close();
                } else if (query.getTypeQuery() == 1) {
                    String[] aColumns2 = query.getColumns();
                    String[][] linha = new String[lines][aColumns2.length];
                    
                    while (rs.next()) {
                        for (int k = 0; k < aColumns2.length; k++) {
                            linha[j][k] = rs.getString(aColumns2[k]);
                        }

                        aValues.add(linha[j]);
                        j++;

                    }
                }

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("Sem Registros!");
        }

        return aValues;
    }

    public static boolean set(SetQuery query) {
        //Variavel que vai retornar o sucesso
        boolean result = true;
        System.out.println(query.getQuery());
        
        //Cria a conexão
        try (Connection con = ConFactory.getConnection()) {

            Statement statement = con.createStatement();
            result = statement.execute(query.getQuery());
            
            con.close();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
