package condicional.actividades;
import java.util.Scanner;
/*
 * este programa pide por teclado tres
 * numeros reales, y asumiendo que el usuario
 * inserte tres numeros distintos, devuelve 
 * el mayor
 */
public class NumeroMayor_2x05 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Tres números reales distintos:\n");
		double num1 = teclado.nextDouble();
		double num2 = teclado.nextDouble();
		double num3 = teclado.nextDouble();
		teclado.close();
		
		if (num1 > num2 && num1 > num3) {
			System.out.printf("El número %f es el mayor.", num1);
		} else if (num2 > num1 && num2 > num3) {
			System.out.printf("El número %f es el mayor.", num2);
		} else {
			System.out.printf("El número %f es el mayor.", num3);
		}
		
		/*
		double[] numeros = {num1, num2, num3};
		double mayor = numeros[0];
		
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] > mayor) {
				mayor = numeros[i];
			}
		}
		
		System.out.printf("El número %f es el mayor.", mayor);
		*/
	}
}