package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Indica {
    private int matricula_indicador;
    private String cpf_indicador;
    private int matricula_indicado;
    private String cpf_indicado;
    private float desconto_mensalidade;
}
