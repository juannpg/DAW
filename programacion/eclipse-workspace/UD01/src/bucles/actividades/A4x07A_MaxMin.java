package bucles.actividades;
import java.util.Scanner;

public class A4x07A_MaxMin {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num, mayor, menor, contador = 0;
		
		System.out.print("¿Número entero 0? ");
		num = teclado.nextInt();
		contador++;
		
		mayor = num;
		menor = num;
		
		while (contador < 10) {
			System.out.printf("¿Número entero %d? ", contador);
			num = teclado.nextInt();
			
			if (num > mayor) {
				mayor = num;
			}
			
			if (num < menor) {
				menor = num;
			}
			
			contador++;
		}
		
		teclado.close();
		System.out.printf("Mínimo %d\nMáximo %d", menor, mayor);
	}
}
