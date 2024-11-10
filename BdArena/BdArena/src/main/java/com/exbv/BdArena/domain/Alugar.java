package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter

public class Alugar {
    private int numero_quadra;
    private String pessoa_cpf;
    private LocalDate data;
    private LocalTime horario;
    private String itens;
    private float valor;
}