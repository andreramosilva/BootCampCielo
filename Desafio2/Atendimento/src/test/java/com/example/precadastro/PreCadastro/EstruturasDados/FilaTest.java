package com.example.precadastro.PreCadastro.EstruturasDados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaTest {

    private Fila<String> fila;

    @BeforeEach
    public void setUp() {
        fila = new Fila<>();
    }

    @Test
    public void testAdicionarERetirarElemento() {
        fila.adicionar("Cliente 1");
        fila.adicionar("Cliente 2");
        fila.adicionar("Cliente 3");

        assertEquals("Cliente 1", fila.retirar());
        assertEquals("Cliente 2", fila.retirar());
        assertEquals("Cliente 3", fila.retirar());
    }

    @Test
    public void testRetirarDeFilaVazia() {
        assertNull(fila.retirar());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(fila.isEmpty());
        fila.adicionar("Cliente");
        assertFalse(fila.isEmpty());
    }
}

