package vectores.actividades;

import java.util.Arrays;
import java.util.Random;
import entrada.Teclado;

public class A1x06_FusionVectores {
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
     * fusiona dos vectores.
     * @param v vector de enteros
     * @param w vector de enteros
     * @return vector de enteros fusionados
     */
    public static int[] fusionarVectores(int[] v, int[] w) {
        int[] result = new int[v.length + w.length];

        for (int i = 0; i < v.length; i++) {
            result[i] = v[i];
        }

        for (int i = 0; i < w.length; i++) {
            result[i + v.length] = w[i];
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

        System.out.println("VECTOR A:");
        System.out.println(Arrays.toString(vectorRandomA));
        System.out.println("VECTOR B:");
        System.out.println(Arrays.toString(vectorRandomB));

        int[] vectorFusionado = fusionarVectores(vectorRandomA, vectorRandomB);

        System.out.println("FUSION:");
        System.out.println(Arrays.toString(vectorFusionado));
    }
}
