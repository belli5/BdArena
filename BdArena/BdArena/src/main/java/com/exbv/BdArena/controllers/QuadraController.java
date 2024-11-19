package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Quadra;
import com.exbv.BdArena.repository.QuadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/Quadra")
public class QuadraController {

    @Autowired
    private QuadraRepository quadraRepository;

    @GetMapping
    public ResponseEntity<List<Quadra>> gettodas_quadras() {
        List<Quadra> todas_quadras = quadraRepository.listar_todas();
        return ResponseEntity.ok(todas_quadras);
    }

    @PostMapping
    public ResponseEntity<String> add_quadra(@RequestBody Quadra quadra) {
        if (quadra == null || quadra.getNumero_quadra() < 0 || quadra.getModalidade_1() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        quadraRepository.add_quadra(quadra);
        return ResponseEntity.ok("quadra cadastrado com sucesso!");
    }

    @DeleteMapping("/{numero_quadra}")
    public ResponseEntity<String> del_quadra(@PathVariable int numero_quadra) {
        int result = quadraRepository.del_quadra(numero_quadra);
        // Verifica se nenhum registro foi excluído
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("quadra não encontrado.");
        }
        // Se a exclusão for bem-sucedida
        return ResponseEntity.ok("quadra excluído com sucesso.");
    }

    @PutMapping("/{numero_quadra}")
    public ResponseEntity<String> att_quadra(@PathVariable int numero_quadra, @RequestBody Quadra quadra) {
        int result = quadraRepository.att_quadra(numero_quadra, quadra);

        if (result == 0) { // Verifica se nenhum registro foi atualizado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("numero_quadra não encontrado!");
        }

        return ResponseEntity.ok("Quadra atualizada com sucesso!");
    }

    @GetMapping("/{numero_quadra}")
    public ResponseEntity<?> buscar_por_numero(@PathVariable int numero_quadra) {
        // Busca o aluno pelo repositório
        Quadra quadra = quadraRepository.buscar_por_numero(numero_quadra);

        // Verifica se o aluno foi encontrado
        if (quadra == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado!");
        }
        // Retorna os dados do aluno como resposta
        return ResponseEntity.ok(quadra);
    }

//    @GetMapping("/modalidade")
//    public ResponseEntity<List<Quadra>> listarQuadrasPorModalidade(@RequestParam String modalidade) {
//        List<Quadra> quadras = quadraRepository.listar_quadras_por_modalidade(modalidade);
//        if (quadras.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
//        }
//        return ResponseEntity.ok(quadras);
//   }

//    @GetMapping("/modalidades")
//    public ResponseEntity<List<String>> listarModalidades() {
//        List<String> modalidades = quadraRepository.listar_modalidades();
//
//        if (modalidades.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//
//        return ResponseEntity.ok(modalidades);
//    }
}
