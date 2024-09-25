package actividades;
import java.util.Scanner;

/*
 * este programa pide un numero entero
 * entre 1 y 7 e imprime por pantalla
 * el dia de la seamana correspondiente
 */
public class DiasSemana_2x10 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		
		System.out.print("Día de la semana: ");
		int diaNum = teclado.nextInt();
		teclado.close();
		
		if (diaNum <= 0 || diaNum > 7) {
			System.out.print("El día de la semana debe estar entre 1 y 7");
			return;
		}
		
		System.out.print(dias[diaNum - 1]);
	}
}
