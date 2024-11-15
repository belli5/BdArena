package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Produtos;

import java.util.List;

public interface ProdutosRepository {
    Produtos Achar_Id(int id_produto);
    List<Produtos> findAll();
    void Adicionar(Produtos produtos);
    void deletar(int id_produtos);

}