package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
import com.exbv.BdArena.domain.Professor;
import java.util.List;

public interface ProfessorRepository {
    List<Professor> todos_prof();
    List<Professor> modalidade (String especialidade_1, String especialidade_2, String especialidade_3);
    int cadastrar(Professor professor);
    int excluir(String cpf_professor);
    int atualizar(Professor professor);
//    int cadastrar_pessoa_funcionario_professor(Pessoa pessoa, String funcao, float salario, String modalidade_1);
}