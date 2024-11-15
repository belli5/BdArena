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
        String sql = "select * from Produtos where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_produto}, (rs, rowNum) -> {
            Produtos produto = new Produtos();
            produto.setId_produto(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preço"));
            produto.setTipo(rs.getString("tipo"));
            return produto;
        });
    }

    @Override
    public List<Produtos> findAll() {
        String sql = "select * from Produtos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Produtos produto = new Produtos();
            produto.setId_produto(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setPreco(rs.getFloat("preco"));
            produto.setTipo(rs.getString("tipo"));
            return produto;
        });
    }

    @Override
    public void Adicionar(Produtos produtos) {
        jdbcTemplate.update("INSERT TO Produtos (nome, preco, tipo, id_produto) VALUE (?, ?, ?, ?)",
                produtos.getNome(), produtos.getPreco(), produtos.getTipo(), produtos.getId_produto());
    }

    @Override
    public void deletar(int id_produto) {
        // Verificar se o produto existe no estoque
        String checkEstoqueSql = "SELECT COUNT(*) FROM Estoque WHERE id_produto = ?";
        Integer count = jdbcTemplate.queryForObject(checkEstoqueSql, new Object[]{id_produto}, Integer.class);

        // Se o produto não estiver no estoque, prosseguir com a exclusão
        if (count != null && count == 0) {
            String deleteSql = "DELETE FROM Produtos WHERE id = ?";
            jdbcTemplate.update(deleteSql, id_produto);
            System.out.println("excluido com sucesso");
        } else {
            throw new IllegalStateException("O produto ainda está em estoque.");
        }
    }
}