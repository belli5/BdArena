package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Turma {
    private int id_turma;
    private String modalidade;
    private LocalTime horario;
    private String dias;
}
