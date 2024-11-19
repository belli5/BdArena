package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Shows;
import com.exbv.BdArena.domain.Turma;
import com.exbv.BdArena.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Turma")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @GetMapping
    public ResponseEntity<List<Turma>> gettodas_turmas() {
        List<Turma> gettodas_turmas = turmaRepository.listar_todas();
        return ResponseEntity.ok(gettodas_turmas);
    }

    @PostMapping
    public ResponseEntity<String> add_turma(Turma turma) {
        if (turma == null || turma.getId_turma() < 0 || turma.getModalidade() == null
                || turma.getHorario() == null || turma.getDias() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        turmaRepository.add_turma(turma);
        return ResponseEntity.ok("Turma cadastrada com sucesso!");
    }
}
