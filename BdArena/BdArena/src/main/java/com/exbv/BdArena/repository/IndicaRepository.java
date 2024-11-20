package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Indica;
import java.util.List;

public interface IndicaRepository {
    List<Indica> indicador (String cpf_indicador);
    List<Indica> todos ();
    int add_indicado(Indica indica);
    int excluir_indicacao(String cpf_indicador, String cpf_indicado);
}