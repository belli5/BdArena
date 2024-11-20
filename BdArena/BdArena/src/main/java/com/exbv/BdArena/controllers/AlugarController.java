package com.exbv.BdArena.controllers;

import com.exbv.BdArena.domain.Alugar;
import com.exbv.BdArena.repository.AlugarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/Alugar")
public class AlugarController {

    @Autowired
    private AlugarRepository alugarRepository;

    @GetMapping
    public ResponseEntity<List<Alugar>> getTodos_alugueis() {
        List<Alugar> Todos_alugueis = alugarRepository.tudo();
        return ResponseEntity.ok(Todos_alugueis);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody Alugar alugar) {
        if (alugar == null || alugar.getNumero_quadra() < 0 || alugar.getPessoa_cpf() == null ||
                alugar.getValor() == 0.0 || alugar.getData() == null || alugar.getHorario() == null) {
            return ResponseEntity.badRequest().body("Dados inválidos no corpo da requisição.");
        }
        alugarRepository.cadastrar(alugar);
        return ResponseEntity.ok("Aluguel feito com sucesso!");
    }

    @DeleteMapping("/{numero_quadra}/{pessoa_cpf}/{data}/{horario}")
    public ResponseEntity<String> excluir(
            @PathVariable int numero_quadra,
            @PathVariable String pessoa_cpf,
            @PathVariable String data,  // Recebe como String
            @PathVariable String horario // Recebe como String
    ) {
        // Convertendo manualmente para LocalDate e LocalTime
        LocalDate localDate = LocalDate.parse(data);
        LocalTime localTime = LocalTime.parse(horario);

        int result = alugarRepository.excluir(numero_quadra, pessoa_cpf, localDate, localTime);

        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel não encontrado.");
        }

        return ResponseEntity.ok("Aluguel excluído com sucesso.");
    }

    @PutMapping("/{pessoa_cpf}/{numero_quadra}")
    public ResponseEntity<String> atualizar(@PathVariable String pessoa_cpf,
                                            @PathVariable int numero_quadra,
                                            @RequestBody Alugar alugar) {
        // Use a variável 'data' diretamente, sem conversão
        int result = alugarRepository.atualizar(numero_quadra, pessoa_cpf, alugar);

        if (result == 0) { // Verifica se nenhum registro foi atualizado
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("pessoa_cpf não encontrado!");
        }

        return ResponseEntity.ok("Aluguel atualizado com sucesso!");
    }


}
