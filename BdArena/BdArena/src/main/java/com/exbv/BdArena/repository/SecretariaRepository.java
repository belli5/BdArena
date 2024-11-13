package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Secretaria;
import java.util.List;
public interface SecretariaRepository {
    Secretaria cpf (int codigo_secretaria);
    List<Secretaria> todas();
    int cadastrar(Secretaria secretaria);
    int excluir(int codigo_secretaria);
    int atualizar(Secretaria secretaria);
}