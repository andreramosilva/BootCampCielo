package com.example.precadastro.PreCadastro.Controllers.dto;

import com.example.precadastro.PreCadastro.controllers.dto.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteResponseTest {

    private ClienteResponse clienteResponse;

    @BeforeEach
    public void setUp() {
        clienteResponse = new ClienteResponse();
    }

    @Test
    public void testGetAndSetNome() {
        clienteResponse.setNome("John Doe");
        assertEquals("John Doe", clienteResponse.getNome());
    }

    @Test
    public void testGetAndSetCpf() {
        clienteResponse.setCpf("12345678901");
        assertEquals("12345678901", clienteResponse.getCpf());
    }

    @Test
    public void testGetAndSetMcc() {
        clienteResponse.setMcc("1234");
        assertEquals("1234", clienteResponse.getMcc());
    }

    @Test
    public void testGetAndSetEmail() {
        clienteResponse.setEmail("john@example.com");
        assertEquals("john@example.com", clienteResponse.getEmail());
    }

    @Test
    public void testGetAndSetCnpj() {
        clienteResponse.setCnpj("12345678901234");
        assertEquals("12345678901234", clienteResponse.getCnpj());
    }

    @Test
    public void testGetAndSetRazaoSocial() {
        clienteResponse.setRazaoSocial("Empresa ABC");
        assertEquals("Empresa ABC", clienteResponse.getRazaoSocial());
    }

    @Test
    public void testGetAndSetNomeContato() {
        clienteResponse.setNomeContato("Jane Doe");
        assertEquals("Jane Doe", clienteResponse.getNomeContato());
    }

    @Test
    public void testGetAndSetEmailContato() {
        clienteResponse.setEmailContato("jane@example.com");
        assertEquals("jane@example.com", clienteResponse.getEmailContato());
    }
}
