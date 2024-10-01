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
		
		switch (mes) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.print("31 días");
				break;
			case 2:
				System.out.print("28 días");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.print("30 días");
				break;
			default:
				System.out.print("El mes debe estar comprendido entre 1 y 12.");			
		}
	}
}
