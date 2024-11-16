package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aula_Aluno_Turma_Professor;
import com.exbv.BdArena.repository.Aula_Aluno_Turma_ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/aula_Aluno_Turma_Professor")
public class Aula_Aluno_Turma_ProfessorController {

    @Autowired
    private Aula_Aluno_Turma_ProfessorRepository aula_Aluno_Turma_ProfessorRepository;

    @GetMapping
    public ResponseEntity<List<Aula_Aluno_Turma_Professor>> getTodos_aula_Aluno_Turma_Professor() {
        List<Aula_Aluno_Turma_Professor> Todos_aula_Aluno_Turma_Professor = aula_Aluno_Turma_ProfessorRepository.todos();
        return ResponseEntity.ok(Todos_aula_Aluno_Turma_Professor);
    }
}
