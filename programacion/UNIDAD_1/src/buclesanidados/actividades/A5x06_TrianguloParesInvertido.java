package buclesanidados.actividades;
import java.util.Scanner;

public class A5x06_TrianguloParesInvertido {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número límite del triángulo? ");
        final int LIMIT = sc.nextInt();
        sc.close();

        if (LIMIT <= 0 || LIMIT % 2 != 0) {
            System.out.println("El número límite debe ser positivo y par.");
        } else {
            for (int i = LIMIT; i > 0; i -= 2) {
                for (int j = i; j > 0; j -= 2) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
}
