package com.leonardo.pereira.desafiofullstack.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnpj",  nullable = true, unique = true)
    private String cnpj;

    @OneToOne(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisica;

    //... Mapeamento bidimensional ManytoMany ...
    @ManyToMany(mappedBy = "fornecedores")
    private List<Empresa> empresas = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}