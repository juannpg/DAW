package vectores.actividades;

import entrada.Teclado;

import java.util.Arrays;
import java.util.Random;

public class A1x0X_ContieneMultiplo {
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
     * comprueba si algún valor del vector es múltiplo de un numero
     * @param multiplo numero multiplo
     * @param v vector de enteros
     * @return boolean
     */
    public static boolean contieneMultiplo(int multiplo, int[] v) {
        boolean contieneMultiplo = false;
        int i = 0;
        while (i < v.length && !contieneMultiplo) {
            if (v[i] % multiplo == 0) {
                contieneMultiplo = true;
            }
            i++;
        }

        return contieneMultiplo;
    }

    /**
     * Genera un vector de numeros aleatorios, pide un numero por teclado,
     * y comprueba si algun numero de ese vectore es multiplo del numero pedido
     * @param args argumentos
     */
    public static void main(String[] args) {
        final int LONGITUD = 10;
        int[] vectorRandom = crearVectorAleatorio(LONGITUD, 100, 1);

        int num = Teclado.leerEntero("Múltiplo: ");

        boolean contieneMultiplo = contieneMultiplo(num, vectorRandom);

        System.out.println("El vector");
        System.out.println(Arrays.toString(vectorRandom));
        if (contieneMultiplo) {
            System.out.println("contiene un múltiplo de " + num);
        } else {
            System.out.println("no contiene un múltiplo de " + num);
        }
    }
}
