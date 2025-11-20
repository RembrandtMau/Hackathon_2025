import java.util.Scanner;

public class Ejercicio_5_Rembrandt {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        double saldo = 10000.00;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n CAJERO AUTOMÁTICO ");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
            int opcion = lector.nextInt();

            switch (opcion) {
                case 1 -> System.out.println("Tu saldo actual es: $" + saldo);

                case 2 -> {
                    System.out.print("Cuánto desea depositar? ");
                    double deposito = lector.nextDouble();
                    if (deposito > 0) {
                        saldo += deposito;
                        System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                    } else {
                        System.out.println("Error: Cantidad inválida para depósito.");
                    }
                }

                case 3 -> {
                    System.out.print("¿Cuánto deseas retirar? ");
                    double retiro = lector.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("Error: Fondos insuficientes.");
                    } else if (retiro <= 0) {
                        System.out.println("Error: Cantidad inválida para retiro.");
                    } else {
                        saldo -= retiro; 
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                    }
                }

                case 4 -> {
                    System.out.println("Gracias por usar el cajero automático.");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }
            } catch (Exception e) {
                System.out.println("Opción no válida. Ingrese unicamente números.");
                lector.next(); 
            }
        }

        lector.close();
    }
}