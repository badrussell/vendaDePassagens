
package br.univates.entity;

import br.univates.util.Rota;
import java.util.Calendar;

public class Voo {
    public static final String TABLE    = "voo";
    public static final String PRIMARYKEY = "voo.id";
    
    private Integer id;
    private Calendar horaPartida;
    private Calendar horaChegada;
    private Calendar dataVoo;
    private Rota rota;
    private Aviao aviao;
    private double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Calendar horaPartida) {
        this.horaPartida = horaPartida;
    }

    public Calendar getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Calendar horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Calendar getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(Calendar dataVoo) {
        this.dataVoo = dataVoo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
