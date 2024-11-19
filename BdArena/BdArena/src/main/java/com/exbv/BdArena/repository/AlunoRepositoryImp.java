package com.exbv.BdArena.repository;


import com.exbv.BdArena.domain.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class AlunoRepositoryImp implements AlunoRepository{

    private final JdbcTemplate jdbcTemplate;
    public AlunoRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Aluno buscarPorMatricula(int matricula){
        return jdbcTemplate.queryForObject("SELECT * FROM Aluno WHERE matricula = ?", new Object[]{matricula}, (rs, rowNum) -> {
            Aluno aluno = new Aluno();
            aluno.setMatricula(rs.getInt("matricula"));
            aluno.setCpf_aluno(rs.getString("cpf_aluno"));
            return aluno;
        });
    }

    @Override
    public List<Aluno> todos_alunos(){
        return jdbcTemplate.query("SELECT * FROM Aluno ORDER BY matricula", (rs, rowNum) -> {
            Aluno aluno = new Aluno();
            aluno.setCpf_aluno(rs.getString("cpf_aluno"));
            aluno.setMatricula(rs.getInt("matricula"));
            return aluno;
        });
    }

    @Override
    public int cadastrar(Aluno aluno) {
        return jdbcTemplate.update("INSERT INTO Aluno (matricula, cpf_aluno) VALUES (?, ?)",
                aluno.getMatricula(), aluno.getCpf_aluno());
    }

    @Override
    public int excluir(int matricula) {
        // Excluir registros relacionados na tabela filha
        jdbcTemplate.update("DELETE FROM aula_aluno_turma_professor WHERE aluno_matricula = ?", matricula);
        // Excluir o registro na tabela Aluno
        return jdbcTemplate.update("DELETE FROM Aluno WHERE matricula = ?", matricula);
    }
}