package bucles.actividades;
import java.util.Scanner;

public class LeerEnteros_4x01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num = 1;
		
		while (num != 0) {
			System.out.print("¿Número entero? (0 para salir): ");
			num = teclado.nextInt();
		}
		
		teclado.close();
	}
}
