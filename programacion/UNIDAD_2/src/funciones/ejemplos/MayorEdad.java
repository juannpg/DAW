package funciones.ejemplos;
import java.util.Scanner;

public class MayorEdad {
    public static boolean esMayorEdad(int edad) {
        return edad >= 18;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos años tienes? ");
        int edad = sc.nextInt();
        sc.close();

        if (esMayorEdad(edad)) {
            System.out.print("Es mayor de edad");
        } else {
            System.out.print("No es mayor de edad");
        }
    }
}
