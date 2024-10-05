package bucles.actividades;
import java.util.Scanner;

public class A4x08A_SumaImparesMenores {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Natural N? ");
		int num = teclado.nextInt();
		teclado.close();
		
		if (num <= 0) {
			System.out.print("El número natural N debe ser positivo.");
		} else {
			int suma = 0, contador = num;
			
			while (contador > 0) {
				if (contador % 2 != 0) {
					suma += contador;
				}
				contador--;
			}
			
			System.out.printf("Suma de Números Impares menores o iguales que %d: %d", num, suma);
		}
	}
}
