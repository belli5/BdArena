package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Pessoa;

import java.util.List;

public interface AlunoRepository {
    Aluno matricula (int matricula);
    List<Aluno> todos_alunos();
    int cadastrar(Aluno aluno);
    int excluir(int matricula);
}