package br.univates.entity;

import br.univates.persistencia.Bd;
import static br.univates.entity.Cliente.PRIMARYKEY;
import static br.univates.entity.Cliente.TABLE;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class CompaniaAerea {

    public static final String TABLE = "companhias_aereas";
    public static final String PRIMARYKEY = "id";

    private Integer id;
    private String nome;

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
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
