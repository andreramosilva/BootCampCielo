package com.example.precadastro.PreCadastro.Controllers;

import com.example.precadastro.PreCadastro.controllers.ClienteController;
import com.example.precadastro.PreCadastro.controllers.dto.ClienteRequest;
import com.example.precadastro.PreCadastro.controllers.dto.ClienteResponse;
import com.example.precadastro.PreCadastro.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class ClienteControllerTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCadastrarCliente() {
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();

        when(clienteService.cadastrarCliente(clienteRequest)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> responseEntity = clienteController.cadastrarCliente(clienteRequest);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertSame(clienteResponse, responseEntity.getBody());
    }

    @Test
    public void testConsultarCliente() {
        Long id = 1L;
        String type = "pf";
        ClienteResponse clienteResponse = new ClienteResponse();

        when(clienteService.consultarCliente(id, type)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> responseEntity = clienteController.consultarCliente(id, type);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(clienteResponse, responseEntity.getBody());
    }

    @Test
    public void testListarClientes() {
        List<ClienteResponse> clienteResponses = Arrays.asList(new ClienteResponse(), new ClienteResponse());

        when(clienteService.listarClientes()).thenReturn(clienteResponses);

        ResponseEntity<List<ClienteResponse>> responseEntity = clienteController.listarClientes();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(clienteResponses, responseEntity.getBody());
    }

    @Test
    public void testAtualizarCliente() {
        Long id = 1L;
        String type = "pf";
        ClienteRequest clienteRequest = new ClienteRequest();
        ClienteResponse clienteResponse = new ClienteResponse();

        when(clienteService.atualizarCliente(id, clienteRequest, type)).thenReturn(clienteResponse);

        ResponseEntity<ClienteResponse> responseEntity = clienteController.atualizarCliente(id, type, clienteRequest);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertSame(clienteResponse, responseEntity.getBody());
    }

    @Test
    public void testExcluirCliente() {
        Long id = 1L;
        String type = "pf";

        ResponseEntity<Void> responseEntity = clienteController.excluirCliente(id, type);

        verify(clienteService, times(1)).excluirCliente(id, type);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}
