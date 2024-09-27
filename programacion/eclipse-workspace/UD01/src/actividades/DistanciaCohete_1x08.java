package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado la velocidad,
 * aceleracion y tiempo de vuelo de un cohete,
 * e imprime por pantalla la distancia viajada
 */
public class DistanciaCohete_1x08 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double velocidad, aceleracion, tiempoVuelo;
		double distancia;
		
		System.out.print("Velocidad inicial (ms/s): ");
		velocidad = teclado.nextDouble();
		
		System.out.print("Aceleracion (ms/s^2): ");
		aceleracion = teclado.nextDouble();
		
		System.out.print("Tiempo de vuelo (s): ");
		tiempoVuelo = teclado.nextDouble();
		teclado.close();
		
		distancia = velocidad * tiempoVuelo + (aceleracion * tiempoVuelo * tiempoVuelo)/2;
		
		System.out.printf("Distancia recorrida: %.3f metros", distancia);
	}
}
