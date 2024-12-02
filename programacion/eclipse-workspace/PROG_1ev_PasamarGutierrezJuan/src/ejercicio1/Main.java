package ejercicio1;

import entrada.Teclado;

public class Main {
	/**
	 * pide un indice de desplazamiento hasta que sea valido para cifrar una frase
	 * @param frase
	 * @return
	 */
	public static String cifrar(String frase) {
		boolean valido;
		int desplazamiento;
		
		do {
			valido = true;
			desplazamiento = Teclado.leerEntero("¿Desplazamiento? ");
			
			if (desplazamiento <= 0) {
				valido = false;
				System.out.println("El dato introducido debe ser mayor que cero.");
			}
		} while (!valido);
		
		return Cifrar.cifrar(frase, desplazamiento);
	}
	
	/**
	 * lee una frase y imprime cifrada
	 * @param args
	 */
	public static void main(String[] args) {
		String frase = Cifrar.leerFraseValida();
		String cifrado = cifrar(frase);
		System.out.println("Frase Cifrada: " + cifrado);
	}
}
