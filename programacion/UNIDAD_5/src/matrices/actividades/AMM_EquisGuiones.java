package matrices.actividades;

import java.util.Arrays;
import java.util.Random;

public class AMM_EquisGuiones {
    public static void escribirMatriz(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static char[][] generarMatrizGuiones(int filas, int columnas) {
        char[][] m = new char[filas][columnas];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = '-';
            }
        }

        return m;
    }

    public static void ponerEquis(char[][] m, int numEquis) {
        Random r = new Random();
        int fila, columna;

        for (int i = 0; i < numEquis; i++) {
            do {
                fila = r.nextInt(m.length);
                columna = r.nextInt(m[0].length);
            } while (m[fila][columna] == 'x');

            m[fila][columna] = 'x';
        }
    }

    public static boolean estaVaciaFila(char v[]) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 'x') {
                return false;
            }
        }

        return true;
    }

    public static int buscarFilaVacia(char m[][]) {
        for (int i = 0; i < m.length; i++) {
            if (estaVaciaFila(m[i])) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] matrizGuiones = generarMatrizGuiones(4, 6);
        ponerEquis(matrizGuiones, 5);

        escribirMatriz(matrizGuiones);

        int filaVacia = buscarFilaVacia(matrizGuiones);

        if (filaVacia == -1) {
            System.out.println("No hay ninguna fila vacía");
        } else {
            System.out.println("La fila vacia es la número: " + filaVacia);
        }
    }
}
