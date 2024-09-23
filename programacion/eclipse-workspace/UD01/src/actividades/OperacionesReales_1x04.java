package actividades;
import java.util.Scanner;

public class OperacionesReales_1x04 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.printf("¿Número real A? ");
			final float NUMERO_A = input.nextFloat();
			
			System.out.printf("¿Número real B? ");
			final float NUMERO_B = input.nextFloat();
			
			input.close();
			
			final float SUMA = NUMERO_A + NUMERO_B;
			final float RESTA = NUMERO_A - NUMERO_B;
			final float PRODUCTO = NUMERO_A * NUMERO_B;
			final float DIVISION = NUMERO_A / NUMERO_B;
			
			System.out.printf(
				NUMERO_A + " + " + NUMERO_B + " = " + SUMA + "\n" +
				NUMERO_A + " - " + NUMERO_B + " = " + RESTA + "\n" +
				NUMERO_A + " * " + NUMERO_B + " = " + PRODUCTO + "\n" +
				NUMERO_A + " / " + NUMERO_B + " = " + DIVISION + "\n"
			);
		} catch (Exception e) {
			System.out.printf("Ambos datos deben ser numeros reales.");
		}
	}
}