package com.example.precadastro.PreCadastro.controllers;

import com.example.precadastro.PreCadastro.controllers.dto.ClienteRequest;
import com.example.precadastro.PreCadastro.controllers.dto.ClienteResponse;
import com.example.precadastro.PreCadastro.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
//@Api(tags = "Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    //@ApiOperation("Cadastra cliente baseado no payload e na flag(typo) enviada pf ou pj")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        ClienteResponse response = clienteService.cadastrarCliente(clienteRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/consultar")
    //@ApiOperation("Consulta um cliente por ID e tipo (pf ou pj)")
    public ResponseEntity<ClienteResponse> consultarCliente(@RequestParam Long id, @RequestParam String type) {
        ClienteResponse response = clienteService.consultarCliente(id, type);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    //@ApiOperation("Lista todos os clientes")
    public ResponseEntity<List<ClienteResponse>> listarClientes() {
        List<ClienteResponse> response = clienteService.listarClientes();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/{type}")
    //@ApiOperation("Altera um cliente por ID e tipo")
    public ResponseEntity<ClienteResponse> atualizarCliente(@PathVariable Long id, @PathVariable String type, @RequestBody ClienteRequest clienteRequest) {
        ClienteResponse response = clienteService.atualizarCliente(id, clienteRequest, type);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/{type}")
    //@ApiOperation("Deleta um cliente por ID e tipo")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id, @PathVariable String type) {
        clienteService.excluirCliente(id, type);
        return ResponseEntity.noContent().build();
    }
}

