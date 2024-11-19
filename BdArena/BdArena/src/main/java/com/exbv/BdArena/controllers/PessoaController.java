package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Pessoa;
import com.exbv.BdArena.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/Pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getTodas_pessoa() {
        List<Pessoa> Todas_pessoas = pessoaRepository.listar_todos();
        return ResponseEntity.ok(Todas_pessoas);
    }

    @PostMapping
    public ResponseEntity<String> add_pessoa(@RequestBody Pessoa pessoa) {
        if (pessoa == null || pessoa.getCpf() == null || pessoa.getNome() == null || pessoa.getRua() == null
        || pessoa.getCidade() == null || pessoa.getCep() == null || pessoa.getTelefone_1() == null || pessoa.getBairro() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        pessoaRepository.add_pessoa(pessoa);
        return ResponseEntity.ok("Pessoa cadastrado com sucesso!");
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> del_pessoa(@PathVariable String cpf) {
        int result = pessoaRepository.del_pessoa(cpf);
        // Verifica se nenhum registro foi excluído
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pessoa não encontrado.");
        }
        // Se a exclusão for bem-sucedida
        return ResponseEntity.ok("pessoa excluído com sucesso.");
    }
}
