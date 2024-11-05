package caracteres.actividades;

import entrada.Teclado;

public class A2x10_NumeroPalabras {
    public static String leerFrase() {
        final int MAXIMO = 60, MINIMO = 10;

        String frase;
        do {
            frase = Teclado.leerCadena("¿Frase? ");
            if (frase.length() < MINIMO || frase.length() > MAXIMO) {
                System.out.println("La frase debe tener 10 caracteres como mínimo.\n" +
                        "La frase debe tener 60 caracteres como máximo.");
            }
        } while (frase.length() <= MINIMO || frase.length() > MAXIMO);

        return frase;
    }

    public static int contarPalabras(String frase) {
        frase = frase.trim();
        int contadorPalabras = 1;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                contadorPalabras++;
            }
        }
        return contadorPalabras;
    }

    public static void main(String[] args) {
        String frase = leerFrase();

        int numPalabras = contarPalabras(frase);
        System.out.println("La frase tiene " + numPalabras + " palabras.");
    }
}
