package ejemplos;
import java.util.Scanner;

public class EntradaDatos {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Escribe un número entero: ");
		int numero = teclado.nextInt();
		teclado.close();
		
		System.out.print("Tu numero es: " + numero);
	}
}
