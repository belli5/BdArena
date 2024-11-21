package com.exbv.BdArena.repository;


import java.util.List;

public interface DashboardRepository {
    int reservasHoje();
    int alunosCadastrados();
    int comprasHoje();
    List<ObjetoStringInt> graficoCidadePessoa();
}