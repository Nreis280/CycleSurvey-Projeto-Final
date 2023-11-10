package br.com.CycleSurvey.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Acessorio {

    private Long id;

    private String marca;

    private String modelo;

    private double valor;

    private String tipo;

    private String nf;

    private Bicicleta bicicleta;

}
