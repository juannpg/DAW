package bucles.actividades;
import java.util.Scanner;

public class A4x06A_MediaAritmetica {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num = 1, contador = -1, suma = 0;
		
		while (num != 0) {
			contador++;
			System.out.print("¿Número entero? (0 para salir): ");
			num = teclado.nextInt();
			suma += num;
		}
		
		if (contador == 0) {
			System.out.print("No hay Media Aritmética");
		} else {
			double media = (double) suma / contador;
			System.out.printf("Media Aritmética: %.2f", media);
		}
		
		teclado.close();
	}
}
