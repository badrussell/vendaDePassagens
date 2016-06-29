package br.univates.entity;

import br.univates.persistencia.Bd;
import static br.univates.entity.Categoria.PRIMARYKEY;
import static br.univates.entity.Categoria.TABLE;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Cliente {

    public static final String TABLE = "clientes";
    public static final String PRIMARYKEY = "id";

    private int id;
    private String nome;
    private int idade;
    private char sexo;
    private String usuario;
    private String senha;

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
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Bd
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Bd
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Bd
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Bd
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
