package bucles.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado 10 numeros e 
 * imprime por consola el maximo y minimo
 */
public class A4x07C_MaxMin {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		final int ITERACIONES = 10;
		int num, mayor, menor;
		
		System.out.printf("¿Número entero %d? ", 0);
		num = teclado.nextInt();
		
		mayor = num;
		menor = num;
		
		for (int i = 1; i < ITERACIONES; i++) {
			System.out.printf("¿Número entero %d? ", i);
			num = teclado.nextInt();
			
			if (num > mayor) {
				mayor = num;
			} else if (num < menor) {
				menor = num;
			}
		}
		
		teclado.close();
		System.out.printf("Mínimo %d\nMáximo %d", menor, mayor);
	}
}
