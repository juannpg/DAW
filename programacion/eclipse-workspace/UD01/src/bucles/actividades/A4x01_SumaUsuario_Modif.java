package bucles.actividades;
import java.util.Scanner;

public class A4x01_SumaUsuario_Modif {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num = 1, suma = 0;
		
		while (num != 0) {
			System.out.print("¿Número entero? (0 para salir): ");
			num = teclado.nextInt();
			suma += num;
		}
		
		teclado.close();
		System.out.printf("Suma: %d", suma);
	}
}
