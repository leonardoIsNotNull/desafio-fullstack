package com.leonardo.pereira.desafiofullstack.controladoras;

import com.leonardo.pereira.desafiofullstack.entidades.Fornecedor;
import com.leonardo.pereira.desafiofullstack.sevicos.ForncedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/fornecedor")
public class FornecedorController implements Serializable {

    private final ForncedorService forncedorService;

    // --- Criar obter todos
    @GetMapping()
    public ResponseEntity<List<Fornecedor>> obterTodos(){
        try {
            return ResponseEntity.ok(forncedorService.obterTodosFornecedeores());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable("id") Long id) {
        Optional<Fornecedor> fornecedor = forncedorService.obterPorId(id);
        return fornecedor.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // --- Criar obter com filtro (NOME, CPF/RG)

    @PostMapping
    public ResponseEntity<Fornecedor> criar(@RequestBody Fornecedor fornecedor){
        try {
            return ResponseEntity.ok(forncedorService.criarAtualizarForncedor(fornecedor).orElseThrow());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<Fornecedor> atualizar(@RequestBody Fornecedor fornecedorOriginal){
        try {
            return ResponseEntity.ok(forncedorService.criarAtualizarForncedor(fornecedorOriginal).orElseThrow());
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        forncedorService.deletarFornecedor(id);
    }

}
