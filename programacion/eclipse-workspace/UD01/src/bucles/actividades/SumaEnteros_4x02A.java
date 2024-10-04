package bucles.actividades;
import java.util.Scanner;

public class SumaEnteros_4x02A {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num = 0;
		int suma = 0;
		
		while (num > 5 || num < 1) {
			System.out.print("¿Número entero? (entre 1 y 5 para salir): ");
			num = teclado.nextInt();
			
			if (num > 5 || num < 1) {
				suma += num;				
			}
		}
		
		System.out.printf("La suma de tus numeros es: %d", suma);
		teclado.close();
	}
}
