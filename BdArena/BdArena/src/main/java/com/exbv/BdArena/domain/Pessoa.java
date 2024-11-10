package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Pessoa {
    private String cpf;
    private String nome;
    private String cidade;
    private String bairro;
    private String rua;
    private String cep;
    private String telefone_1;
    private String telefone_2;
}
