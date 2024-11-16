package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Quadra;
import com.exbv.BdArena.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Quadra")
public class QuadraController {

    @Autowired
    private QuadraRepository quadraRepository;

    @GetMapping
    public ResponseEntity<List<Quadra>> gettodas_quadras() {
        List<Quadra> todas_quadras = quadraRepository.listar_todas();
        return ResponseEntity.ok(todas_quadras);
    }
}
