package procedimientos.actividades;
import java.util.Scanner;

public class A2x02_Rectangulo {
    /**
     * dibuja un rectangulo proporcionados su alto y su ancho
     * @param alto int, altura del rectangulo
     * @param ancho int, anchura del rectangulo
     */
    public static void dibujarRectangulo(int alto, int ancho) {
        for (int i = 1; i <= alto; i++) {
            for (int j = 1; j <= ancho; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * pide un numero de rectángulos por teclado, y por cada uno
     * pide su altura y anchura. Si el número es positivo, dibuja
     * el rectangulo. Si no, muestra un mensaje de error, hasta que
     * el usuario quiera salir.
     * @param args String[], argumentos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.print("¿Altura del rectangulo? ");
            int alto = sc.nextInt();
            System.out.print("¿Ancho del rectangulo? ");
            int ancho = sc.nextInt();

            boolean err = false;
            if (alto <= 0) {
                System.out.println("La altura del rectangulo debe ser positiva.");
                err = true;
            }

            if (ancho <= 0) {
                System.out.println("La anchura del rectangulo debe ser positiva.");
                err = true;
            }

            if (!err) {
                dibujarRectangulo(alto, ancho);
            }

            System.out.print("¿Desea procesar otro rectángulo (0 para salir)? ");
            opcion = sc.nextInt();
        } while (opcion > 0);
    }
}
