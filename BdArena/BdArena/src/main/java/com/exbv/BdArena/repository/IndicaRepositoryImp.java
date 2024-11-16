package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Alugar;
import com.exbv.BdArena.domain.Indica;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class IndicaRepositoryImp implements IndicaRepository{

    private final JdbcTemplate jdbcTemplate;
    public IndicaRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Indica> indicador (int matricula_indicador){
        return jdbcTemplate.query("SELECT * FROM Indica WHERE matricula_indicador", new Object[]{matricula_indicador}, (rs, rowNum) -> {
            Indica indica = new Indica();
            indica.setMatricula_indicador(rs.getInt("matricula_indicador"));
            return indica;
        });
    }

    @Override
    public List<Indica> todos (){
        return jdbcTemplate.query("SELECT * FROM Indica", (rs, rowNum) -> {
            Indica indica = new Indica();
            indica.setMatricula_indicador(rs.getInt("matricula_indicador"));
            indica.setCpf_indicado(rs.getString("cpf_indicado"));
            indica.setCpf_indicador(rs.getString("cpf_indicador"));
            indica.setMatricula_indicado(rs.getInt("matricula_indicado"));
            indica.setDesconto_mensalidade(rs.getFloat("desconto_mensalidade"));
            return indica;
        });
    }
}
