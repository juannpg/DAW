package Ejercicio1;
import java.util.Scanner;

public class Ejercicio1 {
	/**
	 * comprueba si una matricula es verdadera, viendo si su longitud es 7, si los cuatro primeros caracteres
	 * son numeros, y si los ultimos tres son letras consonantes mayusculas distintas de Q y Ñ
	 * @param matricula matricula
	 * @return valida o no
	 */
	public static boolean validar(String matricula) {
		boolean longitudBien = matricula.length() == 7;
		boolean numerosBien = true, letrasBien = true;
		
		if (longitudBien) {
			String numeros = matricula.substring(0, 4);
			String letras = matricula.substring(4);
			
			for (int i = 0; i < 4 && numerosBien; i++) {
				if (numeros.charAt(i) < '1' || numeros.charAt(i) > '9') {
					numerosBien = false;
				}
			}
			
			if (numerosBien) {
				if (!letras.equals(letras.toUpperCase())) {
					letrasBien = false;
				}
				
				for (int i = 0; i < 3 && letrasBien; i++) {
					if (letras.charAt(i) == 'A' || letras.charAt(i) == 'E' || letras.charAt(i) == 'I' || letras.charAt(i) == 'O' || 
							letras.charAt(i) == 'U' || letras.charAt(i) == 'Q' || letras.charAt(i) == 'Ñ') {
						letrasBien = false;
					}
				}
			}
		}
		
		return longitudBien && letrasBien && numerosBien;
	}
	
	/**
	 * Pide por teclado matriculas y las valida hasta que el usuario decida detener el programa.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input;
		int i = 1;
		
		do {
			System.out.printf("¿Matrícula %d? ", i);
			input = sc.next();
			
			if (!input.equals("*")) {
				if (validar(input)) {
					System.out.println("Válida");
				} else {
					System.out.println("Inválida");
				}
			}
			
			i++;
		} while (!input.equals("*"));
		
		sc.close();
	}
}
