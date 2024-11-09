package vectores.actividades;
import java.util.Arrays;
import java.util.Random;

public class A1x03_VectorRandom {
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
     * contar el numero de elementos positivos en un vector.
     * @param v vector de enteros
     * @return numero de elementos positivos
     */
    public static int contarPositivos(int[] v) {
        int positivos = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > 0) {
                positivos++;
            }
        }

        return positivos;
    }

    /**
     * contar el numero de elementos negativos en un vector.
     * @param v vector de enteros
     * @return numero de elementos negativos
     */
    public static int contarNegativos(int[] v) {
        int negativos = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < 0) {
                negativos++;
            }
        }

        return negativos;
    }

    /**
     * crea un vector aleatorio, lo rellena y luego cuenta los elementos positivos, negativos y neutros.
     * @param args argumentos
     */
    public static void main(String[] args) {
        final int LONGITUD = 15;

        int[] vectorRandom = crearVectorAleatorio(LONGITUD, 100, -100);

        int positivos = contarPositivos(vectorRandom);
        int negativos = contarNegativos(vectorRandom);
        int neutros = LONGITUD - (positivos + negativos);

        System.out.println(Arrays.toString(vectorRandom));
        System.out.println("Número de elementos positivos: " + positivos);
        System.out.println("Número de elementos neutros: " + neutros);
        System.out.println("Número de elementos negativos: " + negativos);
    }
}
