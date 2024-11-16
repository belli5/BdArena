package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Pessoa;
import com.exbv.BdArena.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
