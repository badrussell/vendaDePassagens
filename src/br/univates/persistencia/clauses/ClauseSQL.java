/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.persistencia.clauses;

import br.univates.persistencia.clauses.Where;

/**
 *
 * @author Matheus
 */
public abstract class ClauseSQL {
    
    private String clause;
    private Where where;
    
    public ClauseSQL(String clause) {
        this.clause = clause;
    }
  
    public abstract String getClause();
   
}
