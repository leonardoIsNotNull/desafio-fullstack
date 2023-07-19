package com.leonardo.pereira.desafiofullstack.sevicos;

import com.leonardo.pereira.desafiofullstack.entidades.Empresa;
import com.leonardo.pereira.desafiofullstack.repositorios.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public List<Empresa> obterTodasEmpresas(){
        return empresaRepository.findAll();
    }

    public Optional<Empresa> obterPorId(Long id){
        return empresaRepository.findById(id);
    }

    public Optional<Empresa> criarAtualizarEmpresa(Empresa empresa){
        return Optional.of(empresaRepository.save(empresa));
    }

    public void deletarEmpresa(Long id){
        if(empresaRepository.existsById(id)){
            empresaRepository.deleteById(id);
        }
    }

}
