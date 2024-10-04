package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * ordena tres numeros obtenidos por teclado de menor a mayor
 */
public class OrdenarReales_3x10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Número Real A? ");
		float num1 = teclado.nextFloat();
		System.out.print("¿Número Real B? ");
		float num2 = teclado.nextFloat();
		System.out.print("¿Número Real C? ");
		float num3 = teclado.nextFloat();
		teclado.close();
		
		float mayor, menor, medio;
		if (num1 > num2 && num1 > num3) {
			mayor = num1;
			
			if (num2 < num3) {
				menor = num2;
				medio = num3;
			} else {
				menor = num3;
				medio = num2;
			}
		} else if (num2 > num1 && num2 > num3) {
			mayor = num2;
			
			if (num1 < num3) {
				menor = num1;
				medio = num3;
			} else {
				menor = num3;
				medio = num2;
			}
		} else {
			mayor = num3;
			
			if (num1 < num2) {
				menor = num1;
				medio = num2;
			} else {
				menor = num2;
				medio = num1;
			}
		}
		
		System.out.printf("%.2f < %.2f < %.2f", menor, medio, mayor);
	}
}
