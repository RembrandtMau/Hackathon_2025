import java.util.Scanner;

public class Ejercicio1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double monto = 0;
        double tasa = 0;
        int años = 0;

        try {
            while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(null, "Monto inicial:", "Interés Simple", javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (input == null) return; 
            input = input.trim();
            try {
                monto = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ingresa un número válido para el monto.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (monto < 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "El monto no puede ser negativo.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
            }
            while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(null, "Tasa de interés anual (%):", "Interés Simple", javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            input = input.trim();
            try {
                tasa = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ingresa un número válido para la tasa.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (tasa < 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "La tasa no puede ser negativa.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
            }
            while (true) {
            String input = javax.swing.JOptionPane.showInputDialog(null, "Número de años:", "Interés Simple", javax.swing.JOptionPane.QUESTION_MESSAGE);
            if (input == null) return;
            input = input.trim();
            try {
                años = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(null, "Ingresa un número entero válido para los años.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            if (años < 0) {
                javax.swing.JOptionPane.showMessageDialog(null, "Los años no pueden ser negativos.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                continue;
            }
            break;
            }
            double interes = monto * (tasa / 100) * años;
            double montoFinal = monto + interes;

            String resultado = String.format("Interés total: %,.2f\nMonto final: %,.2f", interes, montoFinal);
            javax.swing.JOptionPane.showMessageDialog(null, resultado, "Resultados", javax.swing.JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        double interes = monto * (tasa / 100) * años;
        double montoFinal = monto + interes;

        System.out.println("Interés total: " + interes);
        System.out.println("Monto final: " + montoFinal);

        sc.close();
    }
}
