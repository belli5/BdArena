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

public class Inquilino {
    private String cnpj;
    private String nome;
    private LocalDate data_inicio_contrato;
    private LocalDate data_encerramento_contrato;
}
