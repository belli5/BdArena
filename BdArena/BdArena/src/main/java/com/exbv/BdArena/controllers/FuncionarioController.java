package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.domain.Funcionario;
import com.exbv.BdArena.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> getTodos_funcionario() {
        List<Funcionario> Todos_funcionario = funcionarioRepository.todos_funcionarios();
        return ResponseEntity.ok(Todos_funcionario);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Funcionario funcionario) {
        if (funcionario == null || funcionario.getCod_funcionario() < 0
                || funcionario.getCpf_funcionario() == null || funcionario.getFuncao() == null
                || funcionario.getSalario() <0.0) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        funcionarioRepository.cadastrar(funcionario);
        return ResponseEntity.ok("Funcionario cadastrado com sucesso!");
    }

    @DeleteMapping("/{code_funcionario}")
    public ResponseEntity<String> excluir(@PathVariable int code_funcionario) {
        int funcionario = funcionarioRepository.excluir(code_funcionario);

        if (funcionario < 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        return ResponseEntity.ok("Produto excluído com sucesso.");
    }
}
