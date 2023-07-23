package com.leonardo.pereira.desafiofullstack.sevicos;

import com.leonardo.pereira.desafiofullstack.entidades.Empresa;
import com.leonardo.pereira.desafiofullstack.repositorios.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmpresaService implements Serializable {

    @Autowired
    private final EmpresaRepository empresaRepository;

    private final ForncedorService forncedorService;

    public List<Empresa> obterTodasEmpresas(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> obterPorId(Long id){
        return empresaRepository.findById(id);
    }

    public Optional<Empresa> criarAtualizarEmpresa(Empresa empresa){
        empresa.getFornecedores().forEach(fornecedor -> {
            fornecedor.getEmpresas().add(empresa);
            forncedorService.criarAtualizarForncedor(fornecedor);
        });
        return Optional.of(empresaRepository.save(empresa));
    }

    public void deletarEmpresa(Long id){
        if(empresaRepository.existsById(id)){
            empresaRepository.deleteById(id);
        }
    }

}
