package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Patrocinadores;

import java.util.List;


public interface PatrocinadoresRepository {
    List<Patrocinadores> listar_todos ();
    Patrocinadores patrocinador_unico (String cnpj);
    int add_patrocinadores(Patrocinadores patrocionadores);
    int del_patrocinadores(String cnpj);
    int att_patrocinadores(Patrocinadores patrocionadores);
}