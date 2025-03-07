package vectores.actividades;
import entrada.Teclado;

public class A1x01_MinMax {
    /**
     * Añade los numeros insertados a un vector.
     * @param v vector de enteros
     */
    public static void leerVector(int[] v) {
        for (int i = 0; i < v.length; i++) {
            v[i] = Teclado.leerEntero("Numero entero " + (i + 1) + ": ");
        }
    }

    /**
     * imprime el vector con formato.
     * @param v vector de enteros
     */
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

    /**
     * calcula el minimo, su posicion, maxio y su posicion de un vector y los devuelve en otro.
     * @param v vector de enteros
     * @return vector con los resultados
     */
    public static int[] calcular(int[] v) {
        int[] result = new int[4];
        result[0] = v[0];
        result[1] = 0;
        result[2] = v[0];
        result[3] = 0;

        for (int i = 1; i < v.length; i++) {
            if (v[i] < result[0]) {
                result[0] = v[i];
                result[1] = i;
            } else if (v[i] > result[2]) {
                result[2] = v[i];
                result[3] = i;
            }
        }

        return result;
    }

    /**
     * crea un vector de numeros, los rellena y luego calcula el minimo, su posicion, maxio y su posicion.
     * @param args argumentos
     */
    public static void main(String[] args) {
        int[] numeros = new int[10];
        leerVector(numeros);

        imprimirVector(numeros);

        System.out.println("Mínimo: " + calcular(numeros)[0]);
        System.out.println("Primera posición del mínimo: " + calcular(numeros)[1]);
        System.out.println("Máximo: " + calcular(numeros)[2]);
        System.out.println("Primera posición del máximo: " + calcular(numeros)[3]);
    }
}