package actividades;
import java.util.Scanner;

/*
 * Este programa pide por teclado tres numeros
 * enteros y los imprime por consola
 */
public class VerEnteros_1x01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero1, numero2, numero3;
		
		System.out.println("Escribe tres números enteros:");
		System.out.print("Primer entero: ");
		numero1 = teclado.nextInt();
		
		System.out.print("Segundo entero: ");
		numero2 = teclado.nextInt();
		
		System.out.print("Tercer entero: ");
		numero3 = teclado.nextInt();
		teclado.close();
		
		System.out.print("Los tres números son: " + numero1 + ", " + numero2 + " y " + numero3);
	}
}
