package bucles.actividades;
import java.util.Scanner;

public class A4x06B_MediaAritmetica {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num, contador = -1, suma = 0;
		
		do {
			contador++;
			System.out.print("¿Número entero? (0 para salir): ");
			num = teclado.nextInt();
			suma += num;
		} while (num != 0);
		
		if (suma == 0) {
			System.out.print("No hay Media Aritmética");
		} else {
			double media = suma * 1.00 / contador;
			System.out.printf("Media Aritmética: %.2f", media);
		}
		
		teclado.close();
	}
}