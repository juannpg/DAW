package vectores.actividades;

import entrada.Teclado;

import java.util.Arrays;
import java.util.Random;

public class A1x06B_FusionVectores {
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


    public static int[] fusionarIntercalado(int[] v, int[] w) {
        int[] result = new int[v.length + w.length];
        int i = 0, j = 0, k = 0;

        while (i < v.length && j < w.length) {
            result[k] = v[i];
            i++;
            k++;
            result[k] = w[j];
            j++;
            k++;
        }

        while (i < v.length) {
            result[k] = v[i];
            k++;
            i++;
        }

        while (j < w.length) {
            result[k] = w[j];
            k++;
            j++;
        }

        return result;
    }

    /**
     * crea dos vectores aleatorios, los rellena y luego los fusiona y los imprime.
     * @param args argumentos
     */
    public static void main(String[] args) {
        int capacidadA = Teclado.leerEntero("Capacidad del vector A: ");
        int capacidadB = Teclado.leerEntero("Capacidad del vector B: ");

        int[] vectorRandomA = crearVectorAleatorio(capacidadA, 1000, -1000);
        int[] vectorRandomB = crearVectorAleatorio(capacidadB, 1000, -1000);

        int[] fusionIntercalado = fusionarIntercalado(vectorRandomA, vectorRandomB);

        System.out.println("VECTOR A:");
        System.out.println(Arrays.toString(vectorRandomA));
        System.out.println("VECTOR B:");
        System.out.println(Arrays.toString(vectorRandomB));

        System.out.println("FUSION:");
        System.out.println(Arrays.toString(fusionIntercalado));
    }
}
