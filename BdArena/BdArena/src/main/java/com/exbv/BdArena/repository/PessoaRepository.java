package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
import java.util.List;

public interface PessoaRepository {
    Pessoa buscar_por_cpf (String cpf);
    List<Pessoa> listar_todos();
    List<Pessoa> listar_ordem_alfabetica();
    int add_pessoa(Pessoa pesssoa);
    int del_pessoa(String cpf);
    int att_pessoa(String cpf, Pessoa pesssoa);

}