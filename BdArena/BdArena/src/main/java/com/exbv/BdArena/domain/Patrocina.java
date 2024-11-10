package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Patrocina {
    private String cnpj_patrocinador;
    private int id_campeonato;
    private float valor_patrocinio;
}
