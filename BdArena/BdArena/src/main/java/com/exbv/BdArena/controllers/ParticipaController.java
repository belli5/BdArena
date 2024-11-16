package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Participa;
import com.exbv.BdArena.repository.ParticipaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Participa")
public class ParticipaController {

    @Autowired
    private ParticipaRepository participaRepository;

    @GetMapping
    public ResponseEntity<List<Participa>> getTodas_participacoes() {
        List<Participa> Todas_participacoes = participaRepository.todos();
        return ResponseEntity.ok(Todas_participacoes);
    }
}
