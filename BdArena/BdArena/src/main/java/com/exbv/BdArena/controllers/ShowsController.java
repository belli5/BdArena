package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Shows;
import com.exbv.BdArena.repository.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
