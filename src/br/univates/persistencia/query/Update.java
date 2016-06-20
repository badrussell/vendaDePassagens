/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia.query;

import br.univates.persistencia.Script;

/**
 *
 * @author Matheus
 */
public class Update implements SetQuery {

    private String query;
    private Object obj;
    private String table;
    private String[] columns;
    private String[] values;

    public Update(String table, String[] columns, String[] values, String pk, String valuePK) {
        this.table = table;
        this.columns = columns;
        this.values = values;
        this.query = Script.getUpdate(table, columns, values, pk, valuePK);
    }

    public Update(Object obj) {
        this.obj = obj;
        this.query = Script.getUpdate(obj);
    }

    @Override
    public String getQuery() {
        return query;

    }

}
