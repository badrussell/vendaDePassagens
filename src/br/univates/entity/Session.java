/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.entity;

import br.univates.entity.Cliente;

/**
 *
 * @author Matheus
 */
public class Session {
    
    private static Cliente Cliente = null;
    private static Integer idPassagem = null;
    private static Aviao aviao = null;
    private static Voo voo = null;

    public static Cliente getCliente() {
        return Cliente;
    }

    public static void setCliente(Cliente Cliente) {
        Session.Cliente = Cliente;
    }
    
    public static Integer getIdPassagem() {
        return idPassagem;
    }

    public static void setIdPassagem(Integer idPassagem) {
        Session.idPassagem = idPassagem;
    }
   
    public static Aviao getAviao() {
        return aviao;
    }

    public static void setAviao(Aviao aviao) {
        Session.aviao = aviao;
    }

    public static Voo getVoo() {
        return voo;
    }

    public static void setVoo(Voo voo) {
        Session.voo = voo;
    }
}