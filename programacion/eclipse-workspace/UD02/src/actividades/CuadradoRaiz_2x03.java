package actividades;
import java.util.Scanner;

/*
 * este programa pide un numero real por
 * teclado e imprime, si es posible, su cuadrado
 * y su raiz cuadrada
 */
public class CuadradoRaiz_2x03 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Número real: ");
		double num = teclado.nextDouble();
		teclado.close();
		
		if (num < 0) {
			System.out.print("El número real debe ser cero o positivo");
			return;
		}
		
		double cuadrado = num * num;
		double raizCuadrada = Math.sqrt(num);
		
		System.out.printf("Cuadrado de %f = %f", num, cuadrado);
		System.out.printf("\nRaíz cuadrada de %f = %f", num, raizCuadrada);
	}
}
