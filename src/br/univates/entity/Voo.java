package br.univates.entity;

import br.univates.persistencia.Bd;
import static br.univates.entity.Passagem.PRIMARYKEY;
import static br.univates.entity.Passagem.TABLE;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Voo {

    public static final String TABLE = "voo";
    public static final String PRIMARYKEY = "id";

    private int id;
    private String horario_partida;
    private String horario_chegada;
    private String data_voo;
    private int partida;
    private int chegada;
    private int avioes_id;
    private double valor;

    
    @Bd
    public static String getTABLE() {
        return TABLE;
    }

    @Bd
    public static String getPRIMARYKEY() {
        return PRIMARYKEY;
    }

    @Bd
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bd
    public String getHorario_partida() {
        return horario_partida;
    }

    public void setHorario_partida(String horario_partida) {
        this.horario_partida = horario_partida;
    }

    @Bd
    public String getHorario_chegada() {
        return horario_chegada;
    }

    public void setHorario_chegada(String horario_chegada) {
        this.horario_chegada = horario_chegada;
    }

    @Bd
    public String getData_voo() {
        return data_voo;
    }

    public void setData_voo(String data_voo) {
        this.data_voo = data_voo;
    }

    @Bd
    public int getPartida() {
        return partida;
    }

    public void setPartida(int partida) {
        this.partida = partida;
    }

    @Bd
    public int getChegada() {
        return chegada;
    }

    public void setChegada(int chegada) {
        this.chegada = chegada;
    }

    @Bd
    public int getAvioes_id() {
        return avioes_id;
    }

    public void setAvioes_id(int avioes_id) {
        this.avioes_id = avioes_id;
    }

    @Bd
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
