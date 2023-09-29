package com.example.precadastro.PreCadastro.Controllers.dto;

import com.example.precadastro.PreCadastro.controllers.dto.ClienteRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteRequestTest {

    private ClienteRequest clienteRequest;

    @BeforeEach
    public void setUp() {
        clienteRequest = new ClienteRequest();
    }

    @Test
    public void testGetAndSetFlag() {
        clienteRequest.setFlag("pf");
        assertEquals("pf", clienteRequest.getFlag());
    }

    @Test
    public void testGetAndSetNome() {
        clienteRequest.setNome("John Doe");
        assertEquals("John Doe", clienteRequest.getNome());
    }

    @Test
    public void testGetAndSetCpf() {
        clienteRequest.setCpf("12345678901");
        assertEquals("12345678901", clienteRequest.getCpf());
    }

    @Test
    public void testGetAndSetCnpj() {
        clienteRequest.setCnpj("12345678901234");
        assertEquals("12345678901234", clienteRequest.getCnpj());
    }

    @Test
    public void testGetAndSetRazaoSocial() {
        clienteRequest.setRazaoSocial("Empresa ABC");
        assertEquals("Empresa ABC", clienteRequest.getRazaoSocial());
    }

    @Test
    public void testGetAndSetNomeContato() {
        clienteRequest.setNomeContato("Jane Doe");
        assertEquals("Jane Doe", clienteRequest.getNomeContato());
    }

    @Test
    public void testGetAndSetEmailContato() {
        clienteRequest.setEmailContato("jane@example.com");
        assertEquals("jane@example.com", clienteRequest.getEmailContato());
    }

    @Test
    public void testGetAndSetMcc() {
        clienteRequest.setMcc("1234");
        assertEquals("1234", clienteRequest.getMcc());
    }

    @Test
    public void testGetAndSetEmail() {
        clienteRequest.setEmail("john@example.com");
        assertEquals("john@example.com", clienteRequest.getEmail());
    }
}
