package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * devuelve el mayor y menor de tres numeros dados por teclado
 */
public class MaximoMinimo_3x09 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Real A? ");
		float num1 = teclado.nextFloat();
		System.out.print("¿Número Real B? ");
		float num2 = teclado.nextFloat();
		System.out.print("¿Número Real C? ");
		float num3 = teclado.nextFloat();
		teclado.close();
		
		float mayor, menor;
		if (num1 > num2 && num1 > num3) {
			mayor = num1;
			
			if (num2 < num3) {
				menor = num2;
			} else {
				menor = num3;
			}
		} else if (num2 > num1 && num2 > num3) {
			mayor = num2;
			
			if (num1 < num3) {
				menor = num1;
			} else {
				menor = num3;
			}
		} else {
			mayor = num3;
			
			if (num1 < num2) {
				menor = num1;
			} else {
				menor = num2;
			}
		}
		
		System.out.printf("Mínimo: %.2f\nMáximo: %.2f", mayor, menor);
	}
}
