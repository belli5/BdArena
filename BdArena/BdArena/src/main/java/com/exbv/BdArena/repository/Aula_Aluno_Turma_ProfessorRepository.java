package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Aula_Aluno_Turma_Professor;

import java.util.List;

public interface Aula_Aluno_Turma_ProfessorRepository {
    Aula_Aluno_Turma_Professor codigo (int aluno_matricula, int codigo_professor, int id_turma);
    List<Aula_Aluno_Turma_Professor> todos ();
    List<Aula_Aluno_Turma_Professor> aluno (int aluno_matricula);
    List<Aula_Aluno_Turma_Professor> professor (int codigo_professor);
    List<Aula_Aluno_Turma_Professor> turma (int id_turma);
    int cadastrar(Aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor);
    int excluir(int aluno_matricula, int codigo_professor, int id_turma);
    int atualizar(Aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor);
}