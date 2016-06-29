package br.univates.entity;

import br.univates.persistencia.Bd;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Aviao {

    public static final String TABLE = "avioes";
    public static final String PRIMARYKEY = "id";

    private int id;
    private double valor_aviao;
    private String nome;
    private String descricao;
    private int companhias_aereas_id;
    private int numero_assentos;

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
    public double getValor_aviao() {
        return valor_aviao;
    }

    public void setValor_aviao(double valor_aviao) {
        this.valor_aviao = valor_aviao;
    }

    @Bd
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Bd
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Bd
    public int getCompanhias_aereas_id() {
        return companhias_aereas_id;
    }

    public void setCompanhias_aereas_id(int companhias_aereas_id) {
        this.companhias_aereas_id = companhias_aereas_id;
    }

    @Bd
    public int getNumero_assentos() {
        return numero_assentos;
    }

    public void setNumero_assentos(int numero_assentos) {
        this.numero_assentos = numero_assentos;
    }

}
