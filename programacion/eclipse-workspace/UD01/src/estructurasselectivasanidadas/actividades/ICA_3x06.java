package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado el indice
 * de calidad del aire de una habitacion
 * 
 * si no está entre 0 y 500, imprime error
 * 
 * imprime el índice textual correspondiente al índice
 */
public class ICA_3x06 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("¿Índice de Calidad del Aire? ");
		int ica = teclado.nextInt();
		teclado.close();
		
		if (0 > ica || ica > 500) {
			System.out.print("El índice de calidad del aire debe estar comprendido entre 0 y 500");
		} else {
			if (ica <= 50) {
				System.out.print("Bueno");
			} else if (ica <=100) {
				System.out.print("Moderado");
			} else if (ica <=150) {
				System.out.print("No Saludable para Grupos Sensibles");
			} else if (ica <=200) {
				System.out.print("No Saludable para Todos");
			} else if (ica <=300) {
				System.out.print("Insalubre");
			} else {
				System.out.print("Peligroso");
			}
		}
	}
}
