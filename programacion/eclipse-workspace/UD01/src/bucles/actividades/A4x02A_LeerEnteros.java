package bucles.actividades;
import java.util.Scanner;

public class A4x02A_LeerEnteros {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int num = 0;
		
		while (num > 5 || num < 1) {
			System.out.print("¿Número entero? (entreo 1 y 5 para salir): ");
			num = teclado.nextInt();
		}
		
		teclado.close();
	}
}
