package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un año
 * si es menor que 1583 devuelve error
 * si es o no bisiesto, imprime por consola que lo es o no
 */
public class Bisiesto_3x01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Año? ");
		int year = teclado.nextInt();
		teclado.close();
		
		if (year < 1583) {
			System.out.print("El año debe ser mayor o igual que 1583.");
		} else if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			System.out.printf("El año %d es bisiesto.", year);
		} else {
			System.out.printf("El año %d no es bisiesto.", year);
		}
	}
}
