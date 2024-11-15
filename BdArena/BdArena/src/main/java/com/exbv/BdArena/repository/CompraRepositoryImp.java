//package com.exbv.BdArena.repository;
//
//import com.exbv.BdArena.domain.Campeonatos;
//import com.exbv.BdArena.domain.Compra;
//import com.exbv.BdArena.domain.Funcionario;
//import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public class CompraRepositoryImp implements CompraRepository{
//
//    private final JdbcTemplate jdbcTemplate;
//    public CompraRepositoryImp(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//
//    @Override
//    public List<Compra> tudo(){
//        String sql = "SELECT * FROM Compra ";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Compra compra = new Compra();
//            compra.setId_produto(rs.getInt("id_produto"));
//            compra.setCpf_comprador(rs.getString("cpf_comprador"));
//            compra.setData(rs.getDate("data").toLocalDate());
//            return compra;
//        });
//    }
//
//    @Override
//    public List<Compra> por_pessoa(String pessoa_cpf){
//        String sql = "SELECT Cpf_comprador FROM Compra";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Compra compra = new Compra();
//            compra.setCpf_comprador(rs.getString("pessoa_cpf"));
//            return compra;
//        });
//    }
//
//    @Override
//    public List<Compra> por_produto (int id_produto){
//        String sql = "SELECT id_produto FROM Compra";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Compra compra = new Compra();
//            compra.setId_produto(rs.getInt("id_produto"));
//            return compra;
//        });
//    }
//
//    @Override
//    public List<Compra> data (LocalDate data){
//        String sql = "SELECT data FROM Compra";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Compra compra = new Compra();
//            compra.setData(rs.getDate("data").toLocalDate());
//            return compra;
//        });
//    }
//
//    @Override
//    public int cadastrar(Compra compra){
//        return jdbcTemplate.update("INSERT INTO Compra (cpf_comprador, id_produto, data) VALUES (?, ?, ?)",
//                compra.getCpf_comprador(),
//                compra.getId_produto(),
//                java.sql.Date.valueOf(compra.getData())
//        );
//    }
//
//    @Override
//    public
//}