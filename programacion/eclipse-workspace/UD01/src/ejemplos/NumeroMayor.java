package ejemplos;
import java.util.Scanner;

public class NumeroMayor {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
	
		System.out.println("Escribe dos números enteros para comprobar si el primero es mayor que el segundo");
		System.out.print("Primer entero: ");
		int numero1 = teclado.nextInt();
		
		System.out.print("Segundo entero: ");
		int numero2 = teclado.nextInt();
		teclado.close();
		
		boolean esMayor = numero1 > numero2;
		
		System.out.print("¿El primer entero es mayor que el segundo? " + esMayor);
	}
}
