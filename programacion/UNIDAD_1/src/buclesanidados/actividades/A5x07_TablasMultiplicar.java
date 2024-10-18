package buclesanidados.actividades;
import java.util.Scanner;

public class A5x07_TablasMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número A? ");
        final int A = sc.nextInt();
        System.out.print("¿Número B? ");
        final int B = sc.nextInt();
        sc.close();

        boolean err = false;

        if (A <= 0) {
            System.out.println("El número A debe ser positivo.");
            err = true;
        }

        if (B <= 0) {
            System.out.println("El número B debe ser positivo.");
            err = true;
        }

        if (B < A) {
            System.out.print("El número A debe ser menor o igual que el número B.");
            err = true;
        }

        if (!err) {
            for (int i = A; i <= B; i++) {
                System.out.println("TABLA DE MULTIPLICAR DEL NÚMERO " + i);
                for (int j = 1; j <= 10; j++) {
                    System.out.printf("%d x %d = %d\n", i, j, i * j);
                }
            }
        }
    }
}
