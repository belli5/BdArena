package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Quadra {
    private int numero_quadra;
    private String modalidade_1;
    private String modalidade_2;
    private String modalidade_3;
}
