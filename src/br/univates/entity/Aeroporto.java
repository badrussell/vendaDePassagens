package br.univates.entity;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Aeroporto {

    public static final String TABLE = "aeroportos";
    public static final String PRIMARYKEY = "id";

    private Integer id;
    private String nome;
    private String sigla;

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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    
}
