package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
import com.exbv.BdArena.domain.Pessoa;

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

//    @PostMapping
//    public ResponseEntity<String> cadastrar(@RequestBody Aluno aluno) {
//        if (aluno == null || aluno.getCpf_aluno() == null) {
//            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
//        }
//        alunoRepository.cadastrar(aluno);
//        return ResponseEntity.ok("Aluno cadastrado com sucesso!");
//    }

    @DeleteMapping("/{cpf_aluno}")
    public ResponseEntity<String> excluir (@PathVariable String cpf_aluno) {
        int result = alunoRepository.excluir(cpf_aluno);
        // Verifica se nenhum registro foi excluído
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        // Se a exclusão for bem-sucedida
        return ResponseEntity.ok("Aluno excluído com sucesso.");
    }

    @GetMapping("/{cpf_aluno}")
    public ResponseEntity<?> buscarPorMatricula(@PathVariable String cpf_aluno) {
        // Busca o aluno pelo repositório
        Aluno aluno = alunoRepository.buscarPorCpf_aluno(cpf_aluno);

        // Verifica se o aluno foi encontrado
        if (aluno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
        // Retorna os dados do aluno como resposta
        return ResponseEntity.ok(aluno);
    }

    @PostMapping
    public  ResponseEntity<String> add_aluno_pessoa(@RequestBody Pessoa pessoa){
        if (pessoa == null || pessoa.getCpf() == null || pessoa.getNome() == null || pessoa.getRua() == null
        || pessoa.getCidade() == null || pessoa.getCep() == null || pessoa.getTelefone_1() == null || pessoa.getBairro() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        alunoRepository.cadastrar_pessoa_aluno(pessoa);
        return ResponseEntity.ok("Aluno e Pessoa cadastrados com sucesso!");
    }
}

