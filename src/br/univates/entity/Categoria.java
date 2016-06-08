package br.univates.entity;

import br.univates.dao.Bd;
import static br.univates.entity.Aeroporto.PRIMARYKEY;
import static br.univates.entity.Aeroporto.TABLE;

public class Categoria {

    public static final String TABLE = "categorias";
    public static final String PRIMARYKEY = "id";

    private Integer id;
    private String descricao;
    private double taxa;
    
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
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Bd
    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

}
