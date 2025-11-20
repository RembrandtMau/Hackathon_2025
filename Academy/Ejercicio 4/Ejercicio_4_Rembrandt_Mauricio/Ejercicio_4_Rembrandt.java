import java.util.ArrayList;
import java.util.List;

record Transaccion(String tipo, double monto, String fecha) {}

public class Ejercicio_4_Rembrandt {

    public static void main(String[] args) {
        List<Transaccion> historial = new ArrayList<>();

        historial.add(new Transaccion("Deposito", 3000.00, "01/01/2025"));
        historial.add(new Transaccion("Retiro", 1500.00, "02/02/2025"));
        historial.add(new Transaccion("Deposito", 2000.00, "03/03/2025"));
        historial.add(new Transaccion("Retiro", 500.00, "04/04/2025"));

        double totalDepositos= 0;
        double totalRetiros = 0;

        for (Transaccion actual : historial) {
            if (actual.tipo().equalsIgnoreCase("Deposito")){
                totalDepositos += actual.monto();
            } else if (actual.tipo().equalsIgnoreCase("Retiro")){
                totalRetiros += actual.monto();

            }
        }
        System.out.println("Total depositado: " + totalDepositos);
        System.out.println("Total retirado: " + totalRetiros);
        System.out.println("Balance final: " + (totalDepositos - totalRetiros));
    }
}