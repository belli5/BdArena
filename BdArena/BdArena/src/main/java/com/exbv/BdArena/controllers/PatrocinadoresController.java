package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Patrocinadores;
import com.exbv.BdArena.repository.PatrocinadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/Patrocinadores")
public class PatrocinadoresController {

    @Autowired
    private PatrocinadoresRepository patrocinadoresRepository;

    @GetMapping
    public ResponseEntity<List<Patrocinadores>> getTodos_Patrocinadores() {
        List<Patrocinadores> Todos_Patrocinadores = patrocinadoresRepository.listar_todos();
        return ResponseEntity.ok(Todos_Patrocinadores);
    }
}
