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

        int j;
        for (int i = 0; i <= dimension; i++) {
            for (j = dimension - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
