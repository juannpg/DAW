package vectores.actividades;
import entrada.Teclado;

public class A1x02_SumaVectores {
    /**
     * Añade los numeros insertados a un vector.
     * @param longitud longitud del vector
     * @return vector de enteros completo
     */
    public static int[] leerVector(int longitud) {
        int[] v = new int[longitud];
        for (int i = 0; i < v.length; i++) {
            v[i] = Teclado.leerEntero("Numero entero " + (i + 1) + ": ");
        }

        return v;
    }

    /**
     * imprime el vector con formato.
     * @param v vector de enteros
     * @param nomVector nombre del vector
     */
    public static void imprimirVector(int[] v, String nomVector) {
        System.out.println("VECTOR " + nomVector + ":");
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
     * suma dos vectores.
     * @param v vector de enteros
     * @param w vector de enteros
     * @return vector de enteros sumados
     */
    public static int[] sumaVectores(int[] v, int[] w) {
        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = v[i] + w[i];
        }

        return result;
    }

    /**
     * producto de dos vectores.
     * @param v vector de enteros
     * @param w vector de enteros
     * @return vector de enteros multiplicados
     */
    public static int[] productoVectores(int[] v, int[] w) {
        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = v[i] * w[i];
        }

        return result;
    }

    /**
     * crea dos vectores, los rellena y luego los suma, producto y imprime.
     * @param args argumentos
     */
    public static void main(String[] args) {
        int[] a = leerVector(10);
        int[] b = leerVector(10);

        imprimirVector(a, "A");
        imprimirVector(b, "B");

        imprimirVector(sumaVectores(a, b), "SUMA");
        imprimirVector(productoVectores(a, b), "PRODUCTO");
    }
}
