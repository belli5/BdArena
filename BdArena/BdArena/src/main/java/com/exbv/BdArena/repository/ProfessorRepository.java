package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Professor;
import java.util.List;

public interface ProfessorRepository {
    Professor codigo (int codigo_professor);
    List<Professor> todos_prof();
    List<Professor> modalidade (String modalidade);
    int cadastrar(Professor professor);
    int excluir(int codigo_professor);
    int atualizar(Professor professor);
}