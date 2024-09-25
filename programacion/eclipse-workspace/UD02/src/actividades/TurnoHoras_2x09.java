package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado el turno de un empleado,
 * sus horas ordinarias de un mes, y sus horas extra, y
 * dependiendo de las condiciones, imprime por pantalla
 * su salario.
 */
public class TurnoHoras_2x09 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double salario = 0;
		
		System.out.print("Turno (1-diurno 2-vespertino): ");
		int turno = teclado.nextInt();
		
		if (turno != 1 && turno != 2) {
			System.out.print("Turno no válido");
			teclado.close();
			return;
		}
		
		System.out.print("Número de horas ordinarias: ");
		int horasOrdinarias = teclado.nextInt();
		
		if (horasOrdinarias < 20 || horasOrdinarias > 40) {
			System.out.print("Las horas ordinarias deben estar comprendidas entre 20 y 40.");
			teclado.close();
			return;
		}
		
		System.out.print("Número de horas extraordinarias: ");
		int horasExtra = teclado.nextInt();
		teclado.close();
		
		if (horasExtra < 0 || horasExtra > 5) {
			System.out.print("El número de horas extraordinarias debe estar entre 0 y 5.");
			return;
		}
		
		if (turno == 1) {
			salario = horasOrdinarias * 5 + horasExtra * 7;
		} else if (turno == 2) {
			salario = horasOrdinarias * 8 + horasExtra * 11;	
		}
		
		System.out.printf("Salario mensual: %.2f euros", salario);
	}
}
