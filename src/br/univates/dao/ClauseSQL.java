/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.dao;

/**
 *
 * @author Matheus
 */
public class ClauseSQL {
    
    private String clause;

    public ClauseSQL(String clausula) {
        this.clause = clausula;
    }

    public String getClausula() {
        return clause;
    }
    
}
