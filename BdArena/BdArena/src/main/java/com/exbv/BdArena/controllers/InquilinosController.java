package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Inquilino;
import com.exbv.BdArena.repository.InquilinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Inquilino")

public class InquilinosController {

    @Autowired
    private InquilinoRepository inquilinoRepository;

    @GetMapping
    public ResponseEntity<List<Inquilino>> getTodos_Inquilino() {
        List<Inquilino> Todos_Inquilino = inquilinoRepository.listar_todos();
        return ResponseEntity.ok(Todos_Inquilino);
    }
}
