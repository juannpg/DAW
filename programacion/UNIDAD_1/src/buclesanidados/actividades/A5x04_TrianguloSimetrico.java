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
            // este bucle crea las filas
            for (int i = 1, numAsteriscos = 1; i <= dimension; i++, numAsteriscos += 2) {
                // este crea los espacios, que empiezan en dimension -1
                // para dejar espacio para el asterisco, y disminuyen
                // de uno en uno en cada fila
                for (int j = 0; j < dimension - i; j++) {
                    System.out.print(" ");
                }
                // este crea los asteriscos, que empiezan en 1 aumentan
                // de dos en dos en cada fila
                for (int k = 0; k < numAsteriscos; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
