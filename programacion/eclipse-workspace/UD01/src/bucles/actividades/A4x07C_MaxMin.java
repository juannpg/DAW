package bucles.actividades;
import java.util.Scanner;

public class A4x07C_MaxMin {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num, mayor = 0, menor = 0;
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("¿Número entero %d? ", i);
			num = teclado.nextInt();
			
			if (num > mayor) {
				mayor = num;
			}
			
			if (num < menor) {
				menor = num;
			}
		}
		
		teclado.close();
		System.out.printf("Mínimo %d\nMáximo %d", menor, mayor);
	}
}
