package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Compra;

import java.time.LocalDate;
import java.util.List;

public interface CompraRepository {
    List<Compra> tudo();
    List<Compra> por_pessoa(String pessoa_cpf);
    List<Compra> por_produto (int id_produto);
    List<Compra> data (LocalDate data);
    int cadastrar(Compra compra);
    int excluir(int id_produto, int pessoa_cpf, LocalDate data);
}