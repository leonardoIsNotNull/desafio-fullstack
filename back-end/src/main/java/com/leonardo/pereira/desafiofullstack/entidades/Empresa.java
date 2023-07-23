package com.leonardo.pereira.desafiofullstack.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "empresa")
public class Empresa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cnpj", unique = true)
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "cep")
    private String cep;

    //... Mapeamento ManytoMany ...
    @ManyToMany(mappedBy = "empresas", cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("empresas")
    private List<Fornecedor> fornecedores = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(id, empresa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj);
    }
}
