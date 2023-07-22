package com.leonardo.pereira.desafiofullstack.controladoras;

import com.leonardo.pereira.desafiofullstack.entidades.Empresa;
import com.leonardo.pereira.desafiofullstack.sevicos.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    private final EmpresaService empresaService;

    @GetMapping()
    public ResponseEntity<List<Empresa>> buscarTodos() {
        try {
            return ResponseEntity.ok(empresaService.obterTodasEmpresas());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable("id") Long id) {
        Optional<Empresa> empresa = empresaService.obterPorId(id);
        return ResponseEntity.ok(empresa.get());
    }

    @PostMapping()
    public ResponseEntity<Empresa> criar(@RequestBody Empresa empresa) {
        try {
            return ResponseEntity.ok(empresaService.criarAtualizarEmpresa(empresa).orElseThrow());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity<Empresa> atualizar(@RequestBody Empresa empresaOriginal) {
        return ResponseEntity.ok(empresaService.criarAtualizarEmpresa(empresaOriginal).orElseThrow());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id) {
        empresaService.deletarEmpresa(id);
    }

}
