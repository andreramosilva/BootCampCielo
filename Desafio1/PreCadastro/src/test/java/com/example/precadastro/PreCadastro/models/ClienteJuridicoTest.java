package com.example.precadastro.PreCadastro.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteJuridicoTest {

    private ClienteJuridico clienteJuridico;

    @BeforeEach
    public void setUp() {
        clienteJuridico = new ClienteJuridico();
    }
    

    @Test
    public void testGetSetCnpj() {
        assertNull(clienteJuridico.getCnpj());
        clienteJuridico.setCnpj("12345678901234");
        assertEquals("12345678901234", clienteJuridico.getCnpj());
    }

    @Test
    public void testGetSetRazaoSocial() {
        assertNull(clienteJuridico.getRazaoSocial());
        clienteJuridico.setRazaoSocial("ABC Company");
        assertEquals("ABC Company", clienteJuridico.getRazaoSocial());
    }

    @Test
    public void testGetSetNomeContato() {
        assertNull(clienteJuridico.getNomeContato());
        clienteJuridico.setNomeContato("John Doe");
        assertEquals("John Doe", clienteJuridico.getNomeContato());
    }

    @Test
    public void testGetSetEmailContato() {
        assertNull(clienteJuridico.getEmailContato());
        clienteJuridico.setEmailContato("john@example.com");
        assertEquals("john@example.com", clienteJuridico.getEmailContato());
    }

    @Test
    public void testGetSetCpf() {
        assertNull(clienteJuridico.getCpf());
        clienteJuridico.setCpf("12345678901");
        assertEquals("12345678901", clienteJuridico.getCpf());
    }

    @Test
    public void testGetSetMcc() {
        assertNull(clienteJuridico.getMcc());
        clienteJuridico.setMcc("1234");
        assertEquals("1234", clienteJuridico.getMcc());
    }
}
