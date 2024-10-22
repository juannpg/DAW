package procedimientos.actividades;
import java.util.Scanner;

public class A2x01_TablaMultiplicarNum {
    /**
     * escribe la tabla de multiplicar de un entero
     * @param num int, numero de la tabla
     */
    public static void escribirTablaMultiplicar(int num) {
        System.out.println("Tabla de multiplicar del número " + num);
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %2d\n", num, i, num * i);
        }
    }

    /**
     * pide un entero por teclado y llama al procedimiento
     * de escribir la tabla de multiplicar
     * @param args String[], argumentos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número? ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("El número debe ser positivo.");
        } else {
            escribirTablaMultiplicar(num);
        }
    }
}
