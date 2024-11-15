package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Inquilino;
import com.exbv.BdArena.domain.Patrocinadores;

import java.time.LocalDate;
import java.util.List;

public interface InquilinoRepository {
    List<Inquilino> listar_todos();
    Inquilino inquilino_unica (String cnpj);
    int add_inquilino(Inquilino inquilino);
    int del_inquilino(String cpf);
    int att_inquilino(Inquilino inquilino);
}