package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Aula_Aluno_Turma_Professor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class Aula_Aluno_Turma_ProfessorRepositoryImp implements Aula_Aluno_Turma_ProfessorRepository {

    private final JdbcTemplate jdbcTemplate;
    public Aula_Aluno_Turma_ProfessorRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Aula_Aluno_Turma_Professor> todos() {
        return jdbcTemplate.query("SELECT * FROM aula_Aluno_Turma_Professor", (rs, rowNum) -> {
            Aula_Aluno_Turma_Professor aula = new Aula_Aluno_Turma_Professor();
            aula.setAluno_cpf(rs.getString("aluno_cpf"));
            aula.setProfessor_cpf(rs.getString("professor_cpf"));
            aula.setId_turma(rs.getInt("id_turma"));
            return aula;
        });
    }

    @Override
    public List<Aula_Aluno_Turma_Professor> turma (int id_turma){
        String sql = "SELECT * FROM aula_Aluno_Turma_Professor where id_turma = ?";
        return jdbcTemplate.query(sql, new Object[]{id_turma}, (rs, rowNum) -> {
            Aula_Aluno_Turma_Professor aula = new Aula_Aluno_Turma_Professor();
            aula.setId_turma(rs.getInt("id_turma"));
            aula.setAluno_cpf(rs.getString("aluno_cpf"));
            aula.setProfessor_cpf(rs.getString("professor_cpf"));
            return aula;
        });
    }

    @Override
    public int cadastrar(Aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor){
        return jdbcTemplate.update("INSERT INTO aula_Aluno_Turma_Professor (id_turma, aluno_cpf, professor_cpf) VALUES (?, ?, ?)",
                aula_Aluno_Turma_Professor.getId_turma(),
                aula_Aluno_Turma_Professor.getAluno_cpf(),
                aula_Aluno_Turma_Professor.getProfessor_cpf());
    }

    @Override
    public int excluir(String aluno_cpf, String professor_cpf, int id_turma){
        return jdbcTemplate.update("DELETE FROM aula_Aluno_Turma_Professor WHERE aluno_cpf = ?, professor_cpf = ?, id_turma = ?",
                aluno_cpf, professor_cpf, id_turma);
    }
}