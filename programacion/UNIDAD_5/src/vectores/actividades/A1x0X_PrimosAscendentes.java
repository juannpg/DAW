package vectores.actividades;

import entrada.Teclado;

import java.util.Arrays;
import java.util.Random;

public class A1x0X_PrimosAscendentes {
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

    public static boolean esPrimo(int num) {
        int divisores = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisores++;
            }
        }
        return divisores == 2;
    }
    
    /**
     * comprueba si algún valor del vector es múltiplo de un numero
     * @param v vector de enteros
     * @return boolean
     */
    public static int[] generarVectorPrimos(int[] v) {
        int[] primos = new int[20];

        int i = 0;
        while (i < v.length) {
            if(esPrimo(v[i])) {
                primos[i] = v[i];
            }
            i++;
        }

        return primos;
    }

    public static void main(String[] args) {
        final int LONGITUD = 20;
        int[] vectorRandom = crearVectorAleatorio(LONGITUD, 100, 1);

        System.out.println("Vector random: ");
        System.out.println(Arrays.toString(vectorRandom));

        int[] primos = generarVectorPrimos(vectorRandom);
        Arrays.sort(primos);
        System.out.println(Arrays.toString(primos));
    }
}
