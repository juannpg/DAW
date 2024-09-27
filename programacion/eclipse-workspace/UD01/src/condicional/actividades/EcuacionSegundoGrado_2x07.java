package condicional.actividades;
import java.util.Scanner;
/*
 * este programa pide por teclado los tres
 * coeficientes a, b y c de una ecuacion
 * de segundo grado, e imprime por pantalla
 * sus soluciones, si las hay
 */
public class EcuacionSegundoGrado_2x07 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double a, b, c;
		double sol, sol1, sol2;
		double discriminante;
		
		System.out.print("Coeficiente A: ");
		a = teclado.nextDouble();
		
		System.out.print("Coeficiente B: ");
		b = teclado.nextDouble();
		
		System.out.print("Coeficiente C: ");
		c = teclado.nextDouble();
		teclado.close();
		
		discriminante = b * b - 4 * a * c;
		
		if (discriminante > 0) {
			System.out.println("La ecuación tiene dos soluciones reales:");
			
			sol1 = (-b + Math.sqrt(discriminante)) / 2 * a;
			sol2 = (-b - Math.sqrt(discriminante)) / 2 * a;
			
			System.out.printf("X1 = %f \nX2 = %f", sol1, sol2);
		} else if (discriminante == 0 ) {
			System.out.println("La ecuación tiene una solucioón real:");
			sol = (-b) / 2 * a;
			
			System.out.printf("X = %f", sol);
		} else {
			System.out.print("La ecuación no tiene soluciones");
		}
	}
}