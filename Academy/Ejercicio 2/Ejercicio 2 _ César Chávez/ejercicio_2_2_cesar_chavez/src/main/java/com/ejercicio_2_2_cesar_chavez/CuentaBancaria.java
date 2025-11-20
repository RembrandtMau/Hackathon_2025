package com.ejercicio_2_2_cesar_chavez;


public class CuentaBancaria {
    private String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        if (!esCuentaValida(numeroCuenta)) {
            throw new IllegalArgumentException("Número de cuenta inválido: Debe tener 10 dígitos numéricos.");
        }
        
        this.numeroCuenta = numeroCuenta;
    }

    public static boolean esCuentaValida(String cuenta) {
        if (cuenta == null) {
            return false;
        }
        // Regex: \d{10} significa "exactamente 10 dígitos"
        return cuenta.matches("\\d{10}");
    }

    public String getNumeroCuenta() { return numeroCuenta; }
}