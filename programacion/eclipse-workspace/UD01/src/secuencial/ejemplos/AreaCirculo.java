package secuencial.ejemplos;
import java.util.Scanner;

/*
 * este programa pide por teclado el radio de un círculo
 * e imprime por pantalla su área
 */
public class AreaCirculo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Escribe el radio de tu círculo en cm: ");
		double radio = teclado.nextDouble();
		teclado.close();
		
		final double PI = 3.141592;
		double resultado = PI * radio * radio;
		
		// el printf sustituye los valores con % por sus decimales correspondientes,
		// en la posición del argumento
		System.out.printf("El área de tu círculo es cuyo radio es: %.2f centímetros, es: %.2f centímetros cuadrados", radio, resultado);
	}
}