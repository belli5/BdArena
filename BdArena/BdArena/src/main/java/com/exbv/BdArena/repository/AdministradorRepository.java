package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Administrador;
import com.exbv.BdArena.domain.Pessoa;

public interface AdministradorRepository {
   Administrador buscar_cpf (int cpf_adm);

}