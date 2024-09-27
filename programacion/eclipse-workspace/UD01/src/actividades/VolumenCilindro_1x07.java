package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado datos 
 * de un cilindro e imprime por pantalla
 * su volumen
 */
public class VolumenCilindro_1x07 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double radio, altura, volumen;
		final double PI = 3.141592;
		
		System.out.print("Radio del cilindro en metros: ");
		radio = teclado.nextDouble();
		
		System.out.print("Altura del cilindro en metros: ");
		altura = teclado.nextDouble();
		teclado.close();
		
		volumen = PI * radio * radio * altura;
		
		System.out.printf("Volumen: %.3f metros cúbicos", volumen);
	}
}
