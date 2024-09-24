package actividades;
import java.util.Scanner;

public class VerReales_1x05 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		double numero1, numero2;
		
		System.out.print("¿Primer número real? ");
		numero1 = teclado.nextDouble();
		
		System.out.print("¿Segundo número real? ");
		numero2 = teclado.nextDouble();
		teclado.close();
		
		System.out.println("NÚMEROS CON DOS DIGITOS DECIMALES:");
		System.out.printf("A = %.2f \nB = %.2f", numero1, numero2);
		
		System.out.println("\nNÚMEROS CON UN DIGITOS DECIMALES:");
		System.out.printf("A = %.1f \nB = %.1f", numero1, numero2);
		
		System.out.println("\nNÚMEROS CON NINGÚN DIGITO DECIMAL:");
		System.out.printf("A = %.0f \nB = %.0f", numero1, numero2);
	}
}
