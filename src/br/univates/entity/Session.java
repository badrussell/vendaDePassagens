/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.entity;

/**
 *
 * @author Matheus
 */
public class Session {
    
    private static Integer idCliente = null;
    private static Integer idPassagem = null;

    public static Integer getIdCliente() {
        return idCliente;
    }

    public static void setIdCliente(Integer idCliente) {
        Session.idCliente = idCliente;
    }

    public static Integer getIdPassagem() {
        return idPassagem;
    }

    public static void setIdPassagem(Integer idPassagem) {
        Session.idPassagem = idPassagem;
    }
    
    
}
