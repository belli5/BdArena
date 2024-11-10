package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Funcionario {
    private int cod_funcionario;
    private String cpf_funcionario;
    private String funcao;
    private float salario;
}
