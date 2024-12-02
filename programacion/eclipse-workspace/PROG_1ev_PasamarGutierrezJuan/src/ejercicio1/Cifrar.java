package ejercicio1;

import entrada.Teclado;

public class Cifrar {
	/**
	 * lee una frase valida por teclado hasta que ésta sea valida y la devuelve
	 * @return
	 */
	public static String leerFraseValida() {
		boolean valido;
		String frase;
		do {
			valido = true;
			frase = Teclado.leerCadena("¿Frase? ");
			if (!frase.toUpperCase().equals(frase)) {
				valido = false;
			};
			
			for (int i = 0; i < frase.length() && valido; i++) {
				if (frase.charAt(i) > 'Z' || frase.charAt(i) < 'A' && frase.charAt(i) != ' ') {
					valido = false;
				}
			}
			
			if (!valido) {
				System.out.println("La frase debe contener letras mayúsculas y espacios en blanco.\n"
						+ "La frase no debe contener ningún otro carácter");
			}
		} while (!valido);
		
		return frase;
	}
	
	/**
	 * cifra una cadena desplazando sus caracteres un determinado indice
	 * @param frase
	 * @param index
	 * @return
	 */
	public static String cifrar(String frase, int index) {
		String cifrado = "";
		
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) >= 'A' && frase.charAt(i) < 'Z') {
				cifrado += (char) (frase.charAt(i) + index);
			} else if (frase.charAt(i) == 'Z') {
				cifrado += (char) ('A' + index - 1);
			} else {
				cifrado += ' ';
			}
		}
		
		return cifrado;
	}
}
