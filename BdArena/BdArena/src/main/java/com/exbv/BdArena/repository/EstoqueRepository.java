package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Estoque;

import java.util.List;

public interface EstoqueRepository {
    List<Estoque> menor_que (int quantidade);
    List<Estoque> todos();
    int qtd_produto(int id_produto);
    List<Estoque> vazio ();
    int cadastrar(Estoque estoque);
    int excluir(int id_produto);
    int atualizar(Estoque estoque);
}