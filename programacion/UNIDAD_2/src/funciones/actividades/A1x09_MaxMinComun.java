package funciones.actividades;
import java.util.Scanner;

public class A1x09_MaxMinComun {
    public static int numeroMaximo(int num1, int num2) {
        // uno debe ser mayor ?
        return num1 > num2 ? num1 : num2;
    }

    public static int calcularMaximoComunDivisor(int num1, int num2) {
        int max = 0;
        for (int i = 1; i <= numeroMaximo(num1, num2); i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                max = i;
            }
        }
        return max;
    }

    public static int calcularMinimoComunMultiplo(int num1, int num2) {
        return (num1 * num2) / calcularMaximoComunDivisor(num1, num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Primer Número? ");
        int num1 = sc.nextInt();
        System.out.print("¿Segundo Número? ");
        int num2 = sc.nextInt();

        System.out.printf("Máximo Común Divisor de %d y %d: %d\n", num1, num2, calcularMaximoComunDivisor(num1, num2));
        System.out.printf("Mínimo Común Múltiplo de %d y %d: %d\n", num1, num2, calcularMinimoComunMultiplo(num1, num2));

        System.out.print("¿Continuar? (0 para salir): ");
        int num = sc.nextInt();
        while (num > 0) {
            System.out.print("¿Primer Número? ");
            num1 = sc.nextInt();
            System.out.print("¿Segundo Número? ");
            num2 = sc.nextInt();

            System.out.printf("Máximo Común Divisor de %d y %d: %d\n", num1, num2, calcularMaximoComunDivisor(num1, num2));
            System.out.printf("Mínimo Común Múltiplo de %d y %d: %d\n", num1, num2, calcularMinimoComunMultiplo(num1, num2));
        };
    }
}
