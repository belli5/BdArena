package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
import java.util.List;

public interface PessoaRepository {
    Pessoa cpf (String cpf);
    List<Pessoa> pessoa_comum();
    List<Pessoa> pessoa_ordemAlfa();
    int cadastrar(Pessoa pesssoa);
    int excluir(String cpf);
    int atualizar(Pessoa pesssoa);

}