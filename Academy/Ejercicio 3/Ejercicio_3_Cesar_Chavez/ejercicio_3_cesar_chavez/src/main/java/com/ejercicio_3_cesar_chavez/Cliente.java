package com.ejercicio_3_cesar_chavez;

class Cliente {
    private int id;
    private String nombre;
    private double saldo;

    public Cliente(int id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente {ID=" + id + ", Nombre='" + nombre + "', Saldo=$" + saldo + "}";
    }
}