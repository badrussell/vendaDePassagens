package br.univates.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Util {

    /**
     *
     * @param table - tabela a ser contada
     * @param where - clausula where a ser usada
     * @param groupBy
     * @param orderBy
     * @return Retorna o número de linhas de uma consulta
     */
    public static int getContLinesSelect(String table, ClauseSQL where, ClauseSQL groupBy, ClauseSQL orderBy) {
        int ret = 0;
        String query;

        if (where != null) {
            query = "SELECT COUNT(*) FROM " + table + " WHERE " + where.getClausula();
        } else if (where != null && groupBy != null) {
            query = "SELECT COUNT(*) FROM " + table + " WHERE " + where.getClausula() + " GROUP BY " + groupBy.getClausula();
        } else if (where != null && groupBy != null && orderBy != null) {
            query = "SELECT COUNT(*) FROM " + table + " WHERE " + where.getClausula() + " GROUP BY " + groupBy.getClausula() + " ORDER BY " + orderBy.getClausula();
        } else if (where != null && orderBy != null){
            query = "SELECT COUNT(*) FROM " + table + " WHERE " + where.getClausula() + " ORDER BY " + orderBy.getClausula();
        } else {
            query = "SELECT COUNT(*) FROM " + table;
        }

        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);

            ResultSet rs = statement.getResultSet();
            rs.next();

            ret = Integer.parseInt(rs.getString("COUNT(*)"));

            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    /**
     *
     * @param tabela - Tabela do BD
     * @return Retorna um ArrayList com o Nome das Colunas
     */
    public static ArrayList<String> getNameColumns(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_NAME = '" + tabela + "'";
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(rs.getString("COLUMN_NAME"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    /**
     *
     * @param tabela - Tabela do BD
     * @return Retorna um ArrayList com o Tipo de dados das Colunas
     */
    public static ArrayList<String> getTDataColumns(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SELECT DATA_TYPE FROM information_schema.COLUMNS WHERE TABLE_NAME = '" + tabela + "'";
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(rs.getString("DATA_TYPE"));
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    /**
     *
     * @param tabela - Tabela do BD
     * @return Retorna uma matriz com os Nomes das Colunas e Tipo de dados
     */
    public static ArrayList<String[]> getDataColumns(String tabela) {

        ArrayList<String[]> ret = new ArrayList<>();

        String query = "SELECT COLUMN_NAME, DATA_TYPE, EXTRA FROM information_schema.COLUMNS WHERE TABLE_NAME = '" + tabela + "'";

        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(new String[]{
                    rs.getString("COLUMN_NAME"),
                    rs.getString("DATA_TYPE"),
                    rs.getString("EXTRA")
                });
            }
            con.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static ArrayList<String[]> getAutoIncrement(String tabela) {

        ArrayList<String[]> ret = new ArrayList<>();
        String query = "SELECT COLUMN_NAME, EXTRA FROM information_schema.COLUMNS WHERE TABLE_NAME = '" + tabela + "'";
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);
            ResultSet rs = statement.getResultSet();
            while (rs.next()) {
                ret.add(new String[]{
                    rs.getString("COLUMN_NAME"),
                    rs.getString("EXTRA")
                });
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

}
