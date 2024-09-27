package secuencial.ejemplos;
import java.util.Scanner;

/*
 * El programa pide tres datos, y comprueba si el primero es igual al
 * segundo, y si el ultimo  dato es 0.
 * si es asi imprime por pantalla true
 */
public class OperadoresLogicos {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int dato1, dato2, dato3;
		boolean resultado;
		
		System.out.print("Dato 1: ");
		dato1 = teclado.nextInt();
		
		System.out.print("Dato 2: ");
		dato2 = teclado.nextInt();
		
		System.out.print("Dato 3: ");
		dato3 = teclado.nextInt();
		teclado.close();
		
		resultado = dato1 == dato2 && dato3 == 0;
		
		System.out.print("¿Es el dato 1 igual al segundo, y además el dato 3 es igual a 0? " + resultado);
	}
}
