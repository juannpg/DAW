package secuencial.actividades;
import java.util.Scanner;

/*
 * Este programa solicita por teclado el numero
 * de alumnos y alumnas de un centro, y muestra por pantalla
 * el porcentaje de alumnos y alumnas en el centro
 */
public class PorcentajeAlumnos_1x06 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int numAlumnos, numAlumnas, totalAlumnos;
		double porcentajeAlumnos, porcentajeAlumnas;
		
		System.out.print("Número de alumnos? ");
		numAlumnos = teclado.nextInt();
		
		System.out.print("Número de alumnas? ");
		numAlumnas = teclado.nextInt();
		teclado.close();
		
		totalAlumnos = numAlumnos + numAlumnas;
		
		porcentajeAlumnos = numAlumnos * 100.0 / totalAlumnos;
		porcentajeAlumnas = 100 - porcentajeAlumnos;
		
		System.out.printf("Porcentaje chicos: %.2f%%", porcentajeAlumnos);
		System.out.printf("\nPorcentaje chicas: %.2f%%", porcentajeAlumnas);
	}
}
