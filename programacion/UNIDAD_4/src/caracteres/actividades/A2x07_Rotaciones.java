package caracteres.actividades;
import entrada.Teclado;

public class A2x07_Rotaciones {
    public static String leerFrase() {
        final int MAXIMO = 40;
        final int MINIMO = 2;

        String frase;
        do {
            frase = Teclado.leerCadena("¿Frase? ");
            if (frase.length() < MINIMO || frase.length() > MAXIMO) {
                System.out.println("La frase debe tener 5 caracteres como mínimo.\n" +
                        "La frase debe tener 40 caracteres como máximo.");
            }
        } while (frase.length() <= MINIMO || frase.length() > MAXIMO);

        return frase;
    }

    public static void rotarDerecha(String frase) {
        System.out.println("rotaciones a la derecha");

        for (int i = 0; i < frase.length(); i++) {
            System.out.println(frase);
            frase = frase.charAt(frase.length() - 1) + frase.substring(0, frase.length() - 1);
        }
    }

    public static void rotarIzquierda(String frase) {
        System.out.println("rotaciones a la izquierda");

        for (int i = 0; i < frase.length(); i++) {
            System.out.println(frase);
            frase = frase.substring(1, frase.length()) + frase.charAt(0);
        }
    }

    public static void main(String[] args) {
        String frase = leerFrase();

        rotarDerecha(frase);
        rotarIzquierda(frase);
    }
}
