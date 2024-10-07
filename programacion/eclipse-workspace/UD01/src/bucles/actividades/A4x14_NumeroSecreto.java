package bucles.actividades;
import java.util.Scanner;

public class A4x14_NumeroSecreto {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		final int SECRETO = 19;
		int intentos = 5;
		int num = 0;
		
		while (intentos > 0 && num != SECRETO) {
			System.out.print("¿Número? ");
			num = teclado.nextInt();
			
			while (num != SECRETO) {
				if (num < SECRETO) {
					System.out.println("Has fallado el número secreto.");
					System.out.printf("El número %d es menor que el número secreto", num);
				} else {
					System.out.printf("El número %d es mayor que el número secreto", num);
				}
				
				intentos--;
				
				if (intentos == 0) {
					System.out.print("Has agotado el número de intentos");
				}
			}
			
			System.out.print("acertaste");
			
		}
		
	}
}
