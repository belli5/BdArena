package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Campeonatos {
    private int id_campeonato;
    private String modalidade;
    private String categoria;
    private String genero;
    private LocalDate data_realizacao;
    private String premiacao;
    private String vencedor;
}
