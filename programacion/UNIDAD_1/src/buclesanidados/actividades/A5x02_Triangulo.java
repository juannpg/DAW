package buclesanidados.actividades;
import java.util.Scanner;

public class A5x02_Triangulo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Altura del Triángulo? ");
        int altura = teclado.nextInt();
        teclado.close();

        for (int i = altura++; i > 0; i--) {
            for (int j = 0; j < altura - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
