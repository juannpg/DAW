package condicional.ejemplos;
import java.util.Scanner;

/*
 * pide por teclado la edad de un usuario,
 * y si es mayor de edad dice que lo es y se despide.
 * si no lo es, solo se despide
 */
public class CondicionalSimple {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Edad: ");
		int edad = teclado.nextInt();
		teclado.close();

		if (edad >= 18) {
			System.out.println("Eres mayor de edad");
		}
		
		System.out.print("adio");
	}
}
