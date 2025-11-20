package com.ejercicio_3_1_cesar_chavez;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GestionBancoTest {

    GestionBanco gestor = new GestionBanco();

    // CP-01: Flujo Normal (Happy Path)
    @Test
    @DisplayName("CP-01: Debería encontrar al cliente más rico en una lista estándar")
    void testHappyPath() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "A", 100),
            new Cliente(2, "B", 500), // Este es el mayor
            new Cliente(3, "C", 200)
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);

        assertNotNull(resultado);
        assertEquals("B", resultado.getNombre());
        assertEquals(500, resultado.getSaldo());
    }

    // CP-02: Lista Vacía
    @Test
    @DisplayName("CP-02: Debería retornar null si la lista está vacía")
    void testListaVacia() {
        List<Cliente> listaVacia = new ArrayList<>();
        
        Cliente resultado = gestor.encontrarClienteMasRico(listaVacia);
        
        assertNull(resultado, "Una lista vacía no tiene cliente más rico");
    }

    // CP-03: Lista Nula
    @Test
    @DisplayName("CP-03: Debería manejar una lista null sin lanzar error")
    void testListaNula() {
        Cliente resultado = gestor.encontrarClienteMasRico(null);
        
        assertNull(resultado, "Si la lista es null, el sistema debe protegerse y devolver null");
    }

    // CP-04: Un Solo Cliente
    @Test
    @DisplayName("CP-04: Debería retornar el único cliente existente")
    void testUnicoCliente() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "Solitario", 350.0)
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);

        assertEquals("Solitario", resultado.getNombre());
        assertEquals(350.0, resultado.getSaldo());
    }

    // CP-05: Orden - Mayor al Inicio
    @Test
    @DisplayName("CP-05: Funciona cuando el mayor es el primero")
    void testMayorAlInicio() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "Ganador", 900),
            new Cliente(2, "B", 100),
            new Cliente(3, "C", 100)
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);
        assertEquals("Ganador", resultado.getNombre());
    }

    // CP-06: Orden - Mayor al Final
    @Test
    @DisplayName("CP-06: Funciona cuando el mayor es el último")
    void testMayorAlFinal() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "A", 100),
            new Cliente(2, "B", 100),
            new Cliente(3, "Ganador", 900)
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);
        assertEquals("Ganador", resultado.getNombre());
    }

    // CP-07: Empate de Saldos
    // Regla de negocio: Gana el primero que aparezca en la lista
    @Test
    @DisplayName("CP-07: En caso de empate, retorna el primero encontrado")
    void testEmpateSaldos() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "Primero", 500), // Mismo saldo
            new Cliente(2, "Segundo", 500)  // Mismo saldo
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);

        assertEquals("Primero", resultado.getNombre());
    }

    // CP-08: Saldos Negativos
    @Test
    @DisplayName("CP-08: Funciona correctamente con deudas (saldos negativos)")
    void testSaldosNegativos() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "Deudor Grande", -500),
            new Cliente(2, "Deudor Pequeño", -50) // -50 es mayor que -500
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);

        assertEquals("Deudor Pequeño", resultado.getNombre());
        assertEquals(-50.0, resultado.getSaldo());
    }

    // CP-09: Saldos Cero
    @Test
    @DisplayName("CP-09: Funciona con saldos en cero")
    void testSaldosCero() {
        List<Cliente> lista = Arrays.asList(
            new Cliente(1, "Neutro", 0.0),
            new Cliente(2, "Deudor", -100.0)
        );

        Cliente resultado = gestor.encontrarClienteMasRico(lista);
        assertEquals("Neutro", resultado.getNombre());
        assertEquals(0.0, resultado.getSaldo());
    }
}