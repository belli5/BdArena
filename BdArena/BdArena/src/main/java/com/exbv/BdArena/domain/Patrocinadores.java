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

public class Patrocinadores{
    private String cnpj;
    private String nome;
    private LocalDate inicio_contrato;
    private LocalDate fim_contrato;
}
