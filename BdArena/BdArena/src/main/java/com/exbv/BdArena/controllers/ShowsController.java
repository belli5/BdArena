package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Produtos;
import com.exbv.BdArena.domain.Shows;
import com.exbv.BdArena.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Shows")
public class ShowsController {

    @Autowired
    private ShowsRepository showsRepository;

    @GetMapping
    public ResponseEntity<List<Shows>> getTodos_shows() {
        List<Shows> todosShows = showsRepository.listar_todos();
        return ResponseEntity.ok(todosShows);
    }

    @PostMapping
    public ResponseEntity<String> add_shows(@RequestBody Shows shows) {
        if (shows == null || shows.getData() == null || shows.getArtista() == null
                || shows.getCache() == 0.0) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        showsRepository.add_shows(shows);
        return ResponseEntity.ok("Show cadastrado com sucesso!");
    }
}
