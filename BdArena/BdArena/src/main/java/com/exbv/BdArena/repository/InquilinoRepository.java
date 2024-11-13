package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Inquilino;
import com.exbv.BdArena.domain.Patrocinadores;

import java.time.LocalDate;
import java.util.List;

public interface InquilinoRepository {
    List<Inquilino> cnpj ();
    List<Inquilino> data_fim(LocalDate data_fim);
    Inquilino inquilino_unica (String cnpj);
    int cadastrar(Inquilino inquilino);
    int excluir(String cpf);
    int atualizar();
}