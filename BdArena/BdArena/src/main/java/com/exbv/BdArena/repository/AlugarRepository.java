package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Alugar;

import java.time.LocalDate;
import java.util.List;

public interface AlugarRepository {
    Alugar alugar_1 (int numero_quadra, String pessoa_cpf);
    List<Alugar> tudo();
    List<Alugar> numero(int numero_quadra);
    List<Alugar> pessoa(String pessoa_cpf);
    List<Alugar> data(LocalDate data);
    int cadastrar(Alugar alugar);
    int excluir(int numero_quadra, String pessoa_cpf);
    int atualizar(Alugar alugar);
}