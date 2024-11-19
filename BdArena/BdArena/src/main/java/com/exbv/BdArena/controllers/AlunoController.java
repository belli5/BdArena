package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Aluno aluno) {
        if (aluno == null || aluno.getMatricula() == 0 || aluno.getCpf_aluno() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        alunoRepository.cadastrar(aluno);
        return ResponseEntity.ok("Aluno cadastrado com sucesso!");
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<String> excluir (@PathVariable int matricula) {
        int result = alunoRepository.excluir(matricula);
        // Verifica se nenhum registro foi excluído
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        // Se a exclusão for bem-sucedida
        return ResponseEntity.ok("Aluno excluído com sucesso.");
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<?> buscarPorMatricula(@PathVariable int matricula) {
        // Busca o aluno pelo repositório
        Aluno aluno = alunoRepository.buscarPorMatricula(matricula);

        // Verifica se o aluno foi encontrado
        if (aluno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
        // Retorna os dados do aluno como resposta
        return ResponseEntity.ok(aluno);
    }
}

