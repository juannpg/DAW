package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado los tres
 * coeficientes a, b y c de una ecuacion
 * de segundo grado, e imprime por pantalla
 * sus soluciones, si las hay
 */
public class SegundoGrado_2x07 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Coeficiente A: ");
		double a = teclado.nextDouble();
		
		System.out.print("Coeficiente B: ");
		double b = teclado.nextDouble();
		
		System.out.print("Coeficiente C: ");
		double c = teclado.nextDouble();
		teclado.close();
		
		double discriminante = b * b - 4 * a * c;
		
		if (discriminante > 0) {
			System.out.println("La ecuación tiene dos soluciones reales:");
			
			double sol1 = (-b + Math.sqrt(discriminante)) / 2 * a;
			double sol2 = (-b - Math.sqrt(discriminante)) / 2 * a;
			
			System.out.printf("X1 = %f \nX2 = %f", sol1, sol2);
		} else if (discriminante == 0 ) {
			System.out.println("La ecuación tiene una solucioón real:");

			double sol = (-b) / 2 * a;
			
			System.out.printf("X = %f", sol);
		} else {
			System.out.print("La ecuación no tiene soluciones");
		}
	}
}
