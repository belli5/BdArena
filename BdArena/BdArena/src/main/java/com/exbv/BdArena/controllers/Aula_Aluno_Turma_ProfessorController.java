package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Aula_Aluno_Turma_Professor;
import com.exbv.BdArena.repository.Aula_Aluno_Turma_ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor) {
        if (aula_Aluno_Turma_Professor == null || aula_Aluno_Turma_Professor.getAluno_matricula() < 0
                || aula_Aluno_Turma_Professor.getProfessor_cpf() == null || aula_Aluno_Turma_Professor.getId_turma() <0
            || aula_Aluno_Turma_Professor.getAluno_cpf() == null || aula_Aluno_Turma_Professor.getProfessor_codigo() <=0) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        aula_Aluno_Turma_ProfessorRepository.cadastrar(aula_Aluno_Turma_Professor);
        return ResponseEntity.ok("Aluno cadastrado na turma com sucesso!");
    }
}
