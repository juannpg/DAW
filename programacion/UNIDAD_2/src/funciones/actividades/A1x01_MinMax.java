package funciones.actividades;
import java.util.Scanner;

public class A1x01_MinMax {
    /*
     * acepta tres enteros por parametros y devuelve el mínimo
     */
    public static int min(int a, int b, int c) {
        int min;

        if (a < b && a < c) {
            min = a;
        } else if (b < a && b < c) {
            min = b;
        } else {
            min = c;
        }

        return min;
    }

    /*
     * acepta tres enteros por parametros y devuelve el maximo
     */
    public static int max(int a, int b, int c) {
        int max;

        if (a > b && a > c) {
            max = a;
        } else if (b > a && b > c) {
            max = b;
        } else {
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
