package br.univates.entity;

import br.univates.dao.Bd;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Aeroporto {

    public static final String TABLE = "aeroportos";
    public static final String PRIMARYKEY = "id";

    private int id;
    private String nome;
    private String sigla;
    
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

    public void setId(Integer id) {
        this.id = id;
    }

    @Bd
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Bd
    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
}
