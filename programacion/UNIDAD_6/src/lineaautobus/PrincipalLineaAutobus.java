package lineaautobus;

import java.util.Random;

public class PrincipalLineaAutobus {
    public static int[] generarVectorParadasAleatorio(int longitud, Random r) {
        int[] paradas = new int[longitud];

        for (int i = 0; i < 7; i++) {
            paradas[i] = r.nextInt(200 - 10 - 1) + 10;
        }

        return paradas;
    }

    public static LineaAutobus crearLineaAleatoria() {
        Random r = new Random();
        int numLineaInt = r.nextInt(60 - 20 - 1) + 20;
        String numLineaString = String.valueOf(numLineaInt);

        float precio = 1.40f;

        int frecuencia = r.nextInt(20 - 5 - 1) + 20;

        final int LONGITUD = 7;
        int[] paradas = generarVectorParadasAleatorio(7, r);

        return new LineaAutobus(numLineaString, precio, frecuencia, paradas);
    }
}
