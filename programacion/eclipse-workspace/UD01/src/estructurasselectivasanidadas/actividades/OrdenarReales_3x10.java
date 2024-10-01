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
		
		float mayor;
		if (num1 > num2 && num1 > num3) {
			mayor = num1;
		} else if (num2 > num1 && num2 > num3) {
			mayor = num2;
		} else {
			mayor = num3;
		}
		
		float menor;
		if (num1 < num2 && num1 < num3) {
			menor = num1;
		} else if (num2 < num1 && num2 < num3) {
			menor = num2;
		} else {
			menor = num3;
		}
		
		float medio;
		if ((menor == num1 && mayor == num2) || (menor == num2 && mayor == num1)) {
			medio = num3;
		} else if ((menor == num3 && mayor == num2) || (menor == num2 && mayor == num3)) {
			medio = num1;
		} else {
			medio = num2;
		}
		
		System.out.printf("%.2f < %.2f < %.2f", menor, medio, mayor);
	}
}
