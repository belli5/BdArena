package com.exbv.BdArena.controllers;

import lombok.Getter;
import lombok.Setter;
import com.exbv.BdArena.domain.Pessoa;

@Getter
@Setter
public class CadastrarFuncionario{
    private Pessoa pessoa;
    private String funcao;
    private float salario;
}