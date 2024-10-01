package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un numero de
 * horas, minutos y segundos, y mientras esten
 * entre 0 y 23, 0 y 60 y 0 y 60 respectivamente,
 * les resta un segundo e imprime por consola
 * el resultado
 */
public class RestarSegundo_3x04 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int tiempoTotal;
		
		System.out.print("¿Horas? ");
		int horas = teclado.nextInt();
		System.out.print("¿Minutos? ");
		int mins = teclado.nextInt();
		System.out.print("¿Segundos? ");
		int segs = teclado.nextInt();
		teclado.close();
		
		tiempoTotal = horas * 60 * 60 + mins * 60 + segs;
		
		boolean error = false;
		
		if (horas < 0 || horas > 23) {
			System.out.println("Las horas deben estar comprendidas entre 0 y 23.");
			error = true;
		}
		
		if (mins < 0 || mins > 59) {
			System.out.println("Los minutos deben estar comprendidos entre 0 y 59.");
			error = true;
		}
		
		if (segs < 0 || segs > 59) {
			System.out.println("Los segundos deben estar comprendidos entre 0 y 59.");
			error = true;
		}
		
		if (tiempoTotal < 1) {
			System.out.print("El tiempo debe ser igual o superior a 1 segundo");
			error = true;
		}
		
		if (!error) {
			System.out.printf("%dh %dm %ds - 1s = ", horas, mins, segs);
			
			segs--;
			if (segs < 0) {
				segs = 59;
				mins--;
				if (mins < 0) {
					mins = 59;
					horas--;
				}
			}
			
			System.out.printf("%dh %dm %ds", horas, mins, segs);
		}
	}
}
