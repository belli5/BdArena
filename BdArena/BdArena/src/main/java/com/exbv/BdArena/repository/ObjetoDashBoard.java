package com.exbv.BdArena.repository;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.exbv.BdArena.repository.ObjetoStringInt;

@Getter
@Setter
public class ObjetoDashBoard {
    private int quantidadeDeAlunos;
    private int quantidadeDeCompras;
    private int quantidadeDeReservas;
    private List<ObjetoStringInt> pessoasPorCidadeDashBoard;
}
