package com.example.precadastro.PreCadastro.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ClienteFisicoTest {

    private ClienteFisico clienteFisico;

    @BeforeEach
    public void setUp() {
        clienteFisico = new ClienteFisico();
    }


    @Test
    public void testGetSetCpf() {
        assertNull(clienteFisico.getCpf());
        clienteFisico.setCpf("12345678901");
        assertEquals("12345678901", clienteFisico.getCpf());
    }

    @Test
    public void testGetSetMcc() {
        assertNull(clienteFisico.getMcc());
        clienteFisico.setMcc("1234");
        assertEquals("1234", clienteFisico.getMcc());
    }

    @Test
    public void testGetSetNome() {
        assertNull(clienteFisico.getNome());
        clienteFisico.setNome("John Doe");
        assertEquals("John Doe", clienteFisico.getNome());
    }

    @Test
    public void testGetSetEmail() {
        assertNull(clienteFisico.getEmail());
        clienteFisico.setEmail("john@example.com");
        assertEquals("john@example.com", clienteFisico.getEmail());
    }
}

