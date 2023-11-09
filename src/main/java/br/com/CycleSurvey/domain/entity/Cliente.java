package br.com.CycleSurvey.domain.entity;

import java.time.LocalDate;

public class Cliente {

    private Long id;

    private String nome;

    private LocalDate nascimento;

    private String cpf;

    private String celular;

    private String cep;

    private String cidade;

    private String logradouro;

    private String numero;

    private String estado;

    private String complemento;

    //public Cliente() {
    //}

    public Cliente(Long id, String nome, LocalDate nascimento, String cpf, String celular, String cep, String cidade, String logradouro, String numero, String estado, String complemento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.celular = celular;
        this.cep = cep;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.estado = estado;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public Cliente setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Cliente setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Cliente setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getCelular() {
        return celular;
    }

    public Cliente setCelular(String celular) {
        this.celular = celular;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public Cliente setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public Cliente setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Cliente setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Cliente setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Cliente setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public Cliente setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                ", cep='" + cep + '\'' +
                ", cidade='" + cidade + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", estado='" + estado + '\'' +
                ", complemento='" + complemento + '\'' +
                '}';
    }
}
