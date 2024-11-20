package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Estoque;

import java.util.List;

public interface EstoqueRepository {
    List<Estoque> todos();
    Estoque qtd_produto(int id_produto);
    int cadastrar(Estoque estoque);
    int excluir(int id_produto);
    int atualizar(int id_produto, Estoque estoque);
}