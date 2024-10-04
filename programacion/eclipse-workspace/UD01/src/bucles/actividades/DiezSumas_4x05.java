package bucles.actividades;
import java.util.Scanner;

public class DiezSumas_4x05 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contador = 1, suma = 0, num;
		
		while (contador <= 10) {
			System.out.printf("¿Número entero %d? ", contador);
			num = teclado.nextInt();
			suma += num;
			contador++;
		}
		
		/*
		for (int i = 1; i <= 10; i++) {
			System.out.printf("¿Número entero %d? ", i);
			num = teclado.nextInt();
			suma += num;
		}
		*/
		
		teclado.close();
		System.out.printf("Suma: %d", suma);
	}
}
