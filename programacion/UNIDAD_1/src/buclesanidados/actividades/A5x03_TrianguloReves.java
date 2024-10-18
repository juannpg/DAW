package buclesanidados.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado la altura del triangulo y lo imprime por consola, pero alineado a la derecha
 */
public class A5x03_TrianguloReves {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Altura del Triángulo? ");
        int dimension = teclado.nextInt();
        teclado.close();

        if (dimension <= 0) {
            System.out.print("La altura del triangulo debe ser positiva.");
        } else {
            for (int i = 1; i <= dimension; i++) {
                for (int j = dimension - i; j > 0; j--) {
                    System.out.print(" ");
                }
                for (int k = 0; k < i; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
