package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Shows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ShowsRepositoryImplementation implements ShowsRepository {
    private final JdbcTemplate jdbcTemplate;
    public  ShowsRepositoryImplementation(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public int add_shows(Shows shows){
        return jdbcTemplate.update("INSERT INTO Shows (data, artista, festa, cache) VALUES (?,?,?,?)",
                shows.getData(),
                shows.getArtista(),
                shows.getFesta(),
                shows.getCache()
        );
    }

    @Override
    public int del_shows(LocalDate data_show, String artista){
        return  jdbcTemplate.update(
                "DELETE FROM Shows WHERE data = ? and artista = ?",
                data_show,
                artista
        );
    }


    @Override
    public List<Shows> listar_todos() {
        return jdbcTemplate.query("SELECT * FROM Shows", (rs, rowNum) -> {
            Shows shows = new Shows();
            shows.setData(rs.getDate("data").toLocalDate()); // Fetches data as LocalDate directly
            shows.setArtista(rs.getString("artista"));
            shows.setFesta(rs.getString("festa"));
            shows.setCache(rs.getFloat("cache"));
            return shows;
        });
    }

    @Override
    public List<Shows> buscar_por_data (LocalDate data){
        return jdbcTemplate.query("SELECT * FROM Shows WHERE data = ?",(rs, rowNum) ->{
            Shows shows = new Shows();
            shows.setData(rs.getDate("data").toLocalDate());
            shows.setArtista(rs.getString("artista"));
            shows.setFesta(rs.getString("festa"));
            shows.setCache(rs.getFloat("cache"));
            return shows;
        },
        data
        );
    }

    @Override
    public List<Shows> buscar_por_artista (String artista){
        return jdbcTemplate.query("SELECT * FROM Shows WHERE artista = ?",(rs, rowNum) ->{
            Shows shows = new Shows();
            shows.setData(rs.getDate("data").toLocalDate());
            shows.setArtista(rs.getString("artista"));
            shows.setFesta(rs.getString("festa"));
            shows.setCache(rs.getFloat("cache"));
            return shows;
        },
        artista
        );
    }
}

