package arrays.actividades;

import java.util.Arrays;
import java.util.Random;

public class A1x03_VectorRandom {
    public static int[] crearVectorAleatorio(int longitud, int limiteSupRandom, int limiteInfRandom) {
        int[] v = new int[longitud];
        for (int i = 0; i < v.length; i++) {
            Random r = new Random();
            int random = r.nextInt(limiteSupRandom + limiteInfRandom + 1) - limiteInfRandom;

            v[i] = random;
        }

        return v;
    }

    public static int contarPositivos(int[] v) {
        int positivos = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > 0) {
                positivos++;
            }
        }

        return positivos;
    }

    public static int contarNegativos(int[] v) {
        int negativos = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < 0) {
                negativos++;
            }
        }

        return negativos;
    }

    public static void main(String[] args) {
        final int LONGITUD = 15;

        int[] vectorRandom = crearVectorAleatorio(LONGITUD, 100, 100);

        int positivos = contarPositivos(vectorRandom);
        int negativos = contarNegativos(vectorRandom);
        int neutros = LONGITUD - (positivos + negativos);

        System.out.println(Arrays.toString(vectorRandom));
        System.out.println("Número de elementos positivos: " + positivos);
        System.out.println("Número de elementos neutros: " + neutros);
        System.out.println("Número de elementos negativos: " + negativos);
    }
}
