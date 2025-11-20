package com.ejercicio_2_2_cesar_chavez;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import static org.junit.jupiter.api.Assertions.*;

class CuentaBancariaTest {

    // CP-01: Happy Path
    @Test
    @DisplayName("CP-01: Cuenta válida de 10 dígitos retorna TRUE")
    @Tag("Critico") // JUnit permite etiquetas para prioridades
    void testCuentaValida() {
        assertTrue(CuentaBancaria.esCuentaValida("1234567890"));
    }

    // CP-02 y CP-03: Bordes de Longitud
    @Test
    @DisplayName("CP-02/03: Valida longitud exacta de 10 dígitos")
    @Tag("Critico")
    void testLongitudIncorrecta() {
        assertFalse(CuentaBancaria.esCuentaValida("123456789"), "9 dígitos debe ser falso");
        assertFalse(CuentaBancaria.esCuentaValida("12345678901"), "11 dígitos debe ser falso");
    }

    // CP-04 y CP-05: Contenido (Letras y Símbolos)
    @Test
    @DisplayName("CP-04/05: Solo acepta números, no letras ni símbolos")
    @Tag("Medio")
    void testContenidoInvalido() {
        assertFalse(CuentaBancaria.esCuentaValida("12345ABCDE"), "No debe aceptar letras");
        assertFalse(CuentaBancaria.esCuentaValida("12345-6789"), "No debe aceptar guiones");
    }

    // CP-06 y CP-07: Robustez (Nulos y Vacíos)
    @Test
    @DisplayName("CP-06/07: Manejo seguro de Nulos y Vacíos")
    @Tag("Critico")
    void testNulosYVacios() {
        assertFalse(CuentaBancaria.esCuentaValida(""), "Cadena vacía debe ser falso");
        assertFalse(CuentaBancaria.esCuentaValida(null), "Null no debe romper el programa, debe retornar falso");
    }

    // CP-08: Espacios
    @Test
    @DisplayName("CP-08: No debe aceptar espacios intermedios")
    @Tag("Bajo")
    void testEspacios() {
        assertFalse(CuentaBancaria.esCuentaValida("12345 6789"));
    }

    // CP-09: Regla de Negocio Especial
    @Test
    @DisplayName("CP-09: Acepta ceros a la izquierda")
    @Tag("Medio")
    void testCerosIzquierda() {
        assertTrue(CuentaBancaria.esCuentaValida("0000123456"));
    }
}