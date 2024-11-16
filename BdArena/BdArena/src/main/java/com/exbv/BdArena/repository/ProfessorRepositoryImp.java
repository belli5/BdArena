package com.exbv.BdArena.repository;


import com.exbv.BdArena.domain.Produtos;
import org.springframework.stereotype.Repository;
import com.exbv.BdArena.domain.Professor;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class ProfessorRepositoryImp implements ProfessorRepository{

    private final JdbcTemplate jdbcTemplate;

    public ProfessorRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Professor codigo (int codigo_professor){
        return jdbcTemplate.queryForObject("select * from Professor where codigo_professor = ?", new Object[]{codigo_professor}, (rs, rowNum) -> {
            Professor professor = new Professor();
            professor.setCodigo_professor(rs.getInt("codigo_professor"));
            return professor;
        });
    }

    @Override
    public List<Professor> todos_prof(){
        return jdbcTemplate.query("select * from Professor", (rs, rowNum) -> {
            Professor professor = new Professor();
            professor.setCodigo_professor(rs.getInt("codigo_professor"));
            professor.setCpf_professor(rs.getString("cpf_professor"));
            professor.setEspecialidade_1(rs.getString("especialidade_1"));
            professor.setEspecialidade_2(rs.getString("especialidade_2"));
            professor.setEspecialidade_3(rs.getString("especialidade_3"));
            return professor;
        });
    }

    @Override
    public List<Professor> modalidade (String especialidade_1, String especialidade_2, String especialidade_3){
        return jdbcTemplate.query("select * from Professor where especialidade_1 = ?, especialidade_2 = ?, especialidade_3 = ?", (rs, rowNum) -> {
            Professor professor = new Professor();
            professor.setEspecialidade_1(rs.getString("especialidade_1"));
            professor.setEspecialidade_2(rs.getString("especialidade_2"));
            professor.setEspecialidade_3(rs.getString("especialidade_3"));
            return professor;
        });
    }

    @Override
    public int cadastrar(Professor professor){
        return jdbcTemplate.update("INSERT INTO Professor (codigo_professor, cpf_professor, especialidade_1, especialidade_2, especialidade_3) VALUES (?, ?, ?, ?, ?)",
                professor.getCodigo_professor(), professor.getCpf_professor(), professor.getEspecialidade_1(),
                professor.getEspecialidade_2(), professor.getEspecialidade_3());
    }

    @Override
    public int excluir(int codigo_professor){
            return jdbcTemplate.update("DELETE FROM Professor WHERE codigo_professor = ?", codigo_professor);
    }

    @Override
    public int atualizar(Professor professor){
        return jdbcTemplate.update(
                "UPDATE Professor SET especialidade_1 = ?, especialidade_2 = ?, especialidade_3 = ? WHERE codigo_professor = ?, cpf_professor = ?",
                professor.getCodigo_professor(), professor.getCpf_professor(), professor.getEspecialidade_1(),
                professor.getEspecialidade_2(), professor.getEspecialidade_3()
        );
    }
}
