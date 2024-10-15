package bucles.actividades;
import java.util.Scanner;

public class A4x07B_MaxMin {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num, mayor, menor, contador;
		final int ITERACIONES = 10;
		
		System.out.print("¿Número entero 0? ");
		num = teclado.nextInt();
		
		mayor = num;
		menor = num;
		
		contador = 1;
		do {
			System.out.printf("¿Número entero %d? ", contador);
			num = teclado.nextInt();
			
			if (num > mayor) {
				mayor = num;
			} else if (num < menor) {
				menor = num;
			}
			
			contador++;
		} while (contador < ITERACIONES);
		
		teclado.close();
		System.out.printf("Mínimo: %d\nMáximo: %d", menor, mayor);
	}
}
