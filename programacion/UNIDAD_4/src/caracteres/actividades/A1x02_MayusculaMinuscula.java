package caracteres.actividades;
import java.util.Scanner;

public class A1x02_MayusculaMinuscula {
    public static boolean esMayuscula(char c) {
        return c >= 65 && c <= 90;
    }

    public static boolean esMinuscula(char c) {
        return c >= 97 && c <= 122;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Carácter? ");
        char c = sc.next().charAt(0);
        sc.close();

        if (esMayuscula(c)) {
            System.out.printf("El carácter %c es una letra mayúscula", c);
        } else if (esMinuscula(c)) {
            System.out.printf("El carácter %c es una letra minúscula", c);
        } else {
            System.out.printf("El carácter %c no es una letra", c);
        }
    }
}
