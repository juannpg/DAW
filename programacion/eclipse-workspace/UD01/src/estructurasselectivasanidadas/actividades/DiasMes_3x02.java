package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * este mes pide por teclado un numero
 * que representa un mes del año
 * 
 * si el numero no esta entre 1 y 12 imprime un error
 * 
 * imprime por pantalla el numero de dias de ese mes
 */
public class DiasMes_3x02 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Mes? ");
		int mes = teclado.nextInt();
		teclado.close();
		
		if (mes < 1 || mes > 12) {
			System.out.print("El mes debe estar comprendido entre 1 y 12.");
		} else {
			switch (mes) {
				case 1:
					System.out.print("31 días");
					break;
				case 2:
					System.out.print("28 días");
					break;
				case 3:
					System.out.print("31 días");
					break;
				case 4:
					System.out.print("30 días");
					break;
				case 5:
					System.out.print("31 días");
					break;
				case 6:
					System.out.print("30 días");
					break;
				case 7:
					System.out.print("31 días");
					break;
				case 8:
					System.out.print("30 días");
					break;
				case 9:
					System.out.print("31 días");
					break;
				case 10:
					System.out.print("30 días");
					break;
				case 11:
					System.out.print("31 días");
					break;
				case 12:
					System.out.print("30 días");
					break;
			}
		}
	}
}
