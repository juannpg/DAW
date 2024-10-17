package bucles.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un numero natural positivo,
 * e imprime por consola la suma de los numeros naturales impartes
 * menores o iguales que él hasta 0.
 */
public class A4x08C_SumaImparesMenores {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Natural N? ");
		int num = teclado.nextInt();
		teclado.close();
		
		if (num <= 0) {
			System.out.print("El número natural N debe ser positivo.");
		} else {
			int suma = 0;
			
			for (int i = 1; i <= num; i += 2) {
				suma += i;
			}
			
			System.out.printf("Suma de Números Impares menores o iguales que %d: %d", num, suma);
		}
	}
}
