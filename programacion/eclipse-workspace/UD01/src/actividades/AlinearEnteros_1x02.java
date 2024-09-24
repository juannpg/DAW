package actividades;
import java.util.Scanner;

/*
 * Este programa pide tres numeros enteros
 * y los imprime alineados a la derecha
 * y a la izquierda
 */
public class AlinearEnteros_1x02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Entero A? ");
		int numero1 = teclado.nextInt();
		
		System.out.print("¿Número Entero B? ");
		int numero2 = teclado.nextInt();
		
		System.out.print("¿Número Entero C? ");
		int numero3 = teclado.nextInt();
		teclado.close();
		
		System.out.println("NUMEROS ALINEADOS POR LA DERECHA:");
		System.out.printf("A = %5d", numero1);

		System.out.printf("\nB = %5d", numero2);
		
		System.out.printf("\nC = %5d", numero3);
		
		System.out.println("\nNUMEROS ALINEADOS POR LA IZQUIERDA:");
		System.out.printf("A = %-5d", numero1);

		System.out.printf("\nB = %-5d", numero2);
		
		System.out.printf("\nC = %-5d", numero3);
	}
}
