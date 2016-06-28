package br.univates.persistencia;

import br.univates.persistencia.clauses.ClauseSQL;
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
public class DaoUtil {


    public static int getContLinesSelect(String query) {
        int ret = 0;

        if (query.contains("*")) {
            query = query.replace("*", "COUNT(*)");
            System.out.println(query);
        } else {
            String[] q = query.split(" ");
            for (int i = 0; i < q.length; i++) {
                if (q[i].equals("SELECT")) {
                    query = q[i] + " COUNT(*) ";
                } else if (q[i].equals("FROM")) {
                    for (int j = i; j < q.length; j++) {
                        query += q[j] + " ";
                    }
                }
            }
        }
        System.out.println(query);
        try (Connection con = ConFactory.getConnection()) {
            Statement statement = con.createStatement();
            statement.execute(query);

            ResultSet rs = statement.getResultSet();
            rs.next();

            ret = Integer.parseInt(rs.getString("COUNT(*)"));

            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DaoUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }

    public static ArrayList<String> getNameColumns(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SELECT COLUMN_NAME FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "'";
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
    
    public static ArrayList<String> getTDataColumns(String tabela) {

        ArrayList<String> ret = new ArrayList<>();
        String query = "SELECT DATA_TYPE FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "'";
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

    public static ArrayList<String[]> getDataColumns(String tabela) {

        ArrayList<String[]> ret = new ArrayList<>();

        String query = "SELECT COLUMN_NAME, DATA_TYPE, EXTRA FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "'";
        System.out.println(query);
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
        String query = "SELECT COLUMN_NAME, EXTRA FROM information_schema.COLUMNS WHERE TABLE_SCHEMA = '" + ConFactory.getBanco() + "' AND TABLE_NAME = '" + tabela + "'";
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
