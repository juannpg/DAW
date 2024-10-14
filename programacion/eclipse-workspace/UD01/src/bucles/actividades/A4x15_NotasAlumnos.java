package bucles.actividades;
import java.util.Scanner;

public class A4x15_NotasAlumnos {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		final int NUM_ALUMNOS = 10;
		
		int numAlumno = 1;
		double notaTeoria, notaProblemas, notaPractica, notaFinal;
		double sumaFinal = 0, mediaFinal = 0;
		int numFinales = 0;
		
		boolean error = false;
		
		while (numAlumno <= NUM_ALUMNOS) {
			System.out.printf("ALUMNO %d\n", numAlumno);
			System.out.print("¿Nota de Teoría? ");
			notaTeoria = teclado.nextDouble();
			
			System.out.print("¿Nota de Problemas? ");
			notaProblemas = teclado.nextDouble();
			
			System.out.print("¿Nota de Prácticas? ");
			notaPractica = teclado.nextDouble();
		
			if (notaTeoria > 10 || notaTeoria < 0) {
				error = true;
				System.out.println("La nota de teoría debe estar comprendida entre 0 y 10");
			}
			
			if (notaProblemas > 10 || notaProblemas < 0) {
				error = true;
				System.out.println("La nota de problemas debe estar comprendida entre 0 y 10");
			}
			
			if (notaPractica > 10 || notaPractica < 0) {
				error = true;
				System.out.println("La nota de practica debe estar comprendida entre 0 y 10");
			}
			
			if (!error) {
				System.out.printf("Nota de Teoría: %.2f\n", notaTeoria);
				System.out.printf("Nota de Problemas: %.2f\n", notaProblemas);
				System.out.printf("Nota de Prácticas: %.2f\n", notaPractica);
				
				notaFinal = notaTeoria * 0.3 + notaProblemas * 0.2 + notaPractica * 0.5;
				System.out.printf("Nota final: %.2f\n", notaFinal);
				
				numFinales++;
				
				sumaFinal += notaFinal;
			}
			
			error = false;
			numAlumno++;
		}
			
		teclado.close();
		
		mediaFinal = sumaFinal / numFinales;
		
		System.out.println("RESUMEN");
		System.out.printf("Alumnos con Nota Final: %d", numFinales);
		System.out.printf("\nSuma de Notas Finales: %.2f", sumaFinal);
		System.out.printf("\nMedia Aritmética de Notas Finales: %.2f", mediaFinal);
	}
}
