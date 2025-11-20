package com.ejercicio_3_cesar_chavez;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cliente> cartera = new ArrayList<>();
        cartera.add(new Cliente(1, "César Chávez", 1500.50));
        cartera.add(new Cliente(2, "Ana Pérez", 5000.00)); // Ganadora
        cartera.add(new Cliente(3, "Luis Gómez", 100.00));

      
        GestionBanco gestor = new GestionBanco();

        Cliente ganador = gestor.encontrarClienteMasRico(cartera);

        System.out.println("--- Reporte Financiero ---");
        if (ganador != null) {
            System.out.println("El cliente con mayor patrimonio es:");
            System.out.println(ganador); // Usa el toString() automáticamente
        } else {
            System.out.println("No hay clientes en la lista.");
        }
    }
}