package caracteres.actividades;
import entrada.Teclado;

import java.util.Objects;

public class A2x11_Palindromo {
    public static int contarEspacios(String frase) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                contador++;
            }
        }
        return contador;
    }

    public static String leerPalabra() {
        String palabra;
        do {
            palabra = Teclado.leerCadena("¿Palabra? ").trim();
            if (contarEspacios(palabra) != 0) {
                System.out.println("La palabra no puede tener espacios");
            }
        } while (contarEspacios(palabra) != 0);

        return palabra;
    }

    public static String invertirPalabra(String palabra) {
        String invertida = "";
        for (int i = palabra.length() - 1; i >= 0; i--) {
            invertida += palabra.charAt(i);
        }
        return invertida;
    }

    public static void main(String[] args) {
        String palabra = leerPalabra();

        if (Objects.equals(palabra, invertirPalabra(palabra))) {
            System.out.println("La palabra " + palabra + " es un palíndromo.");
        } else {
            System.out.println("La palabra " + palabra + " no es un palíndromo.");
        }
    }
}
