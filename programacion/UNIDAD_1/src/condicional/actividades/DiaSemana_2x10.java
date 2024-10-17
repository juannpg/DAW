package condicional.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un día
 * de la semana como número entre 1 y 7,
 * e imprime por pantalla el día correspondiente
 */
public class DiaSemana_2x10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Día de la Semana? ");
		int dia = teclado.nextInt();
		teclado.close();
		
		switch (dia) {
			case 1:
				System.out.print("Lunes");
				break;
			
			case 2:
				System.out.print("Martes");
				break;
			
			case 3:
				System.out.print("Miércoles");
				break;
			
			case 4:
				System.out.print("Jueves");
				break;
			
			case 5:
				System.out.print("Viernes");
				break;
			
			case 6:
				System.out.print("Sábado");
				break;
			
			case 7:
				System.out.print("Domingo");
				break;
			
			default:
				System.out.print("El día de la semana debe estar comprendido entre 1 y 7");
		}
		
	}
}
/*
		if (dia < 1 || dia > 7) {
			System.out.print("El día de la semana debe estar comprendido entre 1 y 7");
			return;
		}
		
		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves",
				"Viernes", "Sábado", "Domingo"};
		
		System.out.print(dias[dia-1]);
 */
