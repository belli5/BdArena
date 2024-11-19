package com.exbv.BdArena.repository;


import org.springframework.stereotype.Repository;
import com.exbv.BdArena.domain.Produtos;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

@Repository
public class ProdutosRepositoryImp implements ProdutosRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProdutosRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Produtos Achar_Id(int id_produto) {
        return jdbcTemplate.queryForObject("select * from Produtos where id_produto = ?", (rs, rowNum) -> {
            Produtos produto = new Produtos();
            produto.setId_produto(rs.getInt("id_produto"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setTipo(rs.getString("tipo"));
            return produto;
        },
        id_produto
        );
    }

    @Override
    public List<Produtos> findAll() {
        return jdbcTemplate.query("select * from Produtos", (rs, rowNum) -> {
            Produtos produto = new Produtos();
            produto.setId_produto(rs.getInt("id_produto"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setTipo(rs.getString("tipo"));
            return produto;
        });
    }

    @Override
    public void Adicionar(Produtos produtos) {
        jdbcTemplate.update("INSERT INTO Produtos (nome, preco, tipo, id_produto) VALUES (?, ?, ?, ?)",
                produtos.getNome(), produtos.getPreco(), produtos.getTipo(), produtos.getId_produto());
    }

    @Override
    public int deletar(int id_produto) {
        jdbcTemplate.update("DELETE FROM Estoque WHERE id_produto = ?", id_produto);
        return jdbcTemplate.update("DELETE FROM Produtos WHERE id_produto = ?", id_produto);
    }

}