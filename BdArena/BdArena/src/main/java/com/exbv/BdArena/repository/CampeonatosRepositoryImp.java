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
            return campeonatos;
        });
    }


    @Override
    public List<Campeonatos> tudos_camp() {
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
    public List<Campeonatos> categoria (){
        String sql = "SELECT categoria FROM Campeonatos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Campeonatos campeonatos = new Campeonatos();
            campeonatos.setCategoria(rs.getString("categoria"));
            return campeonatos;
        });
    }

    @Override
    public List<Campeonatos> genero (){
        String sql = "SELECT genero FROM Campeonatos";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Campeonatos campeonatos = new Campeonatos();
            campeonatos.setGenero(rs.getString("genero"));
            return campeonatos;
        });
    }

    @Override
    public int add_campeonato(Campeonatos campeonatos){
        return jdbcTemplate.update("INSERT INTO Campeonatos (id_campeonato, categoria, modalidade, genero, premiacao, vencedor, data_realizacao) VALUES (?, ?, ?, ?, ?, ?, ?)",
                campeonatos.getId_campeonato(),
                campeonatos.getCategoria(),
                campeonatos.getModalidade(),
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
        return jdbcTemplate.update("UPDATE Campeonatos SET categoria = ?, modalidade = ?, genero = ?, premiacao = ?, vencedor = ?, data_realizacao = ? WHERE id_campeonato = ?",
                campeonatos.getId_campeonato(),
                campeonatos.getCategoria(),
                campeonatos.getModalidade(),
                campeonatos.getGenero(),
                java.sql.Date.valueOf(campeonatos.getData_realizacao()),
                campeonatos.getPremiacao(),
                campeonatos.getVencedor());
    }
}