package com.exbv.BdArena.controllers;

import com.exbv.BdArena.repository.DashboardRepository;
import com.exbv.BdArena.repository.ObjetoStringInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Dashboard")

public class DashboardController {
    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping
    public ResponseEntity<Integer> getReservasHoje(){
        int reservasHoje = dashboardRepository.reservasHoje();
        return ResponseEntity.ok(reservasHoje);
    }

    @GetMapping
    public ResponseEntity<Integer> getComprasHoje(){
        int comprasHoje = dashboardRepository.comprasHoje();
        return ResponseEntity.ok(comprasHoje);
    }

    @GetMapping
    public ResponseEntity<Integer> getTotalAlunos(){
        int totalAlunos = dashboardRepository.alunosCadastrados();
        return ResponseEntity.ok(totalAlunos);
    }

    @GetMapping
    public ResponseEntity<List<ObjetoStringInt>> getQuantidadePorCidade(){
        List<ObjetoStringInt> quantidadesPorCidade = dashboardRepository.graficoCidadePessoa();
        return ResponseEntity.ok(quantidadesPorCidade);
    }
}