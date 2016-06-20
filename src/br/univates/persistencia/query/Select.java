/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia.query;

import br.univates.persistencia.clauses.ClauseSQL;
import br.univates.persistencia.ManipulateClass;
import br.univates.persistencia.Script;

/**
 *
 * @author Matheus
 */
public class Select implements GetQuery {

    private String query;
    private Object obj;
    private String table;
    private String[] columns;
    private int type; //0 - Object / 1 - Manual

    public Select(Object obj) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT * FROM " + table;
        this.type = 0;
    }

    public Select(Object obj, ClauseSQL clause1) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT * FROM " + table + " "
                + clause1.getClause();
        this.type = 0;
    }

    public Select(Object obj, ClauseSQL clause1, ClauseSQL clause2) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT * FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause();
        this.type = 0;
    }

    public Select(Object obj, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT * FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause();
        this.type = 0;
    }

    public Select(Object obj, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4) {
        this.obj = obj;
        this.table = ManipulateClass.getTableClass(obj);
        this.query = "SELECT * FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause();
        this.type = 0;
    }

    public Select(String table, String[] columns) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT " + Script.getSelect(columns) + " FROM " + table + " ";
        this.type = 1;
    }

    public Select(String table, String[] columns, ClauseSQL clause1) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause();
        this.type = 1;
    }

    public Select(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause();
        this.type = 1;
    }

    public Select(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause();
        this.type = 1;
    }

    public Select(String table, String[] columns, ClauseSQL clause1, ClauseSQL clause2, ClauseSQL clause3, ClauseSQL clause4) {
        this.table = table;
        this.columns = columns;
        this.query = "SELECT " + Script.getSelect(columns) + " FROM " + table + " "
                + clause1.getClause() + " "
                + clause2.getClause() + " "
                + clause3.getClause() + " "
                + clause4.getClause();
        this.type = 1;
    }

    @Override
    public String getQuery() {
        return query;
    }

    @Override
    public String getTable() {
        return table;
    }

    @Override
    public int getTypeQuery() {
        return type;
    }

    @Override
    public String[] getColumns() {
        return columns;
    }

}
