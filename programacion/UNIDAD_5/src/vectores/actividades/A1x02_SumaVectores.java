package vectores.actividades;
import entrada.Teclado;

public class A1x02_SumaVectores {
    public static int[] leerVector(int longitud) {
        int[] v = new int[longitud];
        for (int i = 0; i < v.length; i++) {
            v[i] = Teclado.leerEntero("Numero entero " + (i + 1) + ": ");
        }

        return v;
    }

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

    public static int[] sumaVectores(int[] v, int[] w) {
        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = v[i] + w[i];
        }

        return result;
    }

    public static int[] productoVectores(int[] v, int[] w) {
        int[] result = new int[10];

        for (int i = 0; i < result.length; i++) {
            result[i] = v[i] * w[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = leerVector(10);
        int[] b = leerVector(10);

        imprimirVector(a, "A");
        imprimirVector(b, "B");

        imprimirVector(sumaVectores(a, b), "SUMA");
        imprimirVector(productoVectores(a, b), "PRODUCTO");
    }
}
