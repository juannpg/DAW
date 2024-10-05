package bucles.actividades;
import java.util.Scanner;

public class A4x07A_MaxMin {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num, mayor = 0, menor = 0, contador = 0;
		
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
