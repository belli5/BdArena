package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {
    private int id_produto;
    private int quantidade;

    // Constructor that takes a Produtos object to initialize id_produto
    public Estoque(Produtos produto, int quantidade) {
        this.id_produto = produto.getId_produto();  // Extracting id_produto from Produtos
        this.quantidade = quantidade;
    }
}
