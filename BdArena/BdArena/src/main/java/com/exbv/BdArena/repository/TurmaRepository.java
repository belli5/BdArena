package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Turma;
import java.util.List;

public interface TurmaRepository {
    List<Turma> todas ();
    Turma id_turma(int id_turma);
    List<Turma> modalidade(String modalidade);
    List<Turma> dia_turma (String dia);
    int cadastrar(Turma turma);
    int excluir(int id_turma);
    int atualizar(Turma turma);
}