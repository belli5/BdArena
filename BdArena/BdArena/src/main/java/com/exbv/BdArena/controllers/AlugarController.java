package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Alugar;
import com.exbv.BdArena.repository.AlugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Alugar")
public class AlugarController {

    @Autowired
    private AlugarRepository alugarRepository;

    @GetMapping
    public ResponseEntity<List<Alugar>> getTodos_alugueis() {
        List<Alugar> Todos_alugueis = alugarRepository.tudo();
        return ResponseEntity.ok(Todos_alugueis);
    }
}
