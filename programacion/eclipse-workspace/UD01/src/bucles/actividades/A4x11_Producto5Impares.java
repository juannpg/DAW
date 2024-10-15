package bucles.actividades;
import java.util.Scanner;

public class A4x11_Producto5Impares {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Natural N? ");
		int num = teclado.nextInt();
		teclado.close();
		
		if (num <= 0 || num % 2 == 0) {
			System.out.print("El número natural N debe ser positivo e impar");
		} else {
			int i = 0;
			int aux = num, producto = 1;
			final int ITERACIONES = 5;
			
			while (i < ITERACIONES) {
				producto *= aux;
				
				if (i == ITERACIONES -1) {
					System.out.println(aux);
				} else {
					System.out.printf("%d, ", aux);
				}
				
				aux += 2;
				i++;
			}

			System.out.printf("Producto de %d primeros Números Pares a partir de %d: %d", num, num, producto);
		}
	}
}
