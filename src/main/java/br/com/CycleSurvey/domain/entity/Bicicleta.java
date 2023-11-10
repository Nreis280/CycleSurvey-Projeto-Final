package br.com.CycleSurvey.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bicicleta {

    private Long id;

    private String marca;

    private String modelo;

    private int anoDeCompra;

    private double valor;

    private String nf;


}