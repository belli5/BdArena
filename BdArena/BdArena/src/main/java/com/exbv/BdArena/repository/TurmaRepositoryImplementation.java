package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Turma;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TurmaRepositoryImplementation implements TurmaRepository{
    private final JdbcTemplate jdbcTemplate;
    public  TurmaRepositoryImplementation(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int add_turma(Turma turma) {
        return jdbcTemplate.update(
                "INSERT INTO Turma (modalidade, horario, dias) VALUES (?, ?, ?)",
                turma.getModalidade(),
                turma.getHorario(),
                turma.getDias()
        );
    }

    @Override
    public int att_turma(Turma turma){
        return jdbcTemplate.update(
                "UPDATE Turma SET modalidade = ?, horario = ?, dias = ? WHERE id_turma = ?",
                turma.getModalidade(),
                turma.getHorario(),
                turma.getDias(),
                turma.getId_turma()
        );
    }

    @Override
    public int del_turma(int id_turma) {
        return jdbcTemplate.update(
                "DELETE FROM Turma WHERE id_turma = ?",
                id_turma
        );
    }

    @Override
    public Turma busca_por_id(int id_turma) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Turma WHERE id_turma = ?",
                (rs, rowNum) -> {
                    Turma turma = new Turma();
                    turma.setId_turma(rs.getInt("id_turma"));
                    turma.setModalidade(rs.getString("modalidade"));
                    turma.setHorario(rs.getTime("horario").toLocalTime());
                    turma.setDias(rs.getString("dias"));
                    return turma;
                },
                id_turma // pass the parameter directly here
        );
    }

    @Override
    public List<Turma> listar_todas() {
        return jdbcTemplate.query("SELECT * FROM Turma", (rs, rowNum) -> {
            Turma turma = new Turma();
            turma.setId_turma(rs.getInt("id_turma"));
            turma.setModalidade(rs.getString("modalidade"));
            turma.setHorario(rs.getTime("horario").toLocalTime());
            turma.setDias(rs.getString("dias"));
            return turma;
        });
    }

    @Override
    public List<Turma> listar_por_modalidade(String modalidade) {
        return jdbcTemplate.query(
                "SELECT * FROM Turma WHERE modalidade = ?",
                (rs, rowNum) -> {
                    Turma turma = new Turma();
                    turma.setId_turma(rs.getInt("id_turma"));
                    turma.setModalidade(rs.getString("modalidade"));
                    turma.setHorario(rs.getTime("horario").toLocalTime());
                    turma.setDias(rs.getString("dias"));
                    return turma;
                },
                modalidade
        );
    }

    @Override
    public List<Turma> listar_por_dia (String dia) {
        return jdbcTemplate.query(
                "SELECT * FROM Turma WHERE dia LIKE '%?%'",
                (rs, rowNum) -> {
                    Turma turma = new Turma();
                    turma.setId_turma(rs.getInt("id_turma"));
                    turma.setModalidade(rs.getString("modalidade"));
                    turma.setHorario(rs.getTime("horario").toLocalTime());
                    turma.setDias(rs.getString("dias"));
                    return turma;
                },
                dia
        );
    }
}