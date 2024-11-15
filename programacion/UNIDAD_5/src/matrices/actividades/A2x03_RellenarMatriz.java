package matrices.actividades;

import entrada.Teclado;

import java.util.Arrays;
import java.util.Random;

public class A2x03_RellenarMatriz {
    public static void escribirMatriz(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static int[][] generarMatrizAleatoria(int longitud, int limiteSupRandom, int limiteInfRandom) {
        int[][] m = new int[longitud][longitud];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                Random r = new Random();
                int random = r.nextInt(limiteSupRandom - limiteInfRandom - 1) + limiteInfRandom;

                m[i][j] = random;
            }
        }

        return m;
    }

    public static int leerFila(int numFila, int max) {
        int fila;
        do {
            fila = Teclado.leerEntero("¿Fila " + numFila + "? ");
            if (fila > max) {
                System.out.println("La fila debe estar comprendida entre 0 y 7");
            }
        } while (fila > max);

        return fila;
    }

    public static void cambiarFilas(int fila1, int fila2, int[][] m) {
        int[] aux = m[fila1];

        m[fila1] = m[fila2];
        m[fila2] = aux;
    }


    public static void main(String[] args) {
        int[][] matrizRandom = generarMatrizAleatoria(8, 100, 1);

        System.out.println("MATRIZ ANTES DE INTERCAMBIAR");
        escribirMatriz(matrizRandom);

        int fila1 = leerFila(1, 7);
        int fila2 = leerFila(2, 7);

        cambiarFilas(fila1, fila2, matrizRandom);

        System.out.println("MATRIZ DESPUES DE INTERCAMBIAR");
        escribirMatriz(matrizRandom);
    }
}
