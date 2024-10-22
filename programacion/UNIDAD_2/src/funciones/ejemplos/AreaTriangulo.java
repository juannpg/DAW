package funciones.ejemplos;
import java.util.Scanner;

public class AreaTriangulo {
    /**
     * calcula la área de un triangulo
     * @param altura altura del triangulo
     * @param base base del triangulo
     * @return área del triangulo
     */
    public static double areaTriangulo(double altura, double base) {
        return (altura * base) / 2;
    }

    /*
     * pide por teclado la base y altura de un triangulo
     * para imprimir su area por consola
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿La altura del Triángulo? ");
        int altura = sc.nextInt();
        System.out.print("¿La base del Triángulo? ");
        int base = sc.nextInt();
        sc.close();

        System.out.println("La área del Triángulo es: " + areaTriangulo(altura, base));
    }
}
