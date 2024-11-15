package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Funcionario;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class FuncionarioRepositoryImp implements FuncionarioRepository{

    private final JdbcTemplate jdbcTemplate;
    public FuncionarioRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Funcionario id_funcionario (int code_funcionario){
        String sql = "SELECT * FROM Funcionario where code_funcionario = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{code_funcionario}, (rs, rowNum) -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setCod_funcionario(rs.getInt("code_funcionario"));
            return funcionario;
        });
    }

    @Override
    public List<Funcionario> funcao(String funcao){
        String sql = "SELECT funcao FROM Funcionario";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setFuncao(rs.getString("funcao_funcionario"));
            return funcionario;
        });
    }

    @Override
    public List<Funcionario> todos_funcionarios(){
        String sql = "SELECT * FROM Funcionario";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setCod_funcionario(rs.getInt("cod_funcionario"));
            funcionario.setCpf_funcionario(rs.getString("cpf_funcionario"));
            funcionario.setSalario(rs.getFloat("salario"));
            funcionario.setFuncao(rs.getString("funcao"));
            return funcionario;
        });
    }

    @Override
    public int cadastrar(Funcionario funcionario){
        return jdbcTemplate.update("INSERT INTO Funcionario (cod_funcionario, cpf_funcionario, funcao, salario) VALUES (?, ?, ?, ?)",
                funcionario.getCod_funcionario(),
                funcionario.getCpf_funcionario(),
                funcionario.getFuncao(),
                funcionario.getSalario()
        );
    }

    @Override
    public int excluir(int code_funcionario){
        return jdbcTemplate.update("DELETE FROM Funcionario WHERE code_funcionario = ?", code_funcionario);
    }

    @Override
    public int atualizar(Funcionario funcionario){
        return jdbcTemplate.update("UPDATE Funcionario SET Cpf_funcionario = ?, Funcao = ?, Salario = ? WHERE code_funcionario = ?",
                funcionario.getCod_funcionario(),
                funcionario.getCpf_funcionario(),
                funcionario.getFuncao(),
                funcionario.getSalario()
        );
    }
}