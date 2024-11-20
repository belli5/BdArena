package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Compra;
import com.exbv.BdArena.domain.Estoque;
import com.exbv.BdArena.domain.Pessoa;
import com.exbv.BdArena.domain.Produtos;
import com.exbv.BdArena.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/Estoque")

public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping
    public ResponseEntity<List<Estoque>> getTodos() {
        List<Estoque> Todos = estoqueRepository.todos();
        return ResponseEntity.ok(Todos);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Estoque estoque) {
        if (estoque == null || estoque.getId_produto() < 0
                || estoque.getQuantidade() < 0 ) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        estoqueRepository.cadastrar(estoque);
        return ResponseEntity.ok("compra adicionado com sucesso!");
    }

    @DeleteMapping("/{id_produto}")
    public ResponseEntity<String> excluir(@PathVariable int id_produto) {
        int result = estoqueRepository.excluir(id_produto);
        // Verifica se nenhum registro foi excluído
        if (result < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id_produto não encontrado.");
        }
        return ResponseEntity.ok("Produto excluído do Estoque com sucesso.");
    }

    @PutMapping("/{id_produto}")
    public ResponseEntity<String> atualizar(@PathVariable int id_produto, @RequestBody Estoque estoque) {
        int result = estoqueRepository.atualizar(id_produto, estoque);

        if (result == 0) { // Verifica se nenhum registro foi atualizado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id_produto não encontrado!");
        }

        return ResponseEntity.ok("Estoque atualizado com sucesso!");
    }

    @GetMapping("/{id_produto}")
    public ResponseEntity<?> qtd_produto(@PathVariable int id_produto) {
        // Busca a quantidade de produtos pelo repositório
        Estoque estoque = estoqueRepository.qtd_produto(id_produto);

        // Verifica se o produto não foi encontrado ou a quantidade é inválida
        if (estoque == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
        }

        // Retorna a quantidade de produtos como resposta
        return ResponseEntity.ok(estoque);
    }
}
