package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Quadra;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuadraRepositoryImplementation implements QuadraRepository{
    private final JdbcTemplate jdbcTemplate;
    public QuadraRepositoryImplementation(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int add_quadra(Quadra quadra){
        return jdbcTemplate.update(
                "INSERT INTO Quadra (numero_quadra, modalidade_1, modalidade_2, modalidade_3) VALUES (?, ?, ?, ?)",
                quadra.getNumero_quadra(),
                quadra.getModalidade_1(),
                quadra.getModalidade_2(),
                quadra.getModalidade_3()
        );
    }

    @Override
    public int del_quadra(int numero_quadra){
        return jdbcTemplate.update(
                "DELETE FROM Quadra WHERE numero_quadra = ?",
                numero_quadra
        );
    }

    @Override
    public int att_quadra(Quadra quadra){
        return jdbcTemplate.update(
                "UPDATE Quadra SET modalidade_1 = ?, modalidade_2 = ?, modalidade_3 = ? WHERE numero_quadra = ?",
                quadra.getModalidade_1(),
                quadra.getModalidade_2(),
                quadra.getModalidade_3(),
                quadra.getNumero_quadra()
        );
    }

    @Override
    public Quadra buscar_por_numero(int numero_quadra){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Quadra WHERE numero_quadra = ?",
                (rs, rowNum) -> {
                    Quadra quadra = new Quadra();
                    quadra.setNumero_quadra(rs.getInt("numero_quadra"));
                    quadra.setModalidade_1(rs.getString("modalidade_1"));
                    quadra.setModalidade_2(rs.getString("modalidade_2"));
                    quadra.setModalidade_3(rs.getString("modalidade_3"));
                    return quadra;
                },
                numero_quadra
        );
    }

    @Override
    public List<Quadra> listar_todas(){
        return jdbcTemplate.query("SELECT * FROM Quadra", (rs, rowNum) -> {
            Quadra quadra = new Quadra();
            quadra.setNumero_quadra(rs.getInt("numero_quadra"));
            quadra.setModalidade_1(rs.getString("modalidade_1"));
            quadra.setModalidade_2(rs.getString("modalidade_2"));
            quadra.setModalidade_3(rs.getString("modalidade_3"));
            return quadra;
        });
    }

    @Override
    public List<Quadra> listar_quadras_por_modalidade(String modalidade){
        return jdbcTemplate.query(
                "SELECT * FROM Quadra WHERE modalidade_1 = ? OR modalidade_2 = ? OR modalidade_3 = ?",
                new Object[] {modalidade, modalidade, modalidade},
                (rs, rowNum) -> {
                    Quadra quadra = new Quadra();
                    quadra.setNumero_quadra(rs.getInt("numero_quadra"));
                    quadra.setModalidade_1(rs.getString("modalidade_1"));
                    quadra.setModalidade_2(rs.getString("modalidade_2"));
                    quadra.setModalidade_3(rs.getString("modalidade_3"));
                    return quadra;
                }

        );
    }

    @Override
    public List<String> listar_modalidades(){
        return jdbcTemplate.query(
                "SELECT DISTINCT modalidade_1 AS modalidade FROM Quadra " +
                        "UNION SELECT DISTINCT modalidade_2 FROM Quadra " +
                        "UNION SELECT DISTINCT modalidade_3 FROM Quadra",
                (rs, rowNum) -> rs.getString("modalidade")
        );
    }
}
