package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Ejercicio1 {


    public void ejercicio1(
            Double montoInicial,
            Double tasaAnual,
            int años
    ) {
        BigDecimal interesTotal = BigDecimal.valueOf(montoInicial)
                .multiply(BigDecimal.valueOf(años))
                .multiply(BigDecimal.valueOf(tasaAnual / 100));
        BigDecimal montoFinal = interesTotal.add(BigDecimal.valueOf(montoInicial));

        System.out.println("Monto final: " + montoFinal.setScale(2, BigDecimal.ROUND_HALF_UP)
                + "\nInteres total: " + interesTotal.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
