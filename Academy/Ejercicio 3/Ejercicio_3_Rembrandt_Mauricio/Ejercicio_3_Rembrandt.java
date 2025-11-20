import java.util.ArrayList;
import java.util.List;

record Cliente(int id, String nombre, double saldo) {}

public class Ejercicio_3_Rembrandt {

    public static void main(String[] args) {
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(new Cliente(1, "Juan", 1000.30));
        listaClientes.add(new Cliente(2, "Jesus", 2000.50));
        listaClientes.add(new Cliente(3, "Pedro", 3000.50));

        Cliente clienteMasRico = listaClientes.get(0);

        for (Cliente clienteActual : listaClientes) {
            if (clienteActual.saldo() > clienteMasRico.saldo()) {
                clienteMasRico = clienteActual;
            }
        }
        System.out.println("El cliente con mayor saldo es: " + clienteMasRico.nombre());
        System.out.println("Saldo: " + clienteMasRico.saldo());
    }
}