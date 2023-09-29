package com.example.precadastro.PreCadastro.controllers;

import com.amazonaws.services.sqs.model.Message;
import com.example.precadastro.PreCadastro.models.Cliente;
import com.example.precadastro.PreCadastro.services.SqsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fila-atendimento")
public class FilaAtendimentoController {

    private SqsService sqsService = new SqsService();
    //private Queue<Cliente> filaAtendimento = new LinkedList<>();

    // Endpoint para adicionar um cliente à fila de atendimento
    @PostMapping("/adicionar-cliente")
    public ResponseEntity<String> adicionarClienteFila(@RequestBody Cliente cliente) {
        //filaAtendimento.add(cliente);
        sqsService.enviaMensagem(cliente.toString());
        return ResponseEntity.ok("Cliente adicionado à fila de atendimento.");
    }

    // Endpoint para retirar o próximo cliente da fila de atendimento
    @GetMapping("/retirar-proximo-cliente")
    public ResponseEntity<List<Message>> retirarProximoClienteFila() {
        List<Message> messages = sqsService.recebeMensagem();
        if (messages.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        //Cliente proximoCliente = filaAtendimento.poll();

        return ResponseEntity.ok(messages);
    }
}
