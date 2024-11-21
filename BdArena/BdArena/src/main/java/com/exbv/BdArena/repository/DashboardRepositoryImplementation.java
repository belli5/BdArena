package com.exbv.BdArena.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardRepositoryImplementation implements DashboardRepository{

    private final JdbcTemplate jdbcTemplate;
    public  DashboardRepositoryImplementation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int reservasHoje() {
        LocalDate dataAtual = LocalDate.now();
        String dataStr = dataAtual.toString();
        Integer resultado = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Alugar WHERE data = ?",
                Integer.class,
                dataStr);
        return (resultado != null) ? resultado : 0;
    }

    @Override
    public int alunosCadastrados(){
        Integer resultado = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Alunos",
                Integer.class);
        return (resultado != null) ? resultado : 0;
    }

    @Override
    public int comprasHoje(){
        LocalDate dataAtual = LocalDate.now();
        String dataStr = dataAtual.toString();
        Integer resultado = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Compra WHERE data = ?",
                Integer.class,
                dataStr);
        return (resultado != null) ? resultado : 0;
    }

    @Override
    public List<ObjetoStringInt> graficoCidadePessoa(){
        return jdbcTemplate.query(
                "SELECT cidade, COUNT(*) AS quantidade FROM Pessoa GROUP BY cidade",(rs, rowNum) ->
                        new ObjetoStringInt(
                                rs.getString("strinG"),
                                rs.getInt("inT")
                        )
        );
    }

}