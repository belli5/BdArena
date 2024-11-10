package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter

public class Compra {
    private String cpf_comprador;
    private int id_produto;
    private LocalDate data;
}
