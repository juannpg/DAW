package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado una cantidad
 * de segundos como un numero entero mayor
 * o igual que 0, e imprime por consola a
 * cuantas horas, minutos y segundos se corresponde
 */
public class TiempoSegundos_2x06 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Tiempo en segundos: ");
		int segundos = teclado.nextInt();
		teclado.close();
		
		if (segundos < 0) {
			System.out.print("El tiempo debe de ser mayor o igual que 0.");
			return;
		}
		
		int minutos = segundos / 60;
		
		int segundosOut = segundos % 60;
		int minutosOut = minutos % 60;
		int horasOut = minutos / 60;
		
		System.out.printf("%d horas %d minutos %d segundos", horasOut, minutosOut, segundosOut);
	}
}
