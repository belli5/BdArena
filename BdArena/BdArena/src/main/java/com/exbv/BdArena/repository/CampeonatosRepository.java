package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Campeonatos;
import java.util.List;

public interface CampeonatosRepository {
    Campeonatos achar_camp (int id_campeonato);
    List<Campeonatos> tudos_camp ();
    List<Campeonatos> categoria ();
    List<Campeonatos> genero ();
    int add_campeonato(Campeonatos campeonatos);
    int excluir_campeonat(int id_campeonato);
    int alterar_camp(Campeonatos campeonatos);
}