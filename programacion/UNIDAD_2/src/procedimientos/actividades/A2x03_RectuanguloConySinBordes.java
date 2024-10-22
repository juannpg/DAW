package procedimientos.actividades;
import java.util.Scanner;

public class A2x03_RectuanguloConySinBordes {
    /**
     * dibuja un rectangulo dependiendo de su altura y anchura,
     * y de si se desea imprimir el interior o solo el borde
     * @param alto altura del rectangulo
     * @param ancho anchura del rectangulo
     * @param interior si se desea imprimir el interior o solo el borde
     */
    public static void dibujarRectangulo(int alto, int ancho, boolean interior) {
        for (int i = 1; i <= alto; i++) {
            for (int j = 1; j <= ancho; j++) {
                /*
                 si interior es true, o si el punto es el primer o último/primero
                 de cada fila o columna, imprime un asterisco, sino
                 imprime un espacio. Así, siempre que el modo es interior, tenemos
                 el rectangulo completo, y cuando interior es false, comprueba
                 cada una de las posiciones del rectangulo, para imprimir o
                 un espacio o un asterisco.
                */
                if (interior || (i == 1 || i == alto || j == 1 || j == ancho)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * pide la altura y anchura de un rectangulo por teclado, y
     * dibuja el rectangulo con y sin bordes.
     * @param args argumentos
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
                System.out.println("RECTANGULO CON BORDES E INTERIOR");
                dibujarRectangulo(alto, ancho, true);

                System.out.println("RECTANGULO SOLO CON BORDES");
                dibujarRectangulo(alto, ancho, false);
            }

            System.out.print("¿Desea procesar otro rectángulo (0 para salir)? ");
            opcion = sc.nextInt();
        } while (opcion > 0);
    }
}
