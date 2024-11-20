package com.exbv.BdArena.repository;


import com.exbv.BdArena.domain.Pessoa;
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
    public List<Professor> todos_prof(){
        return jdbcTemplate.query("select * from Professor", (rs, rowNum) -> {
            Professor professor = new Professor();
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
        return jdbcTemplate.update("INSERT INTO Professor (cpf_professor, especialidade_1, especialidade_2, especialidade_3) VALUES ( ?, ?, ?, ?)",
                professor.getCpf_professor(), professor.getEspecialidade_1(),
                professor.getEspecialidade_2(), professor.getEspecialidade_3());
    }

    @Override
    public int excluir( String cpf_professor){
            return jdbcTemplate.update("DELETE FROM Professor WHERE cpf_professor = ?", cpf_professor);
    }

    @Override
    public int atualizar(Professor professor){
        return jdbcTemplate.update(
                "UPDATE Professor SET especialidade_1 = ?, especialidade_2 = ?, especialidade_3 = ? WHERE cpf_professor = ?",
                professor.getCpf_professor(), professor.getEspecialidade_1(),
                professor.getEspecialidade_2(), professor.getEspecialidade_3()
        );
    }

//    @Override
//    public int cadastrar_pessoa_funcionario_professor(Pessoa pessoa, String funcao, float salario, String modalidade_1){
//        Integer cpfExiste = jdbcTemplate.queryForObject(
//                "SELECT COUNT(*) FROM Pessoa WHERE cpf = ?",
//                new Object[]{pessoa.getCpf()},
//                Integer.class
//        );
//
//        int cpfCount = (cpfExiste != null) ? cpfExiste : 0;
//
//        if(cpfCount == 1){
//
//        }else{
//
//        }
//    }
//
//        // Se o CPF existe (cpfCount == 1), significa que a pessoa já está cadastrada
//        if (cpfCount == 1) {
//            return jdbcTemplate.update("INSERT INTO Funcionario (cpf_funcionario, funcao, salario) VALUES (?, ?, ?)",
//                    pessoa.getCpf(),
//                    funcao,
//                    salario
//            );
//        } else {
//            jdbcTemplate.update("INSERT INTO Pessoa (cpf, nome, cidade, bairro, rua, cep, telefone_1, telefone_2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
//                    pessoa.getCpf(),
//                    pessoa.getNome(),
//                    pessoa.getCidade(),
//                    pessoa.getBairro(),
//                    pessoa.getRua(),
//                    pessoa.getCep(),
//                    pessoa.getTelefone_1(),
//                    pessoa.getTelefone_2()
//            );
//
//            return jdbcTemplate.update("INSERT INTO Funcionario (cpf_funcionario, funcao, salario) VALUES (?, ?, ?)",
//                    pessoa.getCpf(),
//                    funcao,
//                    salario
//            );
//        }
//    }

}
