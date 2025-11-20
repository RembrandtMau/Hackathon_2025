package com.ejercicio_3_cesar_chavez;

import java.util.List;

public class GestionBanco {

    public Cliente encontrarClienteMasRico(List<Cliente> clientes) {
        // Validación de seguridad
        if (clientes == null || clientes.isEmpty()) {
            return null;
        }

        Cliente masRico = clientes.get(0);

        for (Cliente actual : clientes) {
            if (actual.getSaldo() > masRico.getSaldo()) {
                masRico = actual;
            }
        }
        return masRico;
    }
}