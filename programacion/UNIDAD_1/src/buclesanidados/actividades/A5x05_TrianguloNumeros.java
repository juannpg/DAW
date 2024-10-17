package buclesanidados.actividades;
import java.util.Scanner;

public class A5x05_TrianguloNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número límite del triángulo? ");
        int limit = sc.nextInt();
        sc.close();

        // este bucle crea las filas hasta el limite
        for (int i = 1; i <= limit; i++) {
            // este escribe los números de j a i, y escribe
            // i al ser el numero de linea
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
