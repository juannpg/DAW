package arrays.actividades;

import java.util.Arrays;
import java.util.Random;

public class A1x04_RandomMedia {
    public static int[] crearVectorAleatorio(int longitud, int limiteSupRandom, int limiteInfRandom) {
        int[] v = new int[longitud];
        for (int i = 0; i < v.length; i++) {
            Random r = new Random();
            int random = r.nextInt(limiteSupRandom + limiteInfRandom + 1) - limiteInfRandom;

            v[i] = random;
        }

        return v;
    }

    public static float mediaVector(int[] v) {
        int media = 0;
        for (int i = 0; i < v.length; i++) {
            media += v[i];
        }

        return (float) media / v.length;
    }

    public static int inferioresMedia(int[] v, float x) {
        int contadorInferiores = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < x) {
                contadorInferiores++;
            }
        }
        return contadorInferiores;
    }

    public static int mayoresMedia(int[] v, float x) {
        int contadorMayores = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] > x) {
                contadorMayores++;
            }
        }
        return contadorMayores;
    }

    public static void main(String[] args) {
        final int LONGITUD = 15;

        int[] vectorRandom = crearVectorAleatorio(LONGITUD, 10, 10);

        float media = mediaVector(vectorRandom);
        int inferioresMedia = inferioresMedia(vectorRandom, media);
        int mayoresMedia = mayoresMedia(vectorRandom, media);
        int igualesMedia = LONGITUD - (inferioresMedia + mayoresMedia);

        System.out.println(Arrays.toString(vectorRandom));
        System.out.println("Media: " + media);
        System.out.println("Número de elementos inferiores a la media: " + inferioresMedia);
        System.out.println("Número de elementos iguales a la media: " + igualesMedia);
        System.out.println("Número de elementos mayores a la media: " + mayoresMedia);
    }
}
