package com.exbv.BdArena.repository;


import com.exbv.BdArena.domain.Aluno;
import org.springframework.stereotype.Repository;
import com.exbv.BdArena.domain.Produtos;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class AlunoImpl implements AlunoRepository{

    private final JdbcTemplate jdbcTemplate;
    public AlunoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Aluno matricula(int matricula){
        String sql = "SELECT * FROM Cliente WHERE matricula = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{matricula}, (rs, rowNum) -> {
            Aluno aluno = new Aluno();
            aluno.setMatricula(rs.getInt("matricula"));
            aluno.setCpf_aluno(rs.getString("cpf"));
            return aluno;
        });
    }

    @Override
    public List<Aluno> todos_alunos(){
        return jdbcTemplate.query("select * from Aluno where status= 'Ativo'", (rs, rowNum) -> {
            Aluno aluno = new Aluno();
            aluno.setCpf_aluno(rs.getString("cpf"));
            aluno.setMatricula(rs.getInt("matricula"));
            return aluno;
        });
    }

    @Override
    public int cadastrar(Aluno aluno) {
        return jdbcTemplate.update("INSERT INTO Cliente (matricula, cpf) VALUES (?, ?)",
                aluno.getMatricula(), aluno.getCpf_aluno());
    }

    @Override
    //Se um aluno com a matrícula especificada for excluído, o retorno será 1; caso não encontre nenhum, será 0.
    public int excluir (int matricula){
        return jdbcTemplate.update("DELETE FROM Cliente WHERE matricula = ?", matricula);
    }

}