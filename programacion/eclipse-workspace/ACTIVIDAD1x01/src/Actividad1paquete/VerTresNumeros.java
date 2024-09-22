package Actividad1paquete;
import java.util.Scanner;

public class VerTresNumeros {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Escribe el primer numero entero y pulsa enter: ");
		final int NUMERO_1 = input.nextInt();
		
		System.out.print("Escribe el segundo: ");
		final int NUMERO_2 = input.nextInt();
		
		System.out.print("Escribe el tecero: ");
		final int NUMERO_3 = input.nextInt();
		
		System.out.print("Los tres numeros enteros son: " + NUMERO_1 + " " + NUMERO_2 + " y " + NUMERO_3);
	}
}
