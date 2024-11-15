package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.domain.Funcionario;
import com.exbv.BdArena.domain.Pessoa;

import java.util.List;

public interface FuncionarioRepository {
        Funcionario id_funcionario (int code_funcionario);
        List<Funcionario> funcao(String funcao_funcionario);
        List<Funcionario> todos_funcionarios();
        int cadastrar(Funcionario funcionario);
        int excluir(int code_funcionario);
        int atualizar(Funcionario funcionario);
}