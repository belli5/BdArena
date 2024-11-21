package com.exbv.BdArena.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardRepositoryImplementation implements DashboardRepository{

    private final JdbcTemplate jdbcTemplate;
    public  DashboardRepositoryImplementation(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ObjetoDashBoard infosDashBoard() {
        ObjetoDashBoard objetoDashBoard = new ObjetoDashBoard();
        LocalDate dataAtual = LocalDate.now();
        String dataStr = dataAtual.toString();

        // Quantidade de Reservas Hoje
        Integer resultadoReservasHoje = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Alugar WHERE data = ?",
                Integer.class,
                dataStr);
        objetoDashBoard.setQuantidadeDeReservas(resultadoReservasHoje != null ? resultadoReservasHoje : 0);

        // Quantidade de Alunos Cadastrados
        Integer resultadoAlunosCadastrados = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Aluno",
                Integer.class);
        objetoDashBoard.setQuantidadeDeAlunos(resultadoAlunosCadastrados != null ? resultadoAlunosCadastrados : 0);

        // Quantidade de Compras Hoje
        Integer resultadoComprasHoje = jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM Compra WHERE data = ?",
                Integer.class,
                dataStr);
        objetoDashBoard.setQuantidadeDeCompras(resultadoComprasHoje != null ? resultadoComprasHoje : 0);

        // Gráfico de Pessoas por Cidade
        List<ObjetoStringInt> graficoCidadePessoas = jdbcTemplate.query(
                "SELECT cidade, COUNT(*) AS quantidade FROM Pessoa GROUP BY cidade",
                (rs, rowNum) -> new ObjetoStringInt(
                        rs.getString("cidade"),     // Corrigido o nome da coluna
                        rs.getInt("quantidade")     // Corrigido o nome da coluna
                )
        );
        objetoDashBoard.setPessoasPorCidadeDashBoard(graficoCidadePessoas);

        return objetoDashBoard;
    }
}