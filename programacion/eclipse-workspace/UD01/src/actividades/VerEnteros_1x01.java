package actividades;
import java.util.Scanner;

public class VerEnteros_1x01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escribe tres números enteros:");
		System.out.print("Primer entero: ");
		int numero1 = teclado.nextInt();
		
		System.out.print("Segundo entero: ");
		int numero2 = teclado.nextInt();
		
		System.out.print("Tercer entero: ");
		int numero3 = teclado.nextInt();
		teclado.close();
		
		System.out.print("Los tres números son: " + numero1 + ", " + numero2 + " y " + numero3);
	}
}
