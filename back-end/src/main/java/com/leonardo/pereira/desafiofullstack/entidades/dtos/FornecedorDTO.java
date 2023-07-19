package com.leonardo.pereira.desafiofullstack.entidades.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorDTO implements Serializable {

    private Long id;
    private String cnpj;
    private String cep;
    private List<EmpresaDTO> empresas;
    private PessoaFisicaDTO pessoaFisicaDTO;

}
