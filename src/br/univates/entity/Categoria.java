
package br.univates.entity;

public class Categoria {
    public static final String TABLE    = "categorias";
    public static final String PRIMARYKEY = "categorias.id";
    
    private Integer id;
    private String descricao;
    private double taxa;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
    
    
}
