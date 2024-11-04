package caracteres.actividades;
import entrada.Teclado;

public class A2x01_MayusculasFrase {
    public static boolean esMayuscula(char c) {
        return c >= 65 && c <= 90;
    }

    public static void main(String[] args) {
        String frase = Teclado.leerCadena("Frase: ");

        if (frase.length() <= 0 || frase.length() > 60) {
            System.out.println("La frase no puede ser vacía ni más de 60 caracteres");
        } else {
            String mayusculas = "";
            String minusculas = "";
            int contadorMayus = 0, contadorMinus = 0;
            for (int i = 0; i < frase.length(); i++) {
                char c = frase.charAt(i);
                if (esMayuscula(c)) {
                    mayusculas += c;
                    contadorMayus++;
                } else {
                    minusculas += c;
                    contadorMinus++;
                }
            }
            System.out.println("Mayusculas: " + contadorMayus);
            System.out.println("Mayusculas: " + mayusculas);
            System.out.println("Minusculas: " + contadorMinus);
            System.out.println("Minusculas: " + minusculas);
        }
    }
}
