package actividades;
import java.util.Scanner;

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
		System.out.print("A = ");
		System.out.printf("%5d", numero1);

		System.out.print("\nB = ");
		System.out.printf("%5d", numero2);
		
		System.out.print("\nC = ");
		System.out.printf("%5d", numero3);
		
		System.out.println("\nNUMEROS ALINEADOS POR LA IZQUIERDA:");
		System.out.print("A = ");
		System.out.printf("%-5d", numero1);

		System.out.print("\nB = ");
		System.out.printf("%-5d", numero2);
		
		System.out.print("\nC = ");
		System.out.printf("%-5d", numero3);
	}
}
