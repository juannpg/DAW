package funciones.actividades;
import java.util.Scanner;

public class A1x05_NumDivisores {
    /*
     * calcula si un numero es divisor de otro y si es así lo
     * imprime por consola. además cuenta el numero de divisores
     * del número.
     */
    public static int contarNumerosDivisores(int num) {
        int numDivisores = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.printf("%d ", i);
                numDivisores++;
            }
        }
        System.out.println();
        return numDivisores;
    }

    /*
     * pide por teclado un número y devuelve por consola
     * todos sus divisores y su cantidad de divisores
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do {
            System.out.print("¿Número (0 para salir)? ");
            num = sc.nextInt();

            if (num > 0) {
                System.out.printf("El número %d tiene %d divisores.\n", num, contarNumerosDivisores(num));
            }
        } while (num > 0);
        sc.close();
    }
}
