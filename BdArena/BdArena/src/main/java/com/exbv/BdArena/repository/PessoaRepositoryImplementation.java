package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepositoryImplementation implements PessoaRepository{
    private final JdbcTemplate jdbcTemplate;
    public PessoaRepositoryImplementation(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int add_pessoa(Pessoa pessoa){
        return jdbcTemplate.update(
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

    @Override
    public int att_pessoa(String cpf, Pessoa pessoa){
        return jdbcTemplate.update(
                "UPDATE Pessoa SET nome = ?, cidade = ?, bairro = ?, rua = ?, cep = ?, telefone_1 = ?, telefone_2 = ? WHERE cpf = ?",
                pessoa.getNome(),
                pessoa.getCidade(),
                pessoa.getBairro(),
                pessoa.getRua(),
                pessoa.getCep(),
                pessoa.getTelefone_1(),
                pessoa.getTelefone_2(),
                cpf
        );
    }

    @Override
    public int del_pessoa(String cpf) {
        // Excluir registros relacionados aos alunos e funcionários
        jdbcTemplate.update("DELETE FROM Aula_Aluno_Turma_Professor WHERE aluno_cpf = ?", cpf); // Netos de Pessoa via Aluno
        jdbcTemplate.update("DELETE FROM Aula_Aluno_Turma_Professor WHERE professor_cpf IN (SELECT cpf_funcionario FROM Funcionario WHERE cpf_funcionario = ?)", cpf);
        jdbcTemplate.update("DELETE FROM Secretaria WHERE cpf_secretaria IN (SELECT cpf_funcionario FROM Funcionario WHERE cpf_funcionario = ?)", cpf);
        jdbcTemplate.update("DELETE FROM Administrador WHERE cpf_administrador IN (SELECT cpf_funcionario FROM Funcionario WHERE cpf_funcionario = ?)", cpf);
        jdbcTemplate.update("DELETE FROM Professor WHERE cpf_professor IN (SELECT cpf_funcionario FROM Funcionario WHERE cpf_funcionario = ?)", cpf);


        // Excluir dependências diretas
        jdbcTemplate.update("DELETE FROM Aluno WHERE cpf_aluno = ?", cpf);
        jdbcTemplate.update("DELETE FROM Funcionario WHERE cpf_funcionario = ?", cpf);
        jdbcTemplate.update("DELETE FROM Alugar WHERE pessoa_cpf = ?", cpf);
        jdbcTemplate.update("DELETE FROM Compra WHERE cpf_comprador = ?", cpf);
        jdbcTemplate.update("DELETE FROM Participa WHERE cpf_participante = ?", cpf);

        // Excluir a própria pessoa
        return jdbcTemplate.update("DELETE FROM Pessoa WHERE cpf = ?", cpf);
    }

    @Override
    public Pessoa buscar_por_cpf (String cpf){
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Pessoa WHERE cpf = ?",
                (rs, rowNum) -> {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setCpf(rs.getString("cpf"));
                    pessoa.setNome(rs.getString("nome"));
                    pessoa.setCidade(rs.getString("cidade"));
                    pessoa.setBairro(rs.getString("bairro"));
                    pessoa.setRua(rs.getString("rua"));
                    pessoa.setCep(rs.getString("cep"));
                    pessoa.setTelefone_1(rs.getString("telefone_1"));
                    pessoa.setTelefone_2(rs.getString("telefone_2"));
                    return pessoa;
                },
                cpf
        );
    }

    @Override
    public List<Pessoa> listar_todos(){
        return jdbcTemplate.query("SELECT * FROM Pessoa", (rs, rowNum) -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf(rs.getString("cpf"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setCidade(rs.getString("cidade"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setRua(rs.getString("rua"));
            pessoa.setCep(rs.getString("cep"));
            pessoa.setTelefone_1(rs.getString("telefone_1"));
            pessoa.setTelefone_2(rs.getString("telefone_2"));
            return pessoa;
        });
    }

    public List<Pessoa> listar_ordem_alfabetica(){
        return jdbcTemplate.query("SELECT * FROM Pessoa ORDER BY nome ASC", (rs, rowNum) -> {
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf(rs.getString("cpf"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setCidade(rs.getString("cidade"));
            pessoa.setBairro(rs.getString("bairro"));
            pessoa.setRua(rs.getString("rua"));
            pessoa.setCep(rs.getString("cep"));
            pessoa.setTelefone_1(rs.getString("telefone_1"));
            pessoa.setTelefone_2(rs.getString("telefone_2"));
            return pessoa;
        });
    }

}
