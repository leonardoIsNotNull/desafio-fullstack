package com.leonardo.pereira.desafiofullstack.controladoras;

import com.leonardo.pereira.desafiofullstack.entidades.Empresa;
import com.leonardo.pereira.desafiofullstack.sevicos.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final Logger logger = LoggerFactory.getLogger(EmpresaController.class);

    @GetMapping("/empresa")
    public ResponseEntity<List<Empresa>> buscarTodasEmpresas() {
        try {
            return ResponseEntity.ok(empresaService.obterTodasEmpresas());
        } catch (Exception e) {
            logger.error("Erro de requisição: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<Empresa> buscarEmpresaPorId(@PathVariable("id") Long id) {
        Optional<Empresa> empresa = empresaService.obterPorId(id);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/empresa")
    public ResponseEntity<Empresa> criarEmpresa(@RequestBody Empresa empresa) {
        try {
            return ResponseEntity.ok(empresaService.criarAtualizarEmpresa(empresa).orElseThrow());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/empresa")
    public ResponseEntity<Empresa> atualizarEmpresa(@RequestBody Empresa empresaOriginal) {
        return ResponseEntity.ok(empresaService.criarAtualizarEmpresa(empresaOriginal).orElseThrow());
    }

    @DeleteMapping("/emrpesa/{id}")
    public void deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
    }

}
