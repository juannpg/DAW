package caracteres.actividades;
import java.util.Scanner;

public class A1x01_NumeroArabigo {
    public static boolean esNumeroArabigo(char c) {
        return c >= 48 && c <= 57;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Carácter? ");
        char c = sc.next().charAt(0);
        sc.close();

        if (esNumeroArabigo(c)) {
            System.out.printf("El carácter %c es un número arábigo", c);
        } else {
            System.out.printf("El carácter %c no es un número arábigo", c);
        }
    }
}
