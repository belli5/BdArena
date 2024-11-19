package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Aluno;
import com.exbv.BdArena.domain.Campeonatos;
import com.exbv.BdArena.repository.CampeonatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/Campeonatos")

public class CampeonatosController {

    @Autowired
    private CampeonatosRepository campeonatosRepository;

    @GetMapping
    public ResponseEntity<List<Campeonatos>> getTodos_campeonatos() {
        List<Campeonatos> Todos_campeonatos = campeonatosRepository.todos_camp();
        return ResponseEntity.ok(Todos_campeonatos);
    }

    @PostMapping
    public ResponseEntity<String> add_campeonato(@RequestBody Campeonatos campeonatos) {
        if (campeonatos == null || campeonatos.getId_campeonato() < 0
                || campeonatos.getCategoria() == null || campeonatos.getModalidade() == null
                || campeonatos.getGenero() == null || campeonatos.getData_realizacao() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        campeonatosRepository.add_campeonato(campeonatos);
        return ResponseEntity.ok("Campeonato adicionado com sucesso!");
    }

    @DeleteMapping("/{id_campeonato}")
    public ResponseEntity<String> excluir_campeonato(@PathVariable int id_campeonato) {
        int result = campeonatosRepository.excluir_campeonato(id_campeonato);
        // Verifica se nenhum registro foi excluído
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campeonato não encontrado.");
        }
        // Se a exclusão for bem-sucedida
        return ResponseEntity.ok("Campeonato excluído com sucesso.");
    }

    @GetMapping("/{id_campeonato}")
    public ResponseEntity<?> achar_camp (@PathVariable int id_campeonato) {
        // Busca o aluno pelo repositório
        Campeonatos campeonatos = campeonatosRepository.achar_camp(id_campeonato);

        // Verifica se o aluno foi encontrado
        if (campeonatos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("campeonato não encontrado!");
        }

        // Retorna os dados do aluno como resposta
        return ResponseEntity.ok(campeonatos);
    }

//    @PutMapping("/{campeonatos}")
//    public ResponseEntity<String> alterar_camp(@PathVariable Campeonatos campeonatos) {
//        String result = clientService.updateClient(cpf, client);
//        if (result.equals("CPF não encontrado!")) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
//        }
//        return ResponseEntity.ok(result);
//    }
}
