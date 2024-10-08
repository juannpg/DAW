package estructurasselectivasanidadas.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado un numero de
 * horas, minutos y segundos, y mientras esten
 * entre 0 y 23, 0 y 60 y 0 y 60 respectivamente,
 * les suma un segundo e imprime por consola
 * el resultado
 */
public class SumarSegundo_3x03 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int horas, mins, segs;
		int tiempoTotal;
		
		System.out.print("¿Horas? ");
		horas = teclado.nextInt();
		System.out.print("¿Minutos? ");
		mins = teclado.nextInt();
		System.out.print("¿Segundos? ");
		segs = teclado.nextInt();
		teclado.close();
		
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
		
		if (!error) {
			System.out.printf("%dh %dm %ds + 1s = ", horas, mins, segs);
						
			segs++;
			if (segs == 60) {
				segs = 0;
				mins++;
				if (mins == 60) {
					mins = 0;
					horas++;
					if (horas == 24) {
						horas = 0;
						System.out.print("1 día ");
					}
				}
			}
			
			if (horas >= 24) {
				horas = 0;
				System.out.printf("%d día %dh %dm %ds", 1, horas, mins, segs);
			} else {
				System.out.printf("%dh %dm %ds", horas, mins, segs);
			}
			
		}
	}
}
