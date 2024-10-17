package bucles.actividades;
import java.util.Scanner;

public class A4x05C_DiezSumas {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int  suma = 0, num;
		
		for (int i = 1; i <= 10; i++) {
			System.out.printf("¿Número entero %d? ", i);
			num = teclado.nextInt();
			suma += num;
		}
		
		teclado.close();
		System.out.printf("Suma: %d", suma);
	}
}
