package br.univates.entity;

import br.univates.persistencia.Bd;
import static br.univates.entity.CompaniaAerea.PRIMARYKEY;
import static br.univates.entity.CompaniaAerea.TABLE;
import java.util.Calendar;

/**
 *
 * @author Filipe, Carlos, Vitor e Matheus
 */
public class Passagem{

    public static final String TABLE = "passagens";
    public static final String PRIMARYKEY = "id";

    private int id;
    private int voo_id;
    private String validade;
    private int categorias_id;
    private double valor;
    private int poltronas;
    private int cliente_id; 

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
    public int getVoo_id() {
        return voo_id;
    }

    @Bd
    public String getValidade() {
        return validade;
    }

    @Bd
    public int getCategorias_id() {
        return categorias_id;
    }

    @Bd
    public double getValor() {
        return valor;
    }

    @Bd
    public int getPoltronas() {
        return poltronas;
    }

    @Bd
    public int getCliente_id() {
        return cliente_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVoo_id(int voo_id) {
        this.voo_id = voo_id;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public void setCategorias_id(int categorias_id) {
        this.categorias_id = categorias_id;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPoltronas(int poltronas) {
        this.poltronas = poltronas;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

}
