package funciones.actividades;
import java.util.Scanner;

public class A1x10_CuotaEstacionamiento {
    /**
     * acepta un parametro de tipo double y según
     * las condiciones del ejercicio devuelve
     * el cargo del estacionamiento
     * @param tiempo
     * @return
     */
    public static double calcularCargoPorEstacionar(double tiempo) {
        double cargo = 2;

        if (tiempo > 3) {
            for (double i = tiempo; i > 3; i--) {
                cargo += 0.50;
            }
        }

        return cargo;
    }

    /**
     * pide un numero de conductores, y por cada conductor pide
     * el número de horas que ha estado estacionado. Si el número está entre
     * 0 y 24, imprime por consola su cargo. Si no, imprime un error.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número de conductores? ");
        int numConductores = sc.nextInt();

        for (int i = 1; i <= numConductores; i++) {
            System.out.printf("CONDUCTOR %d\n", i);
            System.out.print("¿Tiempo en horas? ");
            double tiempo = sc.nextDouble();

            if (tiempo <= 0 || tiempo > 24) {
                System.out.println("El tiempo debe estar comprendido entre 0 y 24 horas.");
            } else {
                System.out.printf("Cargo por estacionar: %.2f euros\n", calcularCargoPorEstacionar(tiempo));
            }
        }
    }
}
