package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Produtos;

public interface ProdutosRepository {
    Produtos Achar_Id(int id_produto);
    void Aciocioar(Produtos produtos);
    void deletar(int id_produtos);

}