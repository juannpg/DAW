package caracteres.actividades;
import entrada.Teclado;

public class A1x01_NumeroArabigo {
    public static boolean esNumeroArabigo(char c) {
        return c >= 48 && c <= 57;
    }

    public static void main(String[] args) {
        char c = Teclado.leerCaracter("¿Carácter? ");

        if (esNumeroArabigo(c)) {
            System.out.printf("El carácter %c es un número arábigo", c);
        } else {
            System.out.printf("El carácter %c no es un número arábigo", c);
        }
    }
}
