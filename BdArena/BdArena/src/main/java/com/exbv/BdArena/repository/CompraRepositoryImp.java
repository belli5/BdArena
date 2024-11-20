package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.domain.Compra;
import com.exbv.BdArena.domain.Funcionario;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CompraRepositoryImp implements CompraRepository{

    private final JdbcTemplate jdbcTemplate;
    public CompraRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Compra> tudo(){
        return jdbcTemplate.query("SELECT * FROM Compra ", (rs, rowNum) -> {
            Compra compra = new Compra();
            compra.setId_compra(rs.getInt("id_compra"));
            compra.setId_produto(rs.getInt("id_produto"));
            compra.setCpf_comprador(rs.getString("cpf_comprador"));
            compra.setData(rs.getDate("data").toLocalDate());
            return compra;
        });
    }

    @Override
    public List<Compra> por_pessoa(String cpf_comprador) {
        String sql = "SELECT * FROM Compra WHERE cpf_comprador = ?";
        return jdbcTemplate.query(sql, new Object[]{cpf_comprador}, (rs, rowNum) -> {
            Compra compra = new Compra();
            compra.setId_compra(rs.getInt("id_compra"));
            compra.setCpf_comprador(rs.getString("cpf_comprador"));
            compra.setId_produto(rs.getInt("id_produto"));
            compra.setData(rs.getDate("data").toLocalDate());
            return compra;
        });
    }


    @Override
    public List<Compra> por_produto(int id_produto) {
        // SQL para selecionar todas as colunas de uma compra, filtrando pelo id_produto
        String sql = "SELECT * FROM Compra WHERE id_produto = ?";

        // Executa a consulta e mapeia cada linha do ResultSet para um objeto Compra
        return jdbcTemplate.query(sql, new Object[]{id_produto}, (rs, rowNum) -> {
            Compra compra = new Compra();
            compra.setId_compra(rs.getInt("id_compra"));
            compra.setCpf_comprador(rs.getString("cpf_comprador"));
            compra.setId_produto(rs.getInt("id_produto"));
            compra.setData(rs.getDate("data").toLocalDate()); // Converte SQL Date para LocalDate
            return compra;
        });
    }

    @Override
    public List<Compra> data(LocalDate data) {
        // SQL para selecionar todas as colunas de uma compra, filtrando pela data
        String sql = "SELECT * FROM Compra WHERE data = ?";

        // Executa a consulta e mapeia cada linha do ResultSet para um objeto Compra
        return jdbcTemplate.query(sql, new Object[]{java.sql.Date.valueOf(data)}, (rs, rowNum) -> {
            Compra compra = new Compra();
            compra.setId_compra(rs.getInt("id_compra"));
            compra.setCpf_comprador(rs.getString("cpf_comprador"));
            compra.setId_produto(rs.getInt("id_produto"));
            compra.setData(rs.getDate("data").toLocalDate()); // Converte SQL Date para LocalDate
            return compra;
        });
    }


    @Override
    public int cadastrar(Compra compra){
        return jdbcTemplate.update("INSERT INTO Compra (cpf_comprador, id_produto, data) VALUES (?, ?, ?)",
                compra.getCpf_comprador(),
                compra.getId_produto(),
                java.sql.Date.valueOf(compra.getData())
        );
    }

    @Override
    public int excluir(int id_compra){
        return  jdbcTemplate.update(
                "DELETE FROM Compra WHERE id_compra = ?", id_compra);
    }
}