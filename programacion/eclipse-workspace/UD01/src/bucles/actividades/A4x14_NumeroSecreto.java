package bucles.actividades;
import java.util.Scanner;

public class A4x14_NumeroSecreto {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		final int NUM_SECRETO = 19;
		int numIntentos = 5;
		int adivinar = 0;
		boolean acierto = false;
		
		while (numIntentos > 0 && !acierto) {
			System.out.print("¿Número? ");
			adivinar = teclado.nextInt();
			numIntentos--;
			
			if (adivinar == NUM_SECRETO) {
				acierto = true;
			} else {
				System.out.println("Has fallado el número secreto.");
				
				if (adivinar < NUM_SECRETO) {
					System.out.printf("El número %d es menor que el número secreto.\n", adivinar);
				} else {
					System.out.printf("El número %d es mayor que el número secreto.\n", adivinar);
				}
			}
		}
		
		teclado.close();
		
		if (acierto) {
			System.out.print("Has acertado el número secreto.");
		} else {
			System.out.print("Has agotado los 5 intentos.");
		}
	}
}