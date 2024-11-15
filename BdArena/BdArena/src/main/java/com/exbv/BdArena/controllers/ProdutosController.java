package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Produtos;
import com.exbv.BdArena.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
