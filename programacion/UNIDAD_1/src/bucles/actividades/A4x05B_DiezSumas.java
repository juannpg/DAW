package bucles.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado 10 numeros e imprime por consola su suma.
 */
public class A4x05B_DiezSumas {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contador = 1, suma = 0, num;
		
		do {
			System.out.printf("¿Número entero %d? ", contador);
			num = teclado.nextInt();
			suma += num;
			contador++;
		} while (contador <= 10);
		
		teclado.close();
		System.out.printf("Suma: %d", suma);
	}
}
