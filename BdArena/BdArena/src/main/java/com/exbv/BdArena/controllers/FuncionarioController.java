package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Funcionario;
import com.exbv.BdArena.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
