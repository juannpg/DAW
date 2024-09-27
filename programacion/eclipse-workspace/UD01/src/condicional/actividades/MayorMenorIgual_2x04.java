package condicional.actividades;
import java.util.Scanner;
/*
 * este programa pide dos numeros por teclado
 * e imprime por pantalla cuál es mayor, o si son iguales
 */
public class MayorMenorIgual_2x04 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Primer número real: ");
		double num1 = teclado.nextDouble();
		
		System.out.print("Segundo número real: ");
		double num2 = teclado.nextDouble();
		teclado.close();
		
		if (num1 > num2) {
			System.out.printf("El número real %f es mayor", num1);
		} else if (num2 > num1) {
			System.out.printf("El número real %f es mayor", num2);
		} else {
			System.out.printf("Los números %f y %f son iguales", num1, num2);
		}
	}
}