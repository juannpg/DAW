package procedimientos.actividades;
import java.util.Scanner;

public class A2x04_MenuTriangulos {
    /**
     * dibua un triangulo de asteriscos alineado a la izquierda
     * en base a la altura
     * @param altura altura del triangulo
     */
    public static void trianguloIzquierda(int altura) {
        for (int i = 1; i <= altura; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * dibuja un triangulo de asteriscos alineado a la derecha
     * en base a la altura
     * @param altura altura del triangulo
     */
    public static void trianguloDerecha(int altura) {
        for (int i = 1; i <= altura; i++) {
            for (int j = altura - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * dibuja un triangulo de asteriscos simetrico en base a la altura
     * @param altura altura del triangulo
     */
    public static void trianguloCentrado(int altura) {
        for (int i = 1, numAsteriscos = 1; i <= altura; i++, numAsteriscos += 2) {
            for (int j = 0; j < altura - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < numAsteriscos; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * ofrece un menu de opciones:
     *  - salir del programa
     *  - triangulo a la izquierda
     *  - triangulo a la derecha
     *  - triangulo centrado
     *  y deja al usuario dibujar triangulos siempre y cuando sus
     *  escriba una opcion y altura validas, hasta que salga del programa
     * @param args argumentos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.print("\n(0) Salir del programa.\n" +
                    "(1) Dibujar un triángulo de asteriscos alineado a la izquierda.\n" +
                    "(2) Dibujar un triángulo de asteriscos alineado a la derecha.\n" +
                    "(3) Dibujar un triángulo de asteriscos centrado.\n" +
                    "¿Opción (0-3)? ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    break;
                case 1:
                case 2:
                case 3:
                    System.out.print("¿Altura? ");
                    int altura = sc.nextInt();
                    if (altura <= 0) {
                        System.out.println("La altura del triángulo debe ser positiva.");
                    } else {
                        switch (opcion) {
                            case 1:
                                trianguloIzquierda(altura);
                                break;
                            case 2:
                                trianguloDerecha(altura);
                                break;
                            case 3:
                                trianguloCentrado(altura);
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("La opción de menú debe estar comprendida entre 0 y 3.");
            }
        } while (opcion != 0);
    }
}
