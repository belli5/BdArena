package com.exbv.BdArena.controllers;

import com.exbv.BdArena.repository.DashboardRepository;
import com.exbv.BdArena.repository.ObjetoDashBoard;
import com.exbv.BdArena.repository.ObjetoStringInt;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Dashboard")

public class DashboardController {
    @Autowired
    private DashboardRepository dashboardRepository;


    @GetMapping
    public ResponseEntity<ObjetoDashBoard> getDashBoard(){
        ObjetoDashBoard objetoDashBoard = dashboardRepository.infosDashBoard();
        return ResponseEntity.ok(objetoDashBoard);
    }
}