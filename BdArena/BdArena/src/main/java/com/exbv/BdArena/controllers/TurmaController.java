package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Turma;
import com.exbv.BdArena.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
