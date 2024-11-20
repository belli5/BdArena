package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
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
    public Funcionario id_funcionario (String cpf_funcionario){
        return jdbcTemplate.queryForObject("SELECT * FROM Funcionario where cpf_funcionario = ?", new Object[]{cpf_funcionario}, (rs, rowNum) -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf_funcionario(rs.getString("cpf_funcionario"));
            return funcionario;
        });
    }

    @Override
    public List<Funcionario> funcao(String funcao){
        String sql = "SELECT funcao FROM Funcionario";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setFuncao(rs.getString("funcao"));
            return funcionario;
        });
    }

    @Override
    public List<Funcionario> todos_funcionarios(){
        return jdbcTemplate.query("SELECT * FROM Funcionario", (rs, rowNum) -> {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf_funcionario(rs.getString("cpf_funcionario"));
            funcionario.setSalario(rs.getFloat("salario"));
            funcionario.setFuncao(rs.getString("funcao"));
            return funcionario;
        });
    }

    @Override
    public int cadastrar(Funcionario funcionario){
        return jdbcTemplate.update("INSERT INTO Funcionario (cpf_funcionario, funcao, salario) VALUES (?, ?, ?)",
                funcionario.getCpf_funcionario(),
                funcionario.getFuncao(),
                funcionario.getSalario()
        );
    }

    @Override
    public int excluir(String cpf_funcionario){
        return jdbcTemplate.update("DELETE FROM Funcionario WHERE cpf_funcionario = ?", cpf_funcionario);
    }

    @Override
    public int atualizar(Funcionario funcionario){
        return jdbcTemplate.update("UPDATE Funcionario SET Funcao = ?, Salario = ? WHERE Cpf_funcionario = ?",
                funcionario.getCpf_funcionario(),
                funcionario.getFuncao(),
                funcionario.getSalario()
        );
    }

    @Override
    public int cadastrar_pessoa_funcionario(Pessoa pessoa, String funcao, float salario) {
        Integer cpfExiste = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Pessoa WHERE cpf = ?",
                new Object[]{pessoa.getCpf()},
                Integer.class
        );
        int cpfCount = (cpfExiste != null) ? cpfExiste : 0;

        if (cpfCount == 1) {
            return jdbcTemplate.update("INSERT INTO Funcionario (cpf_funcionario, funcao, salario) VALUES (?, ?, ?)",
                    pessoa.getCpf(),
                    funcao,
                    salario
            );
        } else {
            jdbcTemplate.update("INSERT INTO Pessoa (cpf, nome, cidade, bairro, rua, cep, telefone_1, telefone_2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    pessoa.getCpf(),
                    pessoa.getNome(),
                    pessoa.getCidade(),
                    pessoa.getBairro(),
                    pessoa.getRua(),
                    pessoa.getCep(),
                    pessoa.getTelefone_1(),
                    pessoa.getTelefone_2()
            );
            return jdbcTemplate.update("INSERT INTO Funcionario (cpf_funcionario, funcao, salario) VALUES (?, ?, ?)",
                    pessoa.getCpf(),
                    funcao,
                    salario
            );
        }
    }
}