package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Aluno")

public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> getTodos_alunos() {
        List<Aluno> todosAlunos = alunoRepository.todos_alunos();
        return ResponseEntity.ok(todosAlunos);
    }
}

