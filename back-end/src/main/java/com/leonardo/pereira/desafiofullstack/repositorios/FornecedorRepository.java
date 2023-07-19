package com.leonardo.pereira.desafiofullstack.repositorios;

import com.leonardo.pereira.desafiofullstack.entidades.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
