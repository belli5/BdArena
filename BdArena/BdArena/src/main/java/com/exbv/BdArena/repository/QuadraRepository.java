package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Quadra;
import java.util.List;

public interface QuadraRepository {
    Quadra achar_quadra (int numero_quadra);
    List<Quadra> listar_todas();
    List<Quadra> listar_modalidades();
}