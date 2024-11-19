//package com.exbv.BdArena.repository;
//
//import com.exbv.BdArena.domain.Compra;
//import com.exbv.BdArena.domain.Estoque;
//import com.exbv.BdArena.domain.Produtos;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EstoqueRepositoryImplementation implements EstoqueRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//    public EstoqueRepositoryImplementation(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public List<Estoque> todos(){
//        return jdbcTemplate.query("SELECT * FROM Estoque ", (rs, rowNum) -> {
//            Estoque estoque = new Estoque();
//            estoque.setId_produto(rs.getInt("id_produto"));
//            estoque.setQuantidade(rs.getInt("quantidade"));
//            return estoque;
//        });
//    }
//
//    @Override
//    public int qtd_produto(int id_produto){
//        return jdbcTemplate.queryForObject("select * from Estoque where id_produto = ?", (rs, rowNum) -> {
//            Estoque estoque = new Estoque();
//            estoque.setId_produto(rs.getInt("id_produto"));
//            return estoque.getQuantidade();
//        });
//    }
//}
