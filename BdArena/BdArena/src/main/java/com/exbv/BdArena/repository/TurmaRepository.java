package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Turma;
import java.util.List;

public interface TurmaRepository {
    List<Turma> listar_todas ();
    Turma busca_por_id(int id_turma);
    List<Turma> listar_por_modalidade(String modalidade);
    List<Turma> listar_por_dia (String dia);
    int add_turma(Turma turma);
    int del_turma(int id_turma);
    int att_turma(Turma turma);
}

