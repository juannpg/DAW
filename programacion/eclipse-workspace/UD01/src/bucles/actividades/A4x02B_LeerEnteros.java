package bucles.actividades;
import java.util.Scanner;

public class A4x02B_LeerEnteros {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num ;
		
		do {
			System.out.print("¿Número entero? (entre 1 y 5 para salir): ");
			num = teclado.nextInt();
		} while (num > 5 || num < 1);
		
		teclado.close();
	}
}
