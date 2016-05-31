
package br.univates.entity;

import java.util.Calendar;

/**
 * 
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Voo {
    public static final String TABLE    = "voo";
    public static final String PRIMARYKEY = "id";
    
    private Integer id;
    private Calendar horario_artida;
    private Calendar horario_chegada;
    private Calendar data_voo;
    private Integer partida;
    private Integer chegada;
    private Integer avioes_id;
    private double valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getHorario_artida() {
        return horario_artida;
    }

    public void setHorario_artida(Calendar horario_artida) {
        this.horario_artida = horario_artida;
    }

    public Calendar getHorario_chegada() {
        return horario_chegada;
    }

    public void setHorario_chegada(Calendar horario_chegada) {
        this.horario_chegada = horario_chegada;
    }

    public Calendar getData_voo() {
        return data_voo;
    }

    public void setData_voo(Calendar data_voo) {
        this.data_voo = data_voo;
    }

    public Integer getPartida() {
        return partida;
    }

    public void setPartida(Integer partida) {
        this.partida = partida;
    }

    public Integer getChegada() {
        return chegada;
    }

    public void setChegada(Integer chegada) {
        this.chegada = chegada;
    }

    public Integer getAvioes_id() {
        return avioes_id;
    }

    public void setAvioes_id(Integer avioes_id) {
        this.avioes_id = avioes_id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
     
}
