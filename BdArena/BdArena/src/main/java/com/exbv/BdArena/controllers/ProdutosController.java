package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Produtos;
import com.exbv.BdArena.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository produtosRepository;

    @GetMapping
    public ResponseEntity<List<Produtos>> getAllProdutos() {
        List<Produtos> todosProdutos = produtosRepository.findAll();
        return ResponseEntity.ok(todosProdutos);
    }

    @PostMapping
    public ResponseEntity<String> Adicionar(@RequestBody Produtos produtos) {
        if (produtos == null || produtos.getId_produto() == 0 || produtos.getTipo() == null || produtos.getNome() == null
        || produtos.getPreco() == 0.0) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        produtosRepository.Adicionar(produtos);
        return ResponseEntity.ok("produto cadastrado com sucesso!");
    }

    @DeleteMapping("/{id_produto}")
    public ResponseEntity<String> deletar(@PathVariable int id_produto) {
        int produtos = produtosRepository.deletar(id_produto);

        if (produtos < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        return ResponseEntity.ok("Produto excluído com sucesso.");
    }

    @GetMapping("/{id_produto}")
    public ResponseEntity<?> Achar_Id(@PathVariable int id_produto) {
        // Busca o aluno pelo repositório
        Produtos produtos = produtosRepository.Achar_Id(id_produto);

        // Verifica se o aluno foi encontrado
        if (produtos == null ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("produtos não encontrado!");
        }
        // Retorna os dados do aluno como resposta
        return ResponseEntity.ok(produtos);
    }
}
