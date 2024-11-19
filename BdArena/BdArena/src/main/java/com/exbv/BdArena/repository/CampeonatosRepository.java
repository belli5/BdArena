package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Campeonatos;
import java.util.List;

public interface CampeonatosRepository {
    Campeonatos achar_camp (int id_campeonato);
    List<Campeonatos> todos_camp ();
    List<Campeonatos> categoria (String categoria);
    List<Campeonatos> genero (String genero);
    int add_campeonato(Campeonatos campeonatos);
    int excluir_campeonato(int id_campeonato);
    int alterar_camp(Campeonatos campeonatos);
}