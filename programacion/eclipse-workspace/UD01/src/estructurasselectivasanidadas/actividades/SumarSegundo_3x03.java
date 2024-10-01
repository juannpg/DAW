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
		
		int tiempoTotal;
		
		System.out.print("¿Horas? ");
		int horas = teclado.nextInt();
		System.out.print("¿Minutos? ");
		int mins = teclado.nextInt();
		System.out.print("¿Segundos? ");
		int segs = teclado.nextInt();
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
			int minsOut, horasOut, segsOut, dia;
			
			tiempoTotal = horas * 60 * 60 + mins * 60 + segs;
			tiempoTotal += 1;
			
			minsOut = tiempoTotal / 60;
			horasOut = minsOut / 60;
		
			minsOut = minsOut % 60;
			segsOut = tiempoTotal % 60;
			
			if (horasOut >= 24) {
				horas = 0;
				System.out.printf("%dh %dm %ds + 1s = %d días %dh %dm %ds", horas, mins, segs, 1, horasOut, minsOut, segsOut);
			} else {
				System.out.printf("%dh %dm %ds + 1s = %dh %dm %ds", horas, mins, segs, horasOut, minsOut, segsOut);
			}
			
		}
	}
}
