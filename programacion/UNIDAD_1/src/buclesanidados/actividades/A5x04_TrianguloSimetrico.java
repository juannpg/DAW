package buclesanidados.actividades;
import java.util.Scanner;

public class A5x04_TrianguloSimetrico {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Altura del Triángulo? ");
        int dimension = teclado.nextInt();
        teclado.close();

        if (dimension <= 0) {
            System.out.print("La altura del Triángulo debe ser positiva");
        } else {
            for (int i = 0; i < dimension - 1; i++) {
                System.out.print(" ");
                for (int j = 0; j < dimension - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
