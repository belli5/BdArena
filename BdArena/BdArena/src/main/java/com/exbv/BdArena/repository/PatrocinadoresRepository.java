package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Patrocinadores;
import com.exbv.BdArena.domain.Pessoa;

import java.util.List;
import java.time.LocalDate;

public interface PatrocinadoresRepository {
    List<Patrocinadores> empresas (String cnpj);
    List<Patrocinadores> data_fim(LocalDate data_fim);
    Patrocinadores empresa_unica (String cnpj);
    int cadastrar(Patrocinadores patrocionadores);
    int excluir(String cnpj);
    int atualizar(Patrocinadores patrocionadores);
}