package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.domain.Funcionario;
import com.exbv.BdArena.domain.Pessoa;
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
        if (funcionario == null || funcionario.getCpf_funcionario() == null || funcionario.getFuncao() == null
                || funcionario.getSalario() <0.0) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        funcionarioRepository.cadastrar(funcionario);
        return ResponseEntity.ok("Funcionario cadastrado com sucesso!");
    }

    @DeleteMapping("/{cpf_funcionario}")
    public ResponseEntity<String> excluir(@PathVariable String cpf_funcionario) {
        int funcionario = funcionarioRepository.excluir(cpf_funcionario);

        if (funcionario <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }

        return ResponseEntity.ok("Produto excluído com sucesso.");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar_pessoa_funcionario(@RequestBody CadastrarFuncionario request) {
            int resultado = funcionarioRepository.cadastrar_pessoa_funcionario(request.getPessoa(), request.getFuncao(), request.getSalario());
            if (resultado > 0) {
                return new ResponseEntity<>("Funcionário cadastrado com sucesso!", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Erro ao cadastrar funcionário.", HttpStatus.BAD_REQUEST);
            }
    }
}
