package examen;

public class Ejercicio2 {
	/**
	 * comprueba si un numero es triangular (cuando la suma de 
	 * los consecutivos a partir del 1 da como resultado el numero)
	 * y devuelve si lo es o no en forma de boolean.
	 * @param num numero a comprobar
	 * @return
	 */
	public static boolean esTriangular(int num) {
		int suma = 0;
		for (int i = 1; suma < num; i++) {
			suma += i;
		}
		
		return suma == num;
	}
	
	/**
	 * imprime por consola los 10 primeros numeros triangulares,
	 * ayudandose del método esTriangular.
	 * @param args arugmentos
	 */
	public static void main(String[] args) {
		System.out.print("Los 10 primeros números triangulares son el ");
		
		int contadorTriangulares = 0;
		int i = 1;
		final int LIMITE = 9;
		do {
			if (esTriangular(i)) {
				if (contadorTriangulares == LIMITE) {
					System.out.printf("%d. ", i);
				} else {
					System.out.printf("%d; ", i);
				}
				contadorTriangulares++;
			}
			i++;
		} while (contadorTriangulares <= LIMITE);
	}
}
