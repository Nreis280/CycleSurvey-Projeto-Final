package br.com.CycleSurvey.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private Bicicleta bicicleta;


}
