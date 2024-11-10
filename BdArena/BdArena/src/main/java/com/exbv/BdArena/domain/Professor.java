package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Professor {
    private int codigo_professor;
    private String cpf_professor;
    private String especialidade_1;
    private String especialidade_2;
    private String especialidade_3;
}
