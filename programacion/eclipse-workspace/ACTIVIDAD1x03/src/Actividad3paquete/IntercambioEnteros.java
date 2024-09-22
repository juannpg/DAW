package Actividad3paquete;
import java.util.Scanner;

public class IntercambioEnteros {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Escribe el primer numero entero y pulsa enter: ");
		int numeroA = input.nextInt();
		
		System.out.print("EScribe el segundo entero: ");
		int numeroB = input.nextInt();
		
		System.out.printf("Antes del cambio: \n" + "A = " + numeroA + " y B = " + numeroB + "\n");
		
		/*
		 * creo una variable en la que almaceno el valor original de A
		 * para luego poder asignarselo a la variable numeroB
		 */
		final int GUARDAR_NUMERO_A = numeroA;
		
		numeroA = numeroB;
		numeroB = GUARDAR_NUMERO_A;
		
		System.out.print("Despues del cambio: \n" + "A = " + numeroA + " y B = " + numeroB);
		input.close();
	}
}
