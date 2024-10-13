package bucles.actividades;
import java.util.Scanner;

public class A4x10_SumaNPares {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Natural N? ");
		int num = teclado.nextInt();
		teclado.close();
		
		if (num <= 0) {
			System.out.print("El número natural N debe ser positivo.");
		} else {
			int suma = 0, contador = 0;
			int aux = num;
			final int ITERACIONES = num;
			
			if (num % 2 != 0) {
				aux++;
			}
			
			while (contador < ITERACIONES) {
				suma += aux;
				
				if (contador == ITERACIONES -1) {
					System.out.println(aux);
				} else {
					System.out.printf("%d, ", aux);
				}
				
				aux += 2;
				contador++;
			}

			System.out.printf("Suma de %d primeros Números Pares a partir de %d: %d", num, num, suma);
		}
	}
}
