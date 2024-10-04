package bucles.actividades;
import java.util.Scanner;

public class DiezSumas_4x05 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int contador = 1, suma = 0, num;
		
		while (contador <= 10) {
			System.out.print("¿Número entero? ");
			num = teclado.nextInt();
			suma += num;
			contador++;
		}
		
		teclado.close();
		System.out.printf("Suma: %d", suma);
	}
}
