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
		
		double importe, descuento, importeDescuento;
		
		System.out.print("Importe: ");
		importe = teclado.nextDouble();
		teclado.close();
		
		if (importe < 200 && importe > 0) {
			System.out.println("No hay descuento");
			System.out.printf("Importe: %.2f euros", importe);
		} else if (200 <= importe && importe <= 800) {
			descuento = importe / 10;
			importeDescuento = importe - descuento;
			
			System.out.printf("El descuento es de: %.2f euros\n", descuento);
			System.out.printf("Importe con descuento: %.2f euros", importeDescuento);
		} else if (800 < importe) {
			descuento = importe * 15 / 100;
			importeDescuento = importe - descuento;
			
			System.out.printf("El descuento es de: %.2f euros\n", descuento);
			System.out.printf("El importe con descuento: %.2f euros", importeDescuento);
		} else {
			System.out.print("El importe debe ser superior a 0 euros");
		}
	}
}