package com.leonardo.pereira.desafiofullstack.entidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDTO {

    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private SimpleDateFormat dataNascimento;

}
