package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Alugar;
import com.exbv.BdArena.domain.Funcionario;
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
    public List<Indica> indicador (String cpf_indicador){
        return jdbcTemplate.query("SELECT * FROM Indica WHERE cpf_indicador", new Object[]{cpf_indicador}, (rs, rowNum) -> {
            Indica indica = new Indica();
            indica.setCpf_indicador(rs.getString("cpf_indicador"));
            return indica;
        });
    }

    @Override
    public List<Indica> todos (){
        return jdbcTemplate.query("SELECT * FROM Indica", (rs, rowNum) -> {
            Indica indica = new Indica();
            indica.setCpf_indicado(rs.getString("cpf_indicado"));
            indica.setCpf_indicador(rs.getString("cpf_indicador"));
            indica.setDesconto_mensalidade(rs.getFloat("desconto_mensalidade"));
            return indica;
        });
    }

    @Override
    public int add_indicado(Indica indica){
        return jdbcTemplate.update("INSERT INTO Indica (cpf_indicador, cpf_indicado, desconto_mensalidade) VALUES (?, ?, ?)",
                indica.getCpf_indicado(),
                indica.getCpf_indicador(),
                indica.getDesconto_mensalidade()
        );
    }

    @Override
    public int excluir_indicacao(String cpf_indicador, String cpf_indicado){
        return jdbcTemplate.update("DELETE FROM Funcionario WHERE cpf_indicador = ?, cpf_indicado = ?", cpf_indicador, cpf_indicado);
    }
}
