package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * pide por teclado la longitud de los
 * tres lados de un triangulo y devuelve
 * el tipo que es
 */
public class TipoTriangulo_3x08 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Longitud del Lado A? ");
		float ladoA = teclado.nextFloat();
		System.out.print("¿Longitud del Lado B? ");
		float ladoB = teclado.nextFloat();
		System.out.print("¿Longitud del Lado C? ");
		float ladoC = teclado.nextFloat();
		teclado.close();
		
		if (ladoA + ladoB <= ladoC) {
			System.out.print("La suma de dos de los lados debe ser mayor que el tercer lado.");
		} else if (ladoA == ladoB && ladoA == ladoC) {
			System.out.print("Triángulo Equilátero");
		} else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
			System.out.print("Triángulo Isósceles");
		} else {
			System.out.print("Triángulo Escaleno");
		}
	}
}
