package bucles.actividades;
import java.util.Scanner;

public class A4x01B_LeerEnteros {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num;
		
		do {
			System.out.print("¿Número entero? (0 para salir): ");
			num = teclado.nextInt();
		} while (num != 0);

		teclado.close();
	}
}
