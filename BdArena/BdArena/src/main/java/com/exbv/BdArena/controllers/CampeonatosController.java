package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.repository.CampeonatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Campeonatos")

public class CampeonatosController {

    @Autowired
    private CampeonatosRepository campeonatosRepository;

    @GetMapping
    public ResponseEntity<List<Campeonatos>> getTodos_campeonatos() {
        List<Campeonatos> Todos_campeonatos = campeonatosRepository.tudos_camp();
        return ResponseEntity.ok(Todos_campeonatos);
    }
}
