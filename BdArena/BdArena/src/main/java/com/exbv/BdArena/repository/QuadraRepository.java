package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Quadra;
import java.util.List;

public interface QuadraRepository {
    int add_quadra(Quadra quadra);
    int del_quadra(int numero_quadra);
    int att_quadra(int numero_quadra, Quadra quadra);
    Quadra buscar_por_numero (int numero_quadra);
    List<Quadra> listar_todas();
    List<Quadra> listar_quadras_por_modalidade(String modalidade);
    List<String> listar_modalidades();
}