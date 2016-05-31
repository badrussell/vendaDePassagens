
package br.univates.entity;

public class Aviao {
    public static final String TABLE    = "avioes";
    public static final String PRIMARYKEY = "avioes.id";
    
    private Integer id;
    private double valor;
    private String modelo;
    private String descricao;
    private CompaniaAerea empresa;
    private Integer numeroAssentos;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CompaniaAerea getEmpresa() {
        return empresa;
    }

    public void setEmpresa(CompaniaAerea empresa) {
        this.empresa = empresa;
    }

    public Integer getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(Integer numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }
}
