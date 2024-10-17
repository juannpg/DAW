package condicional.actividades;
import java.util.Scanner;

public class MayorMenorNeutro_2x02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int num;
		
		System.out.print("numero: ");
		num = teclado.nextInt();
		teclado.close();
		
		if (num > 0) {
			System.out.print("El número es positivo");
		} else if (num < 0) {
			System.out.print("El número es negativo");
		} else {
			System.out.print("El número es neutro");
		}
	}
}
