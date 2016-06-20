/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia.query;

/**
 *
 * @author Matheus
 */
public class Delete implements SetQuery{

    private String query;
    private Object obj;
    private String table;
    private String[] columns;
    private String[] values;

    public String getQuery() {
        return query;
    }

}
