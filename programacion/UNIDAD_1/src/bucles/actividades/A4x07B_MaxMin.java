package bucles.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado 10 numeros e 
 * imprime por consola el maximo y minimo
 */
public class A4x07B_MaxMin {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num, mayor, menor;
		final int ITERACIONES = 10;
		
		System.out.print("¿Número entero 0? ");
		num = teclado.nextInt();
		
		mayor = num;
		menor = num;
		
		int i = 1;
		do {
			System.out.printf("¿Número entero %d? ", i);
			num = teclado.nextInt();
			
			if (num > mayor) {
				mayor = num;
			} else if (num < menor) {
				menor = num;
			}
			
			i++;
		} while (i < ITERACIONES);
		
		teclado.close();
		System.out.printf("Mínimo: %d\nMáximo: %d", menor, mayor);
	}
}
