package buclesanidados.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado la altura del triangulo y lo imprime por consola
 */
public class A5x02_Triangulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Altura del Triángulo? ");
        int altura = teclado.nextInt();
        teclado.close();

        if (altura <= 0) {
            System.out.print("La altura del triangulo debe ser positiva.");
        } else {
            for (int i = 1; i <= altura; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
