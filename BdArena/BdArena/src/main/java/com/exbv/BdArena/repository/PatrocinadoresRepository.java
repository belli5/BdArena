package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Patrocinadores;
import com.exbv.BdArena.domain.Pessoa;

import java.util.List;
import java.time.LocalDate;

public interface PatrocinadoresRepository {
    List<Patrocinadores> listar_todos (String cnpj);
    Patrocinadores patrocinador_unico ();
    int add_patrocinadores(Patrocinadores patrocionadores);
    int del_patrocinadores(String cnpj);
    int att_patrocinadores(Patrocinadores patrocionadores);
}