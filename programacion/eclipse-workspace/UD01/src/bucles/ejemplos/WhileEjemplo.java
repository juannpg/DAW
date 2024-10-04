package bucles.ejemplos;

/*
 * imprime 10 veces el valor de un valor 
 * inicializado a uno al que le sumamos 1
 * cada vez que se imprime
 */
public class WhileEjemplo {
	public static void main(String[] args) {
		int contador = 1;
		
		while (contador <= 10) {
			System.out.println("El contador vale: " + contador);
			contador++;
		}
	}
}
