package br.com.CycleSurvey.domain.entity;

public class Acessorio {

    private Long id;
    private String marca;

    private String modelo;

    private double valor;

    private String tipo;

    private String nf;

    public Acessorio() {
    }

    public Acessorio(Long id, String marca, String modelo, double valor, String tipo, String nf) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.tipo = tipo;
        this.nf = nf;
    }

    public Long getId() {
        return id;
    }

    public Acessorio setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public Acessorio setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Acessorio setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public double getValor() {
        return valor;
    }

    public Acessorio setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Acessorio setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getNf() {
        return nf;
    }

    public Acessorio setNf(String nf) {
        this.nf = nf;
        return this;
    }

    @Override
    public String toString() {
        return "Acessorio{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", valor=" + valor +
                ", tipo='" + tipo + '\'' +
                ", nf='" + nf + '\'' +
                '}';
    }
}
