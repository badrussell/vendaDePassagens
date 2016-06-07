package br.univates.entity;

import br.univates.dao.Bd;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Aviao {

    public static final String TABLE = "avioes";
    public static final String PRIMARYKEY = "id";

    private Integer id;
    private double valor_aviao;
    private String nome;
    private String descricao;
    private Integer companhias_aereas_id;
    private Integer numero_assentos;

    @Bd
    public static String getTABLE() {
        return TABLE;
    }

    @Bd
    public static String getPRIMARYKEY() {
        return PRIMARYKEY;
    }

    @Bd
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public Integer getCompanhias_aereas_id() {
        return companhias_aereas_id;
    }

    public void setCompanhias_aereas_id(Integer companhias_aereas_id) {
        this.companhias_aereas_id = companhias_aereas_id;
    }

    @Bd
    public Integer getNumero_assentos() {
        return numero_assentos;
    }

    public void setNumero_assentos(Integer numero_assentos) {
        this.numero_assentos = numero_assentos;
    }

}
