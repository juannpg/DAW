package condicional.ejemplos;
import java.util.Scanner;

/*
 * este programa pide por teclado la
 * edad, y si es mayor o menor de edad,
 * lo imprime por pantalla
 */
public class CondicionalDoble {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("edad:" );
		int edad = teclado.nextInt();
		teclado.close();

		if (edad >= 18) {
			System.out.println("eres mayor de edad");
		} else {
			System.out.println("eres menor de edad");
		}
		
		System.out.print("adio");
	}
}
