package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Participa;
import java.util.List;

public interface ParticipaRepository {
    List<Participa> participantes (String cpf_participante);
    List<Participa> todos();
    List<Participa> por_camp(int id_campeonato);
    Participa participa(String cpf_particpante, int id_campeonato);
    int cadastrar(Participa participa);
    int excluir(String cpf_participante);
    int atualizar(Participa participa);
}