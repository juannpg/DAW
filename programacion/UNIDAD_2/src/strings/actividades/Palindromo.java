package strings.actividades;

import java.util.Objects;

public class Palindromo {
    public static String invertir(String cadena) {
        String invertida = "";
        for (int i = cadena.length() - 1; i >= 0; i--) {
            invertida += cadena.charAt(i);
        }
        return invertida;
    }

    public static void main(String[] args) {
        String cadena = "Memem";

        if (invertir(cadena).equalsIgnoreCase(cadena)) {
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }
    }
}
