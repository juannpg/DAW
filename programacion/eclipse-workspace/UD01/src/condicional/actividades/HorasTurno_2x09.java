package condicional.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado el salario, numero
 * de horas ordinarias, y numero de horas extra de un trabajador,
 * e imprime su salario por pantalla.
 */
public class HorasTurno_2x09 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int turno, horasOrdinarias, horasExtra;
		double salario;
		boolean correcto = true;
		
		System.out.print("¿Turno de Trabajo (1-diurno, 2-vespertino)? ");
		turno = teclado.nextInt();
		System.out.print("Número de Horas Ordinarias? ");
		horasOrdinarias = teclado.nextInt();
		System.out.print("Número de Horas Extraordinarias? ");
		horasExtra = teclado.nextInt();
		teclado.close();

		if (turno != 1 && turno != 2) {
			System.out.println("El turno de trabajo debe estar comprendido entre 1 y 2");
			correcto = false;
		} 
		
		if (horasOrdinarias < 20 || horasOrdinarias > 40) {
			System.out.println("El número de horas ordinarias debe estar comprendido entre 20 y 40");	
			correcto = false;
		} 
		
		if (horasExtra < 0 || horasExtra > 5) {
			System.out.println("El número de horas extraordinarias debe estar comprendido entre 0 y 5");
			correcto = false;
		}
		
		if (correcto) {
			if (turno == 1) {
				salario = horasOrdinarias * 5 + horasExtra * 7;				
			} else {
				salario = horasOrdinarias * 8 + horasExtra * 11;
			}
			System.out.printf("Salario Mensual %.2f euros", salario);
		}		
		
	}
}
