package bucles.actividades;
import java.util.Scanner;

public class A4x09B_SumaParesEntreEnteros {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Entero A? ");
		int num1 = teclado.nextInt();
		System.out.print("¿Número Entero B? ");
		int num2 = teclado.nextInt();
		teclado.close();
		
		if (num1 > num2) {
			System.out.print("El número entero A debe ser menor o igual que el número entero B.");
		} else {
			int suma = 0, contador = num1;
			
			do {
				if (contador % 2 == 0) {
					suma += contador;
				}
				contador++;
			} while (contador <= num2);
			
			System.out.printf("Suma de Números Pares comprendidos entre %d y %d: %d", num1, num2, suma);
		}
	}
}