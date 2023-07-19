package com.leonardo.pereira.desafiofullstack.repositorios;

import com.leonardo.pereira.desafiofullstack.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
