package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Funcionario;
import com.exbv.BdArena.domain.Indica;
import com.exbv.BdArena.repository.IndicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Indica")
public class IndicaController {

    @Autowired
    private IndicaRepository indicaRepository;

    @GetMapping
    public ResponseEntity<List<Indica>> getTodo_indica() {
        List<Indica> Todo_indica = indicaRepository.todos();
        return ResponseEntity.ok(Todo_indica);
    }

    @PostMapping
    public ResponseEntity<String> add_indicado(@RequestBody Indica indica) {
        if (indica == null || indica.getCpf_indicado() == null || indica.getCpf_indicador() == null
                || indica.getDesconto_mensalidade() <= 0.0) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        indicaRepository.add_indicado(indica);
        return ResponseEntity.ok("indicação cadastrado com sucesso!");
    }
}
