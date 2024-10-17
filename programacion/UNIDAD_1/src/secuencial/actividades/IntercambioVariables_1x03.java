package secuencial.actividades;
import java.util.Scanner;

/*
 * Este programa pide por teclado dos numeros enteros
 * los imprime por pantalla, y luego intercambia
 * sus valores para volver a imprimirlos
 */
public class IntercambioVariables_1x03 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numero1, numero2, auxiliar;
		
		System.out.print("¿Número Entero A? ");
		numero1 = teclado.nextInt();
		
		System.out.print("¿Número Entero B? ");
		numero2 = teclado.nextInt();
		teclado.close();
		
		System.out.println("ANTES DEL INTERCAMBIO:");
		System.out.println("A = " + numero1 + " y B = " + numero2);
		
		auxiliar = numero1;
		numero1 = numero2;
		numero2 = auxiliar;
		
		System.out.println("DESPUES DEL INTERCAMBIO:");
		System.out.print("A = " + numero1 + " y B = " + numero2);
	}
}
