package br.univates.entity;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class CompaniaAerea {

    public static final String TABLE = "companhias_aereas";
    public static final String PRIMARYKEY = "id";

    private Integer id;
    private String nome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
