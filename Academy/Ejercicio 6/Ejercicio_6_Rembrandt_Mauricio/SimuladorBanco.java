class Cuenta {
    private double saldo;
    private static final Object lock = new Object();

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public synchronized double consultar() {
        return saldo;
    }

    public synchronized void depositar(double monto) {
        saldo += monto;
    }

    public synchronized void retirar(double monto) {
        saldo -= monto;
    }

    public void transferir(Cuenta destino, double monto) {
        synchronized (lock) {
            if (saldo >= monto) {
                this.saldo -= monto;
                destino.depositar(monto);
            }
        }
    }
}

class HiloTransferencia implements Runnable {
    Cuenta origen;
    Cuenta destino;
    double monto;

    public HiloTransferencia(Cuenta origen, Cuenta destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            origen.transferir(destino, monto);
        }
    }
}

public class SimuladorBanco {
    public static void main(String[] args) {
        Cuenta cuentaA = new Cuenta(20000.00);
        Cuenta cuentaB = new Cuenta(20000.00);

        System.out.println("--- Inicio ---");
        System.out.println("Saldo A: " + cuentaA.consultar());
        System.out.println("Saldo B: " + cuentaB.consultar());
        System.out.println("Total Dinero: " + (cuentaA.consultar() + cuentaB.consultar()));

        Thread hilo1 = new Thread(new HiloTransferencia(cuentaA, cuentaB, 10));
        Thread hilo2 = new Thread(new HiloTransferencia(cuentaB, cuentaA, 10));

        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Final ---");
        System.out.println("Saldo A: " + cuentaA.consultar());
        System.out.println("Saldo B: " + cuentaB.consultar());
        System.out.println("Total Dinero: " + (cuentaA.consultar() + cuentaB.consultar()));
    }
}