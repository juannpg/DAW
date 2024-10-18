package buclesanidados.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un numero limite e imprime por consola un
 * triangulo con el numero de filas proporcionado y escribiendo en cada fila
 * su numero y la cantidad del numero de fila, pero empieza por el final y solo
 * imprime los numeros pares.
 */
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
                    System.out.printf("%2d ", j);
                }
                System.out.println();
            }
        }
    }
}
