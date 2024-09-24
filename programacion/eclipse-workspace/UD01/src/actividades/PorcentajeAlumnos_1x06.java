package actividades;
import java.util.Scanner;

/*
 * Este programa solicita por teclado el numero
 * de alumnos y alumnas de un centro, y muestra por pantalla
 * el porcentaje de alumnos y alumnas en el centro
 */
public class PorcentajeAlumnos_1x06 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double numAlumnos, numAlumnas, totalAlumnos;
		double porcentajeAlumnos, porcentajeAlumnas;
		
		System.out.print("Número de alumnos? ");
		numAlumnos = teclado.nextInt();
		
		System.out.print("Número de alumnas? ");
		numAlumnas = teclado.nextInt();
		teclado.close();
		
		totalAlumnos = numAlumnos + numAlumnas;
		
		porcentajeAlumnos = numAlumnos / totalAlumnos * 100;
		porcentajeAlumnas = numAlumnas / totalAlumnos * 100;
		
		System.out.printf("Porcentaje chicos: %.2f%%", porcentajeAlumnos);
		System.out.printf("\nPorcentaje chicas: %.2f%%", porcentajeAlumnas);
	}
}
