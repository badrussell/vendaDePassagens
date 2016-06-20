/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import br.univates.persistencia.Bd;

/**
 *
 * @author Matheus
 */
public class Voos {

    private static final String TABLE = "voos";
    private static final String PRIMARYKEY = "id";
    
    private int id = 15;
    private String horario_partida = "2016-05-05 20:30:00";
    private String horario_chegada = "2016-05-05 21:00:00";
    private int avioes_id = 12;
    private int partida = 1;
    private int chegada = 10;
    private String data_voo = "2016-05-05";
    private double valor_voo = 254.17;
    private int promocao = 0;

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

    @Bd
    public String getHorario_partida() {
        return horario_partida;
    }

    @Bd
    public String getHorario_chegada() {
        return horario_chegada;
    }

    @Bd
    public int getAvioes_id() {
        return avioes_id;
    }

    @Bd
    public int getPartida() {
        return partida;
    }

    @Bd
    public int getChegada() {
        return chegada;
    }

    @Bd
    public String getData_voo() {
        return data_voo;
    }

    @Bd
    public double getValor_voo() {
        return valor_voo;
    }

    @Bd
    public int getPromocao() {
        return promocao;
    }

    
}
