package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Compra;
import com.exbv.BdArena.domain.Estoque;
import com.exbv.BdArena.domain.Produtos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstoqueRepositoryImplementation implements EstoqueRepository{

    private final JdbcTemplate jdbcTemplate;
    public EstoqueRepositoryImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Estoque> todos(){
        return jdbcTemplate.query("SELECT * FROM Estoque ", (rs, rowNum) -> {
            Estoque estoque = new Estoque();
            estoque.setId_produto(rs.getInt("id_produto"));
            estoque.setQuantidade(rs.getInt("quantidade"));
            return estoque;
        });
    }

    @Override
    public Estoque qtd_produto(int id_produto) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Estoque WHERE id_produto = ?",
                new Object[]{id_produto},
                (rs, rowNum) -> {
                    Estoque estoque = new Estoque();
                    estoque.setId_produto(rs.getInt("id_produto"));
                    estoque.setQuantidade(rs.getInt("quantidade"));
                    return estoque;
                }
        );
    }

    @Override
    public int cadastrar(Estoque estoque) {
        return jdbcTemplate.update(
                "INSERT INTO Estoque (id_produto, quantidade) VALUES (?, ?)",
                estoque.getId_produto(),
                estoque.getQuantidade()
        );
    }

    @Override
    public int excluir(int id_produto) {
        return jdbcTemplate.update(
                "DELETE FROM Estoque WHERE id_produto = ?",
                id_produto
        );
    }

    @Override
    public int atualizar(int id_produto, Estoque estoque) {
        return jdbcTemplate.update(
                "UPDATE Estoque SET quantidade = ? WHERE id_produto = ?",
                estoque.getQuantidade(),
                estoque.getId_produto()
        );
    }
}
