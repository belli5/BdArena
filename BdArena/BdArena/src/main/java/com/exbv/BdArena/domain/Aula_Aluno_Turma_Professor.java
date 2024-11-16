package com.exbv.BdArena.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Aula_Aluno_Turma_Professor {
    private int aluno_matricula;
    private String aluno_cpf;
    private int id_turma;
    private int professor_codigo;
    private String professor_cpf;
}
