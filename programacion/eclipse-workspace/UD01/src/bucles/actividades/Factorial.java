package bucles.actividades;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Entero? ");
		int num = teclado.nextInt();
		teclado.close();

		if (num == 0) {
			System.out.printf("Factorial de %d = 1", num);
		} else {
			int factorial = num, contador = num - 1;
			while (contador > 0) {
				factorial *= contador;
				contador--;
			}

			System.out.printf("Factorial de %d = %d", num, factorial);
		}
	}
}
