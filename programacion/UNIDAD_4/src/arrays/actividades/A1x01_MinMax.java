package arrays.actividades;
import entrada.Teclado;

public class A1x01_MinMax {
    public static void leerVector(int[] v) {
        for (int i = 0; i < v.length; i++) {
            v[i] = Teclado.leerEntero("Numero entero " + (i + 1) + ": ");
        }
    }

    public static void imprimirVector(int[] v) {
        System.out.println("VECTOR:");
        System.out.print("[");
        for (int i = 0; i < v.length; i++) {
            System.out.print(v[i]);
            if (i != v.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int min(int[] v) {
        int min = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] < min) {
                min = v[i];
            }
        }
        return min;
    }

    public static int max(int[] v) {
        int max = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }
        return max;
    }

    public static int buscarPosicion(int[] v, int valor) {
        for (int i = 0; i < v.length; i++) {
            if (v[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numeros = new int[10];
        leerVector(numeros);

        imprimirVector(numeros);

        System.out.println("Mínimo: " + min(numeros));
        System.out.println("Primera posición del mínimo: " + buscarPosicion(numeros, min(numeros)));
        System.out.println("Máximo: " + max(numeros));
        System.out.println("Primera posición del máximo: " + buscarPosicion(numeros, max(numeros)));
    }
}