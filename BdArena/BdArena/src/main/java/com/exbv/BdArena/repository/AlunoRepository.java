package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Pessoa;

import java.util.List;

public interface AlunoRepository {
    Aluno buscarPorCpf_aluno (String cpf_aluno);
    List<Aluno> todos_alunos();
    int cadastrar(Aluno aluno);
    int excluir(String cpf_aluno);
    int cadastrar_pessoa_aluno(Pessoa pessoa);
}