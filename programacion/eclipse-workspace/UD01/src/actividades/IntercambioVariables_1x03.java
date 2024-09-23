package actividades;
import java.util.Scanner;

public class IntercambioVariables_1x03 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Entero A? ");
		int numero1 = teclado.nextInt();
		
		System.out.print("¿Número Entero B? ");
		int numero2 = teclado.nextInt();
		teclado.close();
		
		System.out.println("ANTES DEL INTERCAMBIO:");
		System.out.println("A = " + numero1 + " y B = " + numero2);
		
		final int NUMERO1_GUARDADO = numero1;
		numero1 = numero2;
		numero2 = NUMERO1_GUARDADO;
		
		System.out.println("DESPUES DEL INTERCAMBIO:");
		System.out.print("A = " + numero1 + " y B = " + numero2);
	}
}
