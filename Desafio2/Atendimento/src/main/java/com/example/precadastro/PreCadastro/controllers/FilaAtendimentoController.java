package com.example.precadastro.PreCadastro.controllers;

import com.example.precadastro.PreCadastro.models.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Queue;

@RestController
@RequestMapping("/fila-atendimento")
public class FilaAtendimentoController {

    private Queue<Cliente> filaAtendimento = new LinkedList<>();

    // Endpoint para adicionar um cliente à fila de atendimento
    @PostMapping("/adicionar-cliente")
    public ResponseEntity<String> adicionarClienteFila(@RequestBody Cliente cliente) {
        filaAtendimento.add(cliente);
        return ResponseEntity.ok("Cliente adicionado à fila de atendimento.");
    }

    // Endpoint para retirar o próximo cliente da fila de atendimento
    @GetMapping("/retirar-proximo-cliente")
    public ResponseEntity<Cliente> retirarProximoClienteFila() {
        if (filaAtendimento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        Cliente proximoCliente = filaAtendimento.poll();
        return ResponseEntity.ok(proximoCliente);
    }
}
