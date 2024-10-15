package bucles.anidados;
import java.util.Scanner;

public class A5x01_Rectangulo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Altura del Rectángulo? ");
		int altura = teclado.nextInt();
		System.out.print("¿Anchura del Rectángulo? ");
		int anchura = teclado.nextInt();
		teclado.close();

		boolean err = false;
		if (altura <= 0) {
			System.out.print("La altura del rectángulo debe ser positiva");
			err = true;
		}
		
		if (anchura <= 0) {
			System.out.print("La anchura del rectángulo debe ser positiva");
			err = true;
		}
		
		if (!err) {
			for (int i = 0; i < altura; i++) {
				for (int j = 0; j < anchura; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
}
