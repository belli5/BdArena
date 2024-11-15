package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Patrocina;
import com.exbv.BdArena.domain.Patrocinadores;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public class PatrocinadoresRepositoryImplementation implements PatrocinadoresRepository{
    private final JdbcTemplate jdbcTemplate;
    public  PatrocinadoresRepositoryImplementation(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int add_patrocinadores(Patrocinadores patrocionadores){
        return jdbcTemplate.update(
                "INSERT INTO Patrocinadores (cnpj, nome, inicio_contrato, fim_contrato) VALUES (?, ?, ?, ?)",
                patrocionadores.getCnpj(),
                patrocionadores.getNome(),
                patrocionadores.getInicio_contrato(),
                patrocionadores.getFim_contrato()
        );
    }

    @Override
    public int del_patrocinadores(String cnpj){
        return jdbcTemplate.update(
                "DELETE FROM Patrocinadores WHERE cnpj = ?",
                cnpj
        );
    }

    @Override
    public int att_patrocinadores(Patrocinadores patrocionadores){
        return jdbcTemplate.update(
                "UPDATE Patrocinadores SET nome = ?, inicio_contrato = ?, fim_contrato = ? WHERE cnpj = ?",
                patrocionadores.getNome(),
                patrocionadores.getInicio_contrato(),
                patrocionadores.getFim_contrato(),
                patrocionadores.getCnpj()
        );
    }

    @Override
    public List<Patrocinadores> listar_todos() {
        return jdbcTemplate.query("SELECT * FROM Patrocinadores", (rs, rowNum) -> {
            Patrocinadores patrocinadores = new Patrocinadores();
            patrocinadores.setCnpj(rs.getString("cnpj"));
            patrocinadores.setNome(rs.getString("nome"));
            patrocinadores.setInicio_contrato(rs.getDate("inicio_contrato").toLocalDate());
            patrocinadores.setFim_contrato(rs.getDate("fim_contrato").toLocalDate());
            return patrocinadores;
        });
    }


    @Override
    public Patrocinadores patrocinador_unico (String cnpj){
        return jdbcTemplate.queryForObject("SELECT * FROM Patrocinadores WHERE cnpj = ?", (rs, rowNum) ->{
            Patrocinadores patrocinadores = new Patrocinadores();
            patrocinadores.setCnpj(rs.getString("cnpj"));
            patrocinadores.setNome(rs.getString("nome"));
            patrocinadores.setInicio_contrato(rs.getDate("inicio_contrato").toLocalDate());
            patrocinadores.setFim_contrato(rs.getDate("fim_contrato").toLocalDate());
            return patrocinadores;
        },
        cnpj
        );
    }
}

