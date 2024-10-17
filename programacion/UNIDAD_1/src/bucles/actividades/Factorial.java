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
			int factorial = num;
			int i = num - 1;
			
			while (i > 0) {
				factorial *= i;
				i--;
			}

			System.out.printf("Factorial de %d = %d", num, factorial);
		}
	}
}
