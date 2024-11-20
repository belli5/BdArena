package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.domain.Funcionario;
import com.exbv.BdArena.domain.Pessoa;

import java.util.List;

public interface FuncionarioRepository {
        Funcionario id_funcionario (String cpf_funcionario);
        List<Funcionario> funcao(String funcao);
        List<Funcionario> todos_funcionarios();
        int cadastrar(Funcionario funcionario);
        int excluir(String cpf_funcionario);
        int atualizar(Funcionario funcionario);
        int cadastrar_pessoa_funcionario(Pessoa pessoa, String funcao, float salario);
}