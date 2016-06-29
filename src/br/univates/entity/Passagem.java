package br.univates.entity;

import br.univates.persistencia.Bd;
import static br.univates.entity.CompaniaAerea.PRIMARYKEY;
import static br.univates.entity.CompaniaAerea.TABLE;
import java.util.Calendar;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Passagem {

    public static final String TABLE = "passagens";
    public static final String PRIMARYKEY = "id";

    private Integer id;
    private double valor;
    private Integer voo_id;
    private Integer categorias_id;
    private Calendar validade;

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

    public Passagem setId(Integer id) {
        this.id = id;
        return this;
    }

    @Bd
    public double getValor() {
        return valor;
    }

    public Passagem setValor(double valor) {
        this.valor = valor;
        return this;
    }

    @Bd
    public Integer getVoo_id() {
        return voo_id;
    }

    public Passagem setVoo_id(Integer voo_id) {
        this.voo_id = voo_id;
        return this;
    }

    @Bd
    public Integer getCategorias_id() {
        return categorias_id;
    }

    public Passagem setCategorias_id(Integer categorias_id) {
        this.categorias_id = categorias_id;
        return this;
    }

    @Bd
    public Calendar getValidade() {
        return validade;
    }

    public Passagem setValidade(Calendar validade) {
        this.validade = validade;
        return this;
    }

}
