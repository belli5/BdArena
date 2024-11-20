package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Aula_Aluno_Turma_Professor;

import java.util.List;

public interface Aula_Aluno_Turma_ProfessorRepository {
    List<Aula_Aluno_Turma_Professor> todos ();
    List<Aula_Aluno_Turma_Professor> turma (int id_turma);
    int cadastrar(Aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor);
    int excluir(String aluno_cpf, String professor_cpf, int id_turma);
}