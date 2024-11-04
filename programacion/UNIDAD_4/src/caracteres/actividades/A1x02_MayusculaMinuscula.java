package caracteres.actividades;
import entrada.Teclado;

public class A1x02_MayusculaMinuscula {
    public static boolean esMayuscula(char c) {
        return c >= 65 && c <= 90;
    }

    public static boolean esMinuscula(char c) {
        return c >= 97 && c <= 122;
    }

    public static void main(String[] args) {
        char c = Teclado.leerCaracter("¿Carácter? ");

        if (esMayuscula(c)) {
            System.out.printf("El carácter %c es una letra mayúscula", c);
        } else if (esMinuscula(c)) {
            System.out.printf("El carácter %c es una letra minúscula", c);
        } else {
            System.out.printf("El carácter %c no es una letra", c);
        }
    }
}
