package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Campeonatos;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class CampeonatosRepositoryImp implements CampeonatosRepository{

    private final JdbcTemplate jdbcTemplate;
    public CampeonatosRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Campeonatos achar_camp (int id_campeonato){
        String sql = "SELECT * FROM Campeonatos where id_campeonato = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id_campeonato}, (rs, rowNum) -> {
            Campeonatos campeonatos = new Campeonatos();
            campeonatos.setId_campeonato(rs.getInt("id_campeonato"));
            campeonatos.setCategoria(rs.getString("categoria"));
            campeonatos.setModalidade(rs.getString("modalidade"));
            campeonatos.setGenero(rs.getString("genero"));
            campeonatos.setPremiacao(rs.getString("premiacao"));
            campeonatos.setVencedor(rs.getString("vencedor"));
            campeonatos.setData_realizacao(rs.getDate("data_realizacao").toLocalDate());
            return campeonatos;
        });
    }


    @Override
    public List<Campeonatos> todos_camp() {
        return jdbcTemplate.query("SELECT * FROM Campeonatos", (rs, rowNum) -> {
            Campeonatos campeonatos = new Campeonatos();
            campeonatos.setId_campeonato(rs.getInt("id_campeonato"));
            campeonatos.setCategoria(rs.getString("categoria"));
            campeonatos.setModalidade(rs.getString("modalidade"));
            campeonatos.setGenero(rs.getString("genero"));
            campeonatos.setPremiacao(rs.getString("premiacao"));
            campeonatos.setVencedor(rs.getString("vencedor"));
            campeonatos.setData_realizacao(rs.getDate("data_realizacao").toLocalDate());
            return campeonatos;
        });
    }

    @Override
    public List<Campeonatos> categoria (String categoria){
        String sql = "SELECT * FROM Campeonatos WHERE categoria = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Campeonatos campeonatos = new Campeonatos();
            campeonatos.setId_campeonato(rs.getInt("id_campeonato"));
            campeonatos.setCategoria(rs.getString("categoria"));
            campeonatos.setModalidade(rs.getString("modalidade"));
            campeonatos.setGenero(rs.getString("genero"));
            campeonatos.setPremiacao(rs.getString("premiacao"));
            campeonatos.setVencedor(rs.getString("vencedor"));
            campeonatos.setData_realizacao(rs.getDate("data_realizacao").toLocalDate());
            return campeonatos;
        },
        categoria
        );
    }

    @Override
    public List<Campeonatos> genero (String genero){
        String sql = "SELECT * FROM Campeonatos WHERE genero= ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Campeonatos campeonatos = new Campeonatos();
            campeonatos.setId_campeonato(rs.getInt("id_campeonato"));
            campeonatos.setCategoria(rs.getString("categoria"));
            campeonatos.setModalidade(rs.getString("modalidade"));
            campeonatos.setGenero(rs.getString("genero"));
            campeonatos.setPremiacao(rs.getString("premiacao"));
            campeonatos.setVencedor(rs.getString("vencedor"));
            campeonatos.setData_realizacao(rs.getDate("data_realizacao").toLocalDate());
            return campeonatos;
        },
        genero
        );
    }

    @Override
    public int add_campeonato(Campeonatos campeonatos){
        return jdbcTemplate.update("INSERT INTO Campeonatos (modalidade, categoria, genero, data_realizacao, premiacao, vencedor) VALUES (?, ?, ?, ?, ?, ?)",
                campeonatos.getModalidade(),
                campeonatos.getCategoria(),
                campeonatos.getGenero(),
                java.sql.Date.valueOf(campeonatos.getData_realizacao()),
                campeonatos.getPremiacao(),
                campeonatos.getVencedor()
        );
    }

    @Override
    public int excluir_campeonato(int id_campeonato) {
        return jdbcTemplate.update("DELETE FROM Campeonatos WHERE id_campeonato = ?", id_campeonato);
    }

    @Override
    public int alterar_camp(Campeonatos campeonatos){
        return jdbcTemplate.update("UPDATE Campeonatos SET modalidade = ?, categoria = ?, genero = ?, data_realizacao = ?, premiacao = ?, vencedor = ? WHERE id_campeonato = ?",
                campeonatos.getModalidade(),
                campeonatos.getCategoria(),
                campeonatos.getGenero(),
                java.sql.Date.valueOf(campeonatos.getData_realizacao()),
                campeonatos.getPremiacao(),
                campeonatos.getVencedor(),
                campeonatos.getId_campeonato());
    }
}