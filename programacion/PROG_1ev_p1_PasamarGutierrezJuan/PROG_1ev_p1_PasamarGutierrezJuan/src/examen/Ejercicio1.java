package examen;
import java.util.Scanner;

public class Ejercicio1 {
	/**
	 * pide por teclado de manera consecutiva 5 números enteros. Indica si
	 * están ordenados de mayor a menor por consola, y si lo están, visualiza
	 * por consola la suma de los núemros introducidos múltiplos de 5 diferentes.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, numAnterior, sumaMultiplos = 0;
		boolean ordenada = true;
		final int MULT_CINCO = 5;
		
		// pide el primer número para poder asignarlo a la
		// variable numero anterior, y comprueba si es múltiplo de 5
		// para sumarlo.
		System.out.print("Escribe un número: ");
		num = sc.nextInt();
		numAnterior = num;
		
		if (num % MULT_CINCO == 0) {
			sumaMultiplos += num;
		}
		
		// pido los otros cuatro números comprobando si son mayores
		// que el numero anterior. si lo es indica que la lista no está ordenada.
		// Si no lo es, comprueba si es múltiplo de 5 y si no es igual que el
		// número anterior (para así evitar repetidos), y si lo es lo suma.
		final int LIMITE = 4;
		for (int i = 0; i < LIMITE; i++) {
			System.out.print("Escribe un número: ");
			num = sc.nextInt();
			if (num > numAnterior) {
				ordenada = false;
			} else {
				if (num % MULT_CINCO == 0 && num != numAnterior) {
					sumaMultiplos += num;
				}
				numAnterior = num;
			}
		}
		
		sc.close();
		
		if (ordenada) {
			System.out.println("La secuencia está ordenada de mayor a menor");
			System.out.printf("Suma de números diferentes múltiplos de 5: %d", sumaMultiplos);
		} else {
			System.out.println("La secuencia no está ordenada de mayor a menor");
		}
	}
}
