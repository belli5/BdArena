package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Compra;
import com.exbv.BdArena.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/Compra")

public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @GetMapping
    public ResponseEntity<List<Compra>> getTodos_produtos() {
        List<Compra> Todos_produtos = compraRepository.tudo();
        return ResponseEntity.ok(Todos_produtos);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Compra compra) {
        if (compra == null || compra.getId_produto() < 0
                || compra.getCpf_comprador() == null || compra.getData() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        compraRepository.cadastrar(compra);
        return ResponseEntity.ok("compra adicionado com sucesso!");
    }

    @GetMapping("/{cpf_comprador}")
    public ResponseEntity<?> por_pessoa(@PathVariable String cpf_comprador) {
        List<Compra> compras = compraRepository.por_pessoa(cpf_comprador);

        if (compras == null || compras.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma compra encontrada para o CPF fornecido!");
        }
        return ResponseEntity.ok(compras);
    }

    @DeleteMapping("/{id_compra}")
    public ResponseEntity<String> excluir(@PathVariable int id_compra) {
        int result = compraRepository.excluir(id_compra);
        // Verifica se nenhum registro foi excluído
        if (result < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("compra não encontrado.");
        }
        // Se a exclusão for bem-sucedida
        return ResponseEntity.ok("compra excluído com sucesso.");
    }
}
