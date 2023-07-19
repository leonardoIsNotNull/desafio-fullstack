package com.leonardo.pereira.desafiofullstack.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "email")
    private String email;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", nullable = true, unique = true)
    private String cpf;

    @Column(name = "rg")
    private String rg;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToOne(mappedBy = "pessoaFisica")
    private Fornecedor fornecedor;
}
