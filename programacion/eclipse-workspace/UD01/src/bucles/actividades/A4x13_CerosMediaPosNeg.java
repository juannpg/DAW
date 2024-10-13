package bucles.actividades;
import java.util.Scanner;

public class A4x13_CerosMediaPosNeg {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int contadorPos = 0, contadorNeg = 0;
		
		int numCeros = 0;
		double mediaPos = 0, mediaNeg = 0;
		
		int contador = 0;
		while (contador < 10) {
			System.out.printf("¿Número entero %d? ", contador);
			int num = teclado.nextInt();
			
			if (num > 0) {
				contadorPos++;
				mediaPos += num;
			} else if (num < 0) {
				contadorNeg++;
				mediaNeg += num;
			} else {
				numCeros++;
			}
			
			contador++;
		}
		
		teclado.close();
		
		System.out.printf("Número de Ceros: %d", numCeros);
		if (contadorPos != 0) {
			mediaPos /= contadorPos;
			System.out.printf("\nMedia Aritmética de Números Positvios: %.1f", mediaPos);			
		} else {
			System.out.print("\nNo hay Media Aritmética de Números Positivos");
		}
		
		if (contadorNeg != 0) {
			mediaNeg /= contadorNeg;
			System.out.printf("\nMedia aritmética de Números Negativos: %.1f", mediaNeg);			
		} else {
			System.out.print("\nNo hay Media Aritmética de Números Negativos");
		}
	}
}
