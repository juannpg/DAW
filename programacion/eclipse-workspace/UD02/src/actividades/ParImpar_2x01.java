package actividades;
import java.util.Scanner;

/*
 * este programa pide un numero por teclado
 * e imprime por pantalla si es par o impar
 */
public class ParImpar_2x01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Escribe un número entero: ");
		int num = teclado.nextInt();
		teclado.close();
		
		if (num % 2 == 0) {
			System.out.printf("EL número %d es par.", num);
		} else if (num % 2 != 0) {
			System.out.printf("EL número %d es impar.", num);
		}
	}
}
