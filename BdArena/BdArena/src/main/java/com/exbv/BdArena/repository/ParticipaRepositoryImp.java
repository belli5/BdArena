package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Participa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipaRepositoryImp implements ParticipaRepository{

    private final JdbcTemplate jdbcTemplate;
    public ParticipaRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Participa> participantes (String cpf_participante){
        return jdbcTemplate.query("SELECT cpf_participante FROM Participa WHERE cpf_participante = ?", new Object[]{cpf_participante}, (rs, rowNum) -> {
            Participa participa = new Participa();
            participa.setCpf_participante(rs.getString("cpf_participante"));
            return participa;
        });
    }

    @Override
    public List<Participa> todos(){
        return jdbcTemplate.query("SELECT * FROM Participa", (rs, rowNum) -> {
            Participa participa = new Participa();
            participa.setCpf_participante(rs.getString("cpf_participante"));
            participa.setId_campeonato(rs.getInt("id_campeonato"));
            return participa;
        });
    }

    @Override
    public List<Participa> por_camp(int id_campeonato){
        return jdbcTemplate.query("SELECT id_campeonato FROM Participa", (rs, rowNum) -> {
            Participa participa = new Participa();
            participa.setId_campeonato(rs.getInt("id_campeonato"));
            return participa;
        });
    }

    @Override
    public int cadastrar(Participa participa){
        return jdbcTemplate.update("INSERT INTO Cliente (cpf_participante, id_campeonato) VALUES (?, ?)",
                participa.getCpf_participante(), participa.getId_campeonato());
    }

    @Override
    public int excluir(String cpf_participante){
        return jdbcTemplate.update("DELETE FROM Cliente WHERE cpf_participante = ?", cpf_participante);
    }

    @Override
    public int atualizar(Participa participa){
        return jdbcTemplate.update(
                "UPDATE Pessoa SET cpf_participante = ? WHERE id_campeonato = ?",
                participa.getCpf_participante(),
                participa.getId_campeonato()
        );
    }
}
