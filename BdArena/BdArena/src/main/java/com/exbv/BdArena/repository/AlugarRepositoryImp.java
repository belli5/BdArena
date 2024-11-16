package com.exbv.BdArena.repository;

import com.exbv.BdArena.domain.Alugar;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class AlugarRepositoryImp implements AlugarRepository{

    private final JdbcTemplate jdbcTemplate;
    public AlugarRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Alugar alugar_1 (int numero_quadra, String pessoa_cpf){
        return jdbcTemplate.queryForObject("SELECT * FROM Alugar WHERE numero_quadra = ? and pessoa_cpf= ?", new Object[]{numero_quadra, pessoa_cpf}, (rs, rowNum) -> {
            Alugar alugar = new Alugar();
            alugar.setNumero_quadra(rs.getInt("numero_quadra"));
            alugar.setPessoa_cpf(rs.getString("pessoa_cpf"));
            return alugar;
        });
    }

    @Override
    public List<Alugar> tudo(){
        return jdbcTemplate.query("SELECT * FROM Alugar", (rs, rowNum) -> {
            Alugar alugar = new Alugar();
            alugar.setNumero_quadra(rs.getInt("numero_quadra"));
            alugar.setPessoa_cpf(rs.getString("pessoa_cpf"));
            alugar.setValor(rs.getFloat("valor"));
            alugar.setData(rs.getDate("data").toLocalDate());
            alugar.setHorario(rs.getTime("horario").toLocalTime());
            alugar.setItens(rs.getString("itens"));
            return alugar;
        });
    }

    @Override
    public List<Alugar> numero(int numero_quadra){
        return jdbcTemplate.query("SELECT * FROM Alugar WHERE numero_quadra = ?", (rs, rowNum) -> {
            Alugar alugar = new Alugar();
            alugar.setNumero_quadra(rs.getInt("numero_quadra"));
            return alugar;
        });
    }

    @Override
    public List<Alugar> pessoa(String pessoa_cpf){
        return jdbcTemplate.query("SELECT * FROM Alugar WHERE pessoa_cpf= ?",(rs, rowNum) -> {
            Alugar alugar = new Alugar();
            alugar.setPessoa_cpf(rs.getString("pessoa_cpf"));
            return alugar;
        });
    }

    @Override
    public List<Alugar> data(LocalDate data, LocalTime horario){
        return jdbcTemplate.query("SELECT * FROM Alugar WHERE data = ? and horario= ?", (rs, rowNum) -> {
            Alugar alugar = new Alugar();
            alugar.setData(rs.getDate("data").toLocalDate());
            alugar.setHorario(rs.getTime("horario").toLocalTime());
            return alugar;
        });
    }

    @Override
    public int cadastrar(Alugar alugar){
        return jdbcTemplate.update("INSERT INTO Alugar (numero_quadra, pessoa_cpf, data, horario, itens, valor) VALUES (?, ?, ?, ?, ?, ?)",
                alugar.getNumero_quadra(),
                alugar.getPessoa_cpf(),
                java.sql.Date.valueOf(alugar.getData()),
                java.sql.Time.valueOf(alugar.getHorario()),
                alugar.getItens(),
                alugar.getValor()
        );
    }

    @Override
    public int excluir(int numero_quadra, String pessoa_cpf){
        return  jdbcTemplate.update(
                "DELETE FROM Alugar WHERE numero_quadra = ? and pessoa_cpf = ?",
                numero_quadra,
                pessoa_cpf
        );
    }

    @Override
    public int atualizar(Alugar alugar){
        return jdbcTemplate.update(
                "UPDATE Alugar SET pessoa_cpf = ?, horario = ?, itens = ?, valor = ? WHERE numero_quadra = ?,  data = ?",
                alugar.getPessoa_cpf(),
                alugar.getHorario(),
                alugar.getItens(),
                alugar.getValor(),
                alugar.getNumero_quadra(),
                java.sql.Date.valueOf(alugar.getData())
        );
    }
}