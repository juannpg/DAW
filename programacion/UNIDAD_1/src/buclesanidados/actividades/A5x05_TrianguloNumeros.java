package buclesanidados.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un numero limite e imprime por consola un
 * triangulo con el numero de filas proporcionado y escribiendo en cada fila
 * su numero y la cantidad del numero de fila
 */
public class A5x05_TrianguloNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número límite del triángulo? ");
        final int LIMIT = sc.nextInt();
        sc.close();

        if (LIMIT <= 0) {
            System.out.println("El número límite debe ser positivo.");
        } else {
            // este bucle crea las filas hasta el LIMITe
            for (int i = 1; i <= LIMIT; i++) {
                // este escribe los números de j a i, y escribe
                // i al ser el numero de linea
                for (int j = 1; j <= i; j++) {
                    System.out.printf("%2d ",i);
                }
                System.out.println();
            }
        }
    }
}
