package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
import com.exbv.BdArena.domain.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class AlunoRepositoryImp implements AlunoRepository{

    private final JdbcTemplate jdbcTemplate;
    public AlunoRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Aluno buscarPorCpf_aluno(String cpf_aluno){
        return jdbcTemplate.queryForObject("SELECT * FROM Aluno WHERE cpf_aluno = ?", new Object[]{cpf_aluno}, (rs, rowNum) -> {
            Aluno aluno = new Aluno();
            aluno.setCpf_aluno(rs.getString("cpf_aluno"));
            return aluno;
        });
    }

    @Override
    public List<Aluno> todos_alunos(){
        return jdbcTemplate.query("SELECT * FROM Aluno ORDER BY cpf_aluno", (rs, rowNum) -> {
            Aluno aluno = new Aluno();
            aluno.setCpf_aluno(rs.getString("cpf_aluno"));
            return aluno;
        });
    }

    @Override
    public int cadastrar(Aluno aluno) {
        return jdbcTemplate.update("INSERT INTO Aluno (cpf_aluno) VALUES (?)",
                aluno.getCpf_aluno());
    }

    @Override
    public int excluir(String cpf_aluno) {
        // Excluir registros relacionados na tabela filha
        jdbcTemplate.update("DELETE FROM aula_aluno_turma_professor WHERE aluno_cpf = ?", cpf_aluno);
        jdbcTemplate.update("DELETE FROM Indica WHERE cpf_indicador = ? or cpf_indicado = ?", cpf_aluno, cpf_aluno);
        // Excluir o registro na tabela Aluno
        return jdbcTemplate.update("DELETE FROM Aluno WHERE cpf_aluno = ?", cpf_aluno);
    }

    @Override
    public int cadastrarPessoaAluno(Pessoa pessoa) {
        // Verifica se o CPF já existe na tabela Pessoa
        Integer cpfExiste = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Pessoa WHERE cpf = ?",
                new Object[]{pessoa.getCpf()},
                Integer.class
        );

        int cpfCount = (cpfExiste != null) ? cpfExiste : 0;

        if (cpfCount == 0) {
            // Se o CPF não existir, insere os dados na tabela Pessoa
            jdbcTemplate.update(
                    "INSERT INTO Pessoa (cpf, nome, cidade, bairro, rua, cep, telefone_1, telefone_2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    pessoa.getCpf(),
                    pessoa.getNome(),
                    pessoa.getCidade(),
                    pessoa.getBairro(),
                    pessoa.getRua(),
                    pessoa.getCep(),
                    pessoa.getTelefone_1(),
                    pessoa.getTelefone_2()
            );
        }

        // Insere o CPF na tabela Aluno
        return jdbcTemplate.update(
                "INSERT INTO Aluno (cpf_aluno) VALUES (?)",
                pessoa.getCpf()
        );
    }
}