package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Quadra;
import com.exbv.BdArena.domain.Shows;
import com.exbv.BdArena.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quadra")
public class QuadraController {

    @Autowired
    private QuadraRepository quadraRepository;

    @GetMapping
    public ResponseEntity<List<Quadra>> gettodas_quadras() {
        List<Quadra> todas_quadras = quadraRepository.listar_todas();
        return ResponseEntity.ok(todas_quadras);
    }

    @PostMapping
    public ResponseEntity<String> add_quadra(@RequestBody Quadra quadra) {
        if (quadra == null || quadra.getNumero_quadra() < 0 || quadra.getModalidade_1() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        quadraRepository.add_quadra(quadra);
        return ResponseEntity.ok("quadra cadastrado com sucesso!");
    }
}
