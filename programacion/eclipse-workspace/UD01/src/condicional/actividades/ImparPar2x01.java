package condicional.actividades;
import java.util.Scanner;

/*
 * este programa pide un numero por teclado
 * e imprime por pantalla si es par o impar
 */
public class ImparPar2x01 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num, resto;
		
		System.out.print("Escribe un número entero: ");
		num = teclado.nextInt();
		teclado.close();
		
		resto = num % 2;
		
		if (resto == 0) {
			System.out.printf("EL número %d es par.", num);
		} else {
			System.out.printf("EL número %d es impar.", num);
		}
	}
}
