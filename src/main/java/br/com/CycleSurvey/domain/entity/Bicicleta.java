package br.com.CycleSurvey.domain.entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bicicleta {
    private Long id;
    private String marca;

    private String modelo;

    private int anoDeCompra;

    private double valor;

    private String nf;
    private Set<Acessorio> acessorios = new LinkedHashSet<>();

    public Bicicleta() {
    }

    public Bicicleta(Long id, String marca, String modelo, int anoDeCompra, double valor, String nf, Set<Acessorio> acessorios) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeCompra = anoDeCompra;
        this.valor = valor;
        this.nf = nf;
        this.acessorios = acessorios;
    }

    public Long getId() {
        return id;
    }

    public Bicicleta setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMarca() {
        return marca;
    }

    public Bicicleta setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String getModelo() {
        return modelo;
    }

    public Bicicleta setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public int getAnoDeCompra() {
        return anoDeCompra;
    }

    public Bicicleta setAnoDeCompra(int anoDeCompra) {
        this.anoDeCompra = anoDeCompra;
        return this;
    }

    public double getValor() {
        return valor;
    }

    public Bicicleta setValor(double valor) {
        this.valor = valor;
        return this;
    }

    public String getNf() {
        return nf;
    }

    public Bicicleta setNf(String nf) {
        this.nf = nf;
        return this;
    }

    public Set<Acessorio> getAcessorios() {
        return acessorios;
    }

    public Bicicleta setAcessorios(Set<Acessorio> acessorios) {
        this.acessorios = acessorios;
        return this;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoDeCompra=" + anoDeCompra +
                ", valor=" + valor +
                ", nf='" + nf + '\'' +
                ", acessorios=" + acessorios +
                '}';
    }


}