package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un numero
 * entero, y dependiendo de su signo imprime
 * si es positivo, negativo o neutro
 */
public class SignoEntero_2x02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Número entero: ");
		double num = teclado.nextDouble();
		
		if (num > 0) {
			System.out.printf("El número %f es positivo", num);
		} else if (num < 0) {
			System.out.printf("El número %f es negativo", num);	
		} else {
			System.out.printf("El número %f es neutro", num);
		}
	}
}
