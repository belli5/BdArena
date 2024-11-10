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

public class Shows {
    private LocalDate data;
    private String artista;
    private String festa;
    private float cache;
}
