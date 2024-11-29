package Ejercicio2y3y4;
import java.util.Random;
import entrada.Teclado;

public class Primitiva {
	private String fecha;
	private int[] combinacionGanadora;
	
	/**
	 * constructor que asigna una fecha y la combinacionGanadora se hace aleatoria
	 * @param fecha fecha
	 */
	public Primitiva(String fecha) {
		this.fecha = fecha;
		this.combinacionGanadora = generarVectorAleatorio(6);
	}
	
	/**
	 * comprueba si un numero ya está en un vector
	 * @param num numero a comprobar
	 * @param v vector a comprobar
	 * @return boolean si esta o no
	 */
	public static boolean esta(int num, int[] v) {
		boolean esta = false;
		for (int i = 0; i < v.length && !esta; i++) {
			if (v[i] == num) {
				esta = true;
			}
		}
		
		return esta;
	}
	
	/**
	 * crea un vector aleatorio dado un limite insertando en cada indice un
	 * numero siempre y cuando ese numero no esté ya en el vector
	 * @param limite limite del vector
	 * @return vector
	 */
	public static int[] generarVectorAleatorio(int limite) {
		int[] vectorAleatorio = new int[limite];
		
		for (int i = 0; i < vectorAleatorio.length; i++) {
			Random r = new Random();
			int num = r.nextInt(49 - 2) + 1;
			
			if (!esta(num, vectorAleatorio)) {
				vectorAleatorio[i] = num;
			}
		}
		
		return vectorAleatorio;
	}
	
	public String getFecha() {
		return this.fecha;
	}
	
	public int[] getCombinacionGanadora() {
		return this.combinacionGanadora;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public void setCombinacionGanadora(int[] combinacionGanadora) {
		this.combinacionGanadora = combinacionGanadora;
	}
	
	/**
	 * da formato a la combinacion ganadora
	 * @return combinacion formateada
	 */
	public String combinacionToString() {
		String resultado = "";
		
		for (int i = 0; i < this.combinacionGanadora.length; i++) {
			if (i < this.combinacionGanadora.length - 1) {
				resultado += this.combinacionGanadora[i] + "|";
			} else {
				resultado += this.combinacionGanadora[i];
			}
		}
		
		return resultado;
	}
	
	public String toString() {
		return "Primitiva [fecha=" + this.fecha + " combinacionGanadora=" + this.combinacionToString() + "]\n";
	}
	
	/**
	 * crea un vector de enteros con las apuestas del usuario dejandole insertar
	 * numeros en una posicion hasta que sea valido
	 * @return vector de usuario
	 */
	public static int[] leeBoletoUsuario(int limite) {
		int[] boletoUsuario = new int[limite];
		
		for (int i = 0; i < boletoUsuario.length; i++) {
			boolean error;
			int num;
			
			do {
				error = false;
				num = Teclado.leerEntero("Inserte un numero: ");

				if (num < 1 || num > 49 || esta(num, boletoUsuario)) {
					System.out.println("El numero debe estar entre 1 y 49 y no estar repetido");
					error = true;
				}
				
			} while (error);
			
			
			boletoUsuario[i] = num;
		}
		
		return boletoUsuario;
	}
	
	/**
	 * comprueba cuantos numeros de la combinacionGanadora ha acertado el usuario
	 * @param boletoUsuario su boleto
	 * @return numero de aciertos
	 */
	public int compruebaAciertos(int[] boletoUsuario) {
		int numAciertos = 0;
		
		for (int i = 0; i < boletoUsuario.length; i++) {
			if (esta(i, boletoUsuario)) {
				numAciertos++;
			}
		}
		
		return numAciertos;
	}
}
