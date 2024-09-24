package actividades;
import java.util.Scanner;

public class OperacionesReales_1x04 {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		final float NUMERO_A, NUMERO_B;
		
		System.out.print("¿Número real A? ");
		NUMERO_A = input.nextFloat();
			
		System.out.print("¿Número real B? ");
		NUMERO_B = input.nextFloat();
			
		input.close();
			
		final float SUMA = NUMERO_A + NUMERO_B;
		final float RESTA = NUMERO_A - NUMERO_B;
		final float PRODUCTO = NUMERO_A * NUMERO_B;
		final float DIVISION = NUMERO_A / NUMERO_B;
			
		System.out.print(
			NUMERO_A + " + " + NUMERO_B + " = " + SUMA + "\n" +
			NUMERO_A + " - " + NUMERO_B + " = " + RESTA + "\n" +
			NUMERO_A + " * " + NUMERO_B + " = " + PRODUCTO + "\n" +
			NUMERO_A + " / " + NUMERO_B + " = " + DIVISION + "\n"
		);
	}
}