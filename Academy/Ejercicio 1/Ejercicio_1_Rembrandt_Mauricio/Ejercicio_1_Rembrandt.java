package Ejercicio_1_Rembrandt_Mauricio;
import java.util.Scanner;

public class Ejercicio_1_Rembrandt {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa el monto inicial: ");
        double montoInicial = lector.nextDouble();

        System.out.print("Ingresa la tasa de interés anual (%): ");
        double tasaInteres = lector.nextDouble();

        System.out.print("Ingresa el número de años: ");
        int anios = lector.nextInt();

        double interesTotal = (montoInicial * tasaInteres * anios) / 100;
        double montoFinal = montoInicial + interesTotal;

        System.out.println("El interés total es: " + interesTotal);
        System.out.println("El monto final es: " + montoFinal);

        lector.close();
    }
}