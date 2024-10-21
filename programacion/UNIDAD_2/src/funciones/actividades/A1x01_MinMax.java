package funciones.actividades;
import java.util.Scanner;

public class A1x01_MinMax {
    /*
     * acepta tres enteros por parametros y devuelve el mínimo
     */
    public static int min(int a, int b, int c) {
        int min = a;

        if (b < min) {
            min = b;
        }

        if (c < min) {
            min = c;
        }

        return min;
    }

    /*
     * acepta tres enteros por parametros y devuelve el maximo
     */
    public static int max(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    /*
     * pide tresn numeros por teclado e imrpime el minimo y el maximo
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número Entero A? ");
        int a = sc.nextInt();
        System.out.print("¿Número Entero B? ");
        int b = sc.nextInt();
        System.out.print("¿Número Entero C? ");
        int c = sc.nextInt();
        sc.close();

        System.out.println("Mínimo: " + min(a, b, c));
        System.out.println("Máximo: " + max(a, b, c));
    }
}
