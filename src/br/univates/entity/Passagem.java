
package br.univates.entity;

import java.util.Calendar;

public class Passagem {
    public static final String TABLE    = "passagens";
    public static final String PRIMARYKEY = "passagens.id";
    
    private Integer id;
    private double valor;
    private Voo voo;
    private Categoria Assento;
    private Calendar validade;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    public Categoria getAssento() {
        return Assento;
    }

    public void setAssento(Categoria Assento) {
        this.Assento = Assento;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }
    
    
    
}
