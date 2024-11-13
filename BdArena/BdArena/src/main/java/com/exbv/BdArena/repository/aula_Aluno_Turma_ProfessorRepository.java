package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.aula_Aluno_Turma_Professor;

import java.util.List;

public interface aula_Aluno_Turma_ProfessorRepository {
    aula_Aluno_Turma_Professor codigo (int aluno_matricula, int codigo_professor, int id_turma);
    List<aula_Aluno_Turma_Professor> tudo ();
    List<aula_Aluno_Turma_Professor> aluno (int aluno_matricula);
    List<aula_Aluno_Turma_Professor> professor (int codigo_professor);
    List<aula_Aluno_Turma_Professor> turma ( int id_turma);
    int cadastrar(aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor);
    int excluir(int aluno_matricula, int codigo_professor, int id_turma);
    int atualizar(aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor);
}