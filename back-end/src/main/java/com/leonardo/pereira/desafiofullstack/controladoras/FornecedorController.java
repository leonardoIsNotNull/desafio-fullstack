package com.leonardo.pereira.desafiofullstack.controladoras;

import com.leonardo.pereira.desafiofullstack.entidades.Fornecedor;
import com.leonardo.pereira.desafiofullstack.sevicos.ForncedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController implements Serializable {

    private final ForncedorService forncedorService;

    // --- Criar obter todos
    // --- Criar obter com filtro (NOME, CPF/RG)

    @PostMapping
    public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor){
        try {
            return ResponseEntity.ok(forncedorService.criarAtualizarForncedor(fornecedor).orElseThrow());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Fornecedor> atualizarFornecedor(@RequestBody Fornecedor fornecedorOriginal){
        try {
            return ResponseEntity.ok(forncedorService.criarAtualizarForncedor(fornecedorOriginal).orElseThrow());
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id){
        forncedorService.deletarFornecedor(id);
    }

}
