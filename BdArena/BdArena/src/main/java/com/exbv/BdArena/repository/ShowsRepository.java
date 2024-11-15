package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Shows;
import java.util.List;

import java.time.LocalDate;

public interface ShowsRepository {
    List<Shows> listar_todos();
    List<Shows> buscar_por_data (LocalDate data);
    List<Shows> buscar_por_artista (String artista);
    int add_shows(Shows shows);
    int del_shows(LocalDate data_show, String artista);
}