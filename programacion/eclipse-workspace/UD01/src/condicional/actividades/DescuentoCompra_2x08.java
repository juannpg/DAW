package condicional.actividades;
import java.util.Scanner;

/*
 * este programa pide por teclado el precio
 * de una compra, y dependiendo de la franja de
 * dinero en la que este, le aplica un descuento
 * u otro
 */
public class DescuentoCompra_2x08 {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double importe, descuento;
		
		System.out.print("¿Importe de la Compra? ");
		importe = teclado.nextDouble();
		teclado.close();
		if (importe <= 0 ) {
			System.out.print("El importe debe ser superior a 0 euros");
		} else {
			if (importe < 200) {
				descuento = 0;
			} else if (importe <= 800) {
				descuento = importe / 10;
				importe = importe - descuento;
			} else {
				descuento = importe * 15 / 100;
				importe = importe - descuento;
			}
			System.out.printf("Rebaja: %.2f euros\n", descuento);
			System.out.printf("El importe con Descuento: %.2f euros", importe);
			
		}
	}
}