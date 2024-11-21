package com.exbv.BdArena.repository;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class ObjetoStringInt {
    private String strinG;
    private int inT;

    public ObjetoStringInt(String strinG, int inT) {
        this.strinG = strinG;
        this.inT = inT;
    }
}