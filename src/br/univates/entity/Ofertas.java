package br.univates.entity;


public class Ofertas
{
    private String nome = "";
    private Float valor = 0.0f;
    private String data = "";

    public Ofertas(String n, Float v, String d) {
        this.nome = n;
        this.valor = v;
        this.data = d;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}