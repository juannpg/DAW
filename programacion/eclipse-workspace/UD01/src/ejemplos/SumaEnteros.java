package ejemplos;
import java.util.Scanner;

public class SumaEnteros {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Escribe dos números enteros para sumarlos");
		System.out.print("Primer entero: ");
		int numero1 = teclado.nextInt();
		
		System.out.print("Segundo entero: ");
		int numero2 = teclado.nextInt();
		teclado.close();
		
		int resultado = numero1 + numero2;
		System.out.print("La suma de " + numero1 + " y " + numero2 + " es: " + resultado);
	}
}
