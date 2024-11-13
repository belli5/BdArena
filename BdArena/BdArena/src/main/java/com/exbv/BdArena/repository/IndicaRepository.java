package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Indica;
import java.util.List;

public interface IndicaRepository {
    List<Indica> indicador (int matricula_indicador);
    List<Indica> todos ();
}