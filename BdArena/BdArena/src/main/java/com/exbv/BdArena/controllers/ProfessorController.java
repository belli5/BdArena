package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Professor;
import com.exbv.BdArena.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessor() {
        List<Professor> AllProfessor = professorRepository.todos_prof();
        return ResponseEntity.ok(AllProfessor);
    }


}
