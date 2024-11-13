package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
import com.exbv.BdArena.domain.Shows;
import java.util.List;

import java.time.LocalDate;

public interface ShowsRepository {
    List<Shows> todos_shows ();
    List<Shows> data (LocalDate data);
    int cadastrar(Shows shows);
    int excluir(LocalDate data_show, String artista);
    int atualizar(Shows shows);
}