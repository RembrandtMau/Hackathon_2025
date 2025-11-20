import java.util.Scanner;
public class Ejercicio_2_Rembrandt {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa el número de cuenta: ");
        String numeroCuenta = lector.nextLine();

        boolean tieneDiezDigitos = numeroCuenta.length() == 10;
        boolean sonSoloNumeros = numeroCuenta.matches("[0-9]+");

        if (tieneDiezDigitos && sonSoloNumeros) {
            System.out.println("El número de cuenta es válido.");
        } else {
            System.out.println("El número de cuenta no es válido.");
        }
        
        lector.close();
    }
}