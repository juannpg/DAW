package ejemplos;
import java.util.Scanner;

public class AreaCirculo {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Escriba el radio de su círculo en cm: ");
		double radio = teclado.nextDouble();
		teclado.close();
		
		final double PI = 3.141592;
		double resultado = PI * radio * radio;
		
		System.out.print("El área de tu círculo es: " + resultado + " centímteros cuadrados.");
	}
}

