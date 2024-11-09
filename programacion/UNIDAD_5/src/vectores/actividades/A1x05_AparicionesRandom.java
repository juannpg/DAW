package vectores.actividades;

import java.util.Arrays;
import java.util.Random;

public class A1x05_AparicionesRandom {
    /**
     * crea un vector aleatorio de enteros.
     * @param longitud longitud del vector
     * @param limiteSupRandom numero maximo aleatorio
     * @param limiteInfRandom numero minimo aleatorio
     * @return vector de enteros aleatorios
     */
    public static int[] crearVectorAleatorio(int longitud, int limiteSupRandom, int limiteInfRandom) {
        int[] v = new int[longitud];
        for (int i = 0; i < v.length; i++) {
            Random r = new Random();
            int random = r.nextInt(limiteSupRandom - limiteInfRandom - 1) + limiteInfRandom;

            v[i] = random;
        }

        return v;
    }

    /**
     * cuenta el numero de apariciones de cada elemento de un vector en otro y lo imprime.
     * @param v vector de enteros
     * @param w vector de enteros
     */
    public static void apariciones(int[] v, int[] w) {
        for (int i = 0; i < v.length; i++) {
            int contadorApariciones = 0;
            for (int j = 0; j < w.length; j++) {
                if (v[i] == w[j]) {
                    contadorApariciones++;
                }
            }
            System.out.printf("El elemento en la posicion %d del vector A aparece %d veces en el vector B\n", i, contadorApariciones);
        }
    }

    /**
     * crea dos vectores aleatorios, los rellena y luego cuenta las apariciones de cada elemento de un vector en otro.
     * @param args argumentos
     */
    public static void main(String[] args) {
        final int LONGITUD = 8;

        int[] vectorRandomA = crearVectorAleatorio(LONGITUD, 5, 1);
        int[] vectorRandomB = crearVectorAleatorio(LONGITUD, 5, 1);

        System.out.println("VECTOR A:");
        System.out.println(Arrays.toString(vectorRandomA));
        System.out.println("VECTOR B:");
        System.out.println(Arrays.toString(vectorRandomB));

        apariciones(vectorRandomA, vectorRandomB);
    }
}
