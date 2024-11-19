package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Alugar;
import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.repository.AlugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Alugar")
public class AlugarController {

    @Autowired
    private AlugarRepository alugarRepository;

    @GetMapping
    public ResponseEntity<List<Alugar>> getTodos_alugueis() {
        List<Alugar> Todos_alugueis = alugarRepository.tudo();
        return ResponseEntity.ok(Todos_alugueis);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Alugar alugar) {
        if (alugar == null || alugar.getNumero_quadra() < 0 || alugar.getPessoa_cpf() == null ||
        alugar.getValor() == 0.0 || alugar.getData() == null || alugar.getHorario() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        alugarRepository.cadastrar(alugar);
        return ResponseEntity.ok("Aluguel feito com sucesso!");
    }
}
