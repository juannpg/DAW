package condicional.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado una cantidad
 * de segundos como un numero entero mayor
 * o igual que 0, e imprime por consola a
 * cuantas horas, minutos y segundos se corresponde
 */
public class ConvertirSegundos_2x06 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		int horas, minutos, segundos;
		
		System.out.print("Tiempo en segundos: ");
		segundos = teclado.nextInt();
		teclado.close();
		
		if (segundos < 0) {
			System.out.print("El tiempo debe de ser mayor o igual que 0.");
		} else {
			minutos = segundos / 60;
			horas = minutos / 60;
		
			minutos = minutos % 60;
			segundos = segundos % 60;
		
			System.out.printf("%d horas %d minutos %d segundos", horas, minutos, segundos);
		}
	}
}