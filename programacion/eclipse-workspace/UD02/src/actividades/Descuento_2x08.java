package actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado el precio
 * de una compra, y dependiendo de la franja de
 * dinero en la que este, le aplica un descuento
 * u otro
 */
public class Descuento_2x08 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Importe de la compra: ");
		double importe = teclado.nextDouble();
		teclado.close();
		
		if (importe <= 0) {
			System.out.print("El importe debe ser positivo.");
			return;
		}
		
		if (importe < 200) {
			System.out.println("El importe no tiene descuento:");
			System.out.printf("Importe: %.2f euros.", importe);
		} else if (200 <= importe && importe <= 800) {
			double descuento = importe / 10;
			double importeDescuento = importe - descuento;
			
			System.out.printf("El descuento es de: %.2f euros\n", descuento);
			System.out.printf("Importe con descuento: %.2f euros", importeDescuento);
		} else if (800 < importe) {
			double descuento = importe * 15 / 100;
			double importeDescuento = importe - descuento;
			
			System.out.printf("El descuento es de: %.2f euros\n", descuento);
			System.out.printf("El importe con descuento: %.2f euros", importeDescuento);
		}
	}
}
