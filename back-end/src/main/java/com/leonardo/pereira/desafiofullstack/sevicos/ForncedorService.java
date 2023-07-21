package com.leonardo.pereira.desafiofullstack.sevicos;

import com.leonardo.pereira.desafiofullstack.entidades.Fornecedor;
import com.leonardo.pereira.desafiofullstack.repositorios.FornecedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ForncedorService implements Serializable {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> obterTodosFornecedeores() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> obterPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Optional<Fornecedor> criarAtualizarForncedor(Fornecedor fornecedor) {
        return Optional.of(fornecedorRepository.save(fornecedor));
    }

    public void deletarFornecedor(Long id) {
        if (fornecedorRepository.existsById(id)){
            fornecedorRepository.deleteById(id);
        }
    }

}
