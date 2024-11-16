package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Indica;
import com.exbv.BdArena.repository.IndicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Indica")
public class IndicaController {

    @Autowired
    private IndicaRepository indicaRepository;

    @GetMapping
    public ResponseEntity<List<Indica>> getTodo_indica() {
        List<Indica> Todo_indica = indicaRepository.todos();
        return ResponseEntity.ok(Todo_indica);
    }
}
