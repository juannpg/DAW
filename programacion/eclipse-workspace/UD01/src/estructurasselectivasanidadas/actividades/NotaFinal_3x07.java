package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * pide por teclado la nota de un alumno, e
 * imprime por consola su correspondiente textual, 
 * si la nota es válida
 */
public class NotaFinal_3x07 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Nota? ");
		float nota = teclado.nextFloat();
		teclado.close();
		
		if (nota < 0 || nota > 10) {
			System.out.print("La nota debe estar comprendida entre 0 y 10");
		} else if (nota < 1.5) {
			System.out.print("Muy Deficiente");
		} else if (nota < 3.5) {
			System.out.print("Deficiente");
		} else if (nota < 5) {
			System.out.print("Insuficiente");
		} else if (nota < 6.5) {
			System.out.print("Suficiente");
		} else if (nota < 6.5) {
			System.out.print("Bien");
		} else if (nota < 8.5) {
			System.out.print("Notable");
		} else if (nota < 10) {
			System.out.print("Sobresaliente");
		} else {
			System.out.print("Matrícula de honor");
		}
	}
}
