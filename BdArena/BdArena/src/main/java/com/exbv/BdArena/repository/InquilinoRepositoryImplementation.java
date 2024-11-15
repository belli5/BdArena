package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Inquilino;


import java.time.LocalDate;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InquilinoRepositoryImplementation implements InquilinoRepository{
    private final JdbcTemplate jdbcTemplate;
    public InquilinoRepositoryImplementation(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int add_inquilino(Inquilino inquilino) {
        return jdbcTemplate.update(
                "INSERT INTO Inquilino (cnpj, nome, data_inicio_contrato, data_encerramento_contrato) VALUES (?, ?, ?, ?)",
                inquilino.getCnpj(),
                inquilino.getNome(),
                inquilino.getData_inicio_contrato(),
                inquilino.getData_encerramento_contrato()
        );
    }

    @Override
    public int del_inquilino(String cnpj) {
        return jdbcTemplate.update(
                "DELETE FROM Inquilino WHERE cnpj = ?",
                cnpj
        );
    }

    @Override
    public int att_inquilino(Inquilino inquilino) {
        return jdbcTemplate.update(
                "UPDATE Inquilino SET nome = ?, data_inicio_contrato = ?, data_encerramento_contrato = ? WHERE cnpj = ?",
                inquilino.getNome(),
                inquilino.getData_inicio_contrato(),
                inquilino.getData_encerramento_contrato(),
                inquilino.getCnpj()
        );
    }

    @Override
    public List<Inquilino> listar_todos() {
        return jdbcTemplate.query(
                "SELECT * FROM Inquilino",
                (rs, rowNum) -> {
                    Inquilino inquilino = new Inquilino();
                    inquilino.setCnpj(rs.getString("cnpj"));
                    inquilino.setNome(rs.getString("nome"));
                    inquilino.setData_inicio_contrato(rs.getDate("data_inicio_contrato").toLocalDate());
                    inquilino.setData_encerramento_contrato(rs.getDate("data_encerramento_contrato").toLocalDate());
                    return inquilino;
                }
        );
    }

    @Override
    public Inquilino inquilino_unica(String cnpj) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Inquilino WHERE cnpj = ?",
                (rs, rowNum) -> {
                    Inquilino inquilino = new Inquilino();
                    inquilino.setCnpj(rs.getString("cnpj"));
                    inquilino.setNome(rs.getString("nome"));
                    inquilino.setData_inicio_contrato(rs.getDate("data_inicio_contrato").toLocalDate());
                    inquilino.setData_encerramento_contrato(rs.getDate("data_encerramento_contrato").toLocalDate());
                    return inquilino;
                },
                cnpj  // Pass the CNPJ to find the specific Inquilino
        );
    }
}