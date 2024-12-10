package lineaautobus;

import java.util.Random;

public class PrincipalLineaAutobus {
    public static int[] generarVectorParadasAleatorio(int longitud, Random r) {
        int[] paradas = new int[longitud];

        for (int i = 0; i < longitud; i++) {
            boolean repetido = false;
            for (int j = 0; j < i && !repetido; j++) {
                int paradaRandom = r.nextInt(200 - 10 + 1) + 10;

                if (paradas[j] == paradaRandom) {
                    i--;
                    repetido = true;
                } else {
                    paradas[i] = paradaRandom;
                }
            }
        }

        return paradas;
    }

    public static LineaAutobus crearLineaAleatoria() {
        Random r = new Random();
        int numLineaInt = r.nextInt(60 - 20 + 1) + 20;
        String numLineaString = String.valueOf(numLineaInt);

        float precio = 1.40f;

        int frecuencia = r.nextInt(20 - 5 + 1) + 5;

        final int LONGITUD = 7;
        int[] paradas = generarVectorParadasAleatorio(LONGITUD, r);

        return new LineaAutobus(numLineaString, precio, frecuencia, paradas);
    }
}
