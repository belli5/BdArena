package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Secretaria;
import java.util.List;
public interface SecretariaRepository {
    List<Secretaria> todas();
    int cadastrar(Secretaria secretaria);
    int excluir(int codigo_secretaria);
}