package funciones.actividades;
import java.util.Scanner;

public class A1x09_MaxMinComun {
    /**
     * devuelve el mayor de dos parametros enteros.
     * @param num1
     * @param num2
     * @return
     */
    public static int numeroMaximo(int num1, int num2) {
        // uno debe ser mayor ?
        return num1 > num2 ? num1 : num2;
    }

    /**
     * acepta dos parametros enteros y devuelve su max com divisor.
     * @param num1
     * @param num2
     * @return
     */
    public static int calcularMaximoComunDivisor(int num1, int num2) {
        int max = 0;
        for (int i = 1; i <= numeroMaximo(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                max = i;
            }
        }
        return max;
    }

    /**
     * acepta dos parametros enteros y devuelve su min com mult
     * @param num1
     * @param num2
     * @return
     */
    public static int calcularMinimoComunMultiplo(int num1, int num2) {
        return (num1 * num2) / calcularMaximoComunDivisor(num1, num2);
    }

    /**
     * va pidiendo pares de numeros, imprimiendo por consola su maximo comun multiplo y
     * su minimo comun divisor, hasta que el usuario salga escribiendo 0 o un numero negativo.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        do {
            System.out.print("¿Primer Número? ");
            int num1 = sc.nextInt();
            System.out.print("¿Segundo Número? ");
            int num2 = sc.nextInt();

            System.out.printf("Máximo Común Divisor de %d y %d: %d\n", num1, num2, calcularMaximoComunDivisor(num1, num2));
            System.out.printf("Mínimo Común Múltiplo de %d y %d: %d\n", num1, num2, calcularMinimoComunMultiplo(num1, num2));
            System.out.print("¿Continuar? (0 para salir): ");
            num = sc.nextInt();
        } while (num > 0);
    }
}
