package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.aula_Aluno_Turma_Professor;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class aula_Aluno_Turma_ProfessorRepositoryImp implements aula_Aluno_Turma_ProfessorRepository{

    private final JdbcTemplate jdbcTemplate;
    public aula_Aluno_Turma_ProfessorRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public aula_Aluno_Turma_Professor codigo (int aluno_matricula, int Professor_codigo, int id_turma) {
        String sql = "SELECT * FROM aula_Aluno_Turma_Professor where aluno_matricula = ?, Professor_codigo = ?, id_turma= ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{aluno_matricula, Professor_codigo, id_turma}, (rs, rowNum) -> {
            aula_Aluno_Turma_Professor aula = new aula_Aluno_Turma_Professor();
            aula.setAluno_matricula(rs.getInt("aluno_matricula"));
            aula.setProfessor_codigo(rs.getInt("codigo_professor"));
            aula.setId_turma(rs.getInt("id_turma"));
            return aula;
        });
    }

    @Override
    public List<aula_Aluno_Turma_Professor> tudo() {
        String sql = "SELECT * FROM aula_Aluno_Turma_Professor";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            aula_Aluno_Turma_Professor aula = new aula_Aluno_Turma_Professor();
            aula.setAluno_matricula(rs.getInt("aluno_matricula"));
            aula.setAluno_cpf(rs.getString("cpf_aluno"));
            aula.setProfessor_codigo(rs.getInt("codigo_professor"));
            aula.setId_turma(rs.getInt("id_turma"));
            aula.setProfessor_cpf(rs.getString("cpf_professor"));
            return aula;
        });
    }

    @Override
    public List<aula_Aluno_Turma_Professor> aluno (int aluno_matricula) {
        String sql = "SELECT aluno_matricula, aluno_cpf FROM aula_Aluno_Turma_Professor where auluno_matricula = ?";
        return jdbcTemplate.query(sql, new Object[]{aluno_matricula}, (rs, rowNum) -> {
            aula_Aluno_Turma_Professor aula = new aula_Aluno_Turma_Professor();
            aula.setAluno_matricula(rs.getInt("aluno_matricula"));
            aula.setAluno_cpf(rs.getString("cpf_aluno"));
            return aula;
        });
    }

    @Override
    public List<aula_Aluno_Turma_Professor> professor (int professor_codigo){
        String sql = "SELECT codigo_professor FROM aula_Aluno_Turma_Professor where codigo_professor = ?";
        return jdbcTemplate.query(sql, new Object[]{professor_codigo}, (rs, rowNum) -> {
            aula_Aluno_Turma_Professor aula = new aula_Aluno_Turma_Professor();
            aula.setProfessor_codigo(rs.getInt("professor_codigo"));
            aula.setProfessor_cpf(rs.getString("Professor_cpf"));
            return aula;
        });
    }

    @Override
    public List<aula_Aluno_Turma_Professor> turma ( int id_turma){
        String sql = "SELECT id_turma FROM aula_Aluno_Turma_Professor where id_turma = ?";
        return jdbcTemplate.query(sql, new Object[]{id_turma}, (rs, rowNum) -> {
            aula_Aluno_Turma_Professor aula = new aula_Aluno_Turma_Professor();
            aula.setId_turma(rs.getInt("Id_turma"));
            return aula;
        });
    }

    @Override
    public int cadastrar(aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor){
        return jdbcTemplate.update("INSERT INTO aula_Aluno_Turma_Professor (aluno_matricula, codigo_professor, id_turma, cpf_aluno, cpf_professor) VALUES (?, ?, ?, ?, ?)",
                aula_Aluno_Turma_Professor.getAluno_matricula(),
                aula_Aluno_Turma_Professor.getProfessor_codigo(),
                aula_Aluno_Turma_Professor.getId_turma(),
                aula_Aluno_Turma_Professor.getAluno_cpf(),
                aula_Aluno_Turma_Professor.getProfessor_cpf());
    }

    @Override
    public int excluir(int aluno_matricula, int codigo_professor, int id_turma){
        return jdbcTemplate.update("DELETE FROM aula_Aluno_Turma_Professor WHERE aluno_matricula = ?, codigo_professor = ?, id_turma = ?",
                aluno_matricula, codigo_professor, id_turma);
    }

    @Override
    public int atualizar(aula_Aluno_Turma_Professor aula_Aluno_Turma_Professor){
        return jdbcTemplate.update("UPDATE aula_Aluno_Turma_Professor SET codigo_professor = ?, cpf_aluno = ?, cpf_professor = ? WHERE aluno_matricula = ? AND id_turma = ?",
                aula_Aluno_Turma_Professor.getProfessor_codigo(),
                aula_Aluno_Turma_Professor.getAluno_cpf(),
                aula_Aluno_Turma_Professor.getProfessor_cpf(),
                aula_Aluno_Turma_Professor.getAluno_matricula(),
                aula_Aluno_Turma_Professor.getId_turma());
    }
}