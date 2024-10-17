package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

public class Cifras_3x05 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Número Entero (entre 0 y 99999)? ");
		int num = teclado.nextInt();
		teclado.close();
		
		if (num < 0 || num > 99999) {
			System.out.print("El número entero debe estar comprendido entre 0 y 99999");
		} else {
			int cifras;
			if (num < 10) {
				cifras = 1;
			} else if (num < 100) {
				cifras = 2;
			} else if (num < 1000) {
				cifras = 3;
			} else if (num < 10000) {
				cifras = 4;
			} else {
				cifras = 5;
			}
			
			System.out.printf("El número %d tiene %d cifras.", num, cifras);
		}
		
	}
}
