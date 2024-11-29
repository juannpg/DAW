package Ejercicio2y3y4;

public class Loteria {
	private Primitiva[] vectorPrimitivas;
	private int numElementos;
	
	/**
	 * constructor que inicializa el vector de primitivas a un maximo y el numero de elementos a 0
	 * @param max
	 */
	public Loteria(int max) {
		this.vectorPrimitivas = new Primitiva[max];
		this.numElementos = 0;
	}
	
	/**
	 * añade en la primera posicion no nula la primitiva proporcionada
	 * @param primitiva
	 * @return
	 */
	public boolean añadir(Primitiva primitiva) {
		boolean añadido = false;
		if (this.numElementos != this.vectorPrimitivas.length) {
			this.vectorPrimitivas[this.numElementos] = primitiva;
			this.numElementos++;
			añadido = true;
		}
		
		return añadido;
	}
	/**
	 * busca en el vector de primitivas una que coincida con la fecha proporcionada
	 * @param fecha
	 * @return
	 */
	public Primitiva buscar(String fecha) {
		boolean encontrado = false;
		Primitiva devolver = null;
		for (int i = 0; i < this.numElementos && !encontrado; i++) {
			if (this.vectorPrimitivas[i].getFecha().equals(fecha)) {
				devolver = this.vectorPrimitivas[i];
				encontrado = true;
			}
		}
		
		return devolver;
	}
	
	/**
	 * comprueba un boleto de usuario buscando la primitiva a comprobar dada por una fecha,
	 * y devolviendo el numero deaciertos, o -1 si no se enecuentra la primitiva
	 * @param fecha
	 * @param boletoUsuario
	 * @return
	 */
	public int comprobar(String fecha, int[] boletoUsuario) {
		Primitiva primitiva = this.buscar(fecha);
		int devolver;
		
		if (primitiva != null) {
			devolver = primitiva.compruebaAciertos(boletoUsuario);
		} else {
			devolver = -1;
		}
		
		return devolver;
	}
	
	public String toString() {
		String resultado = "";
		
		for (int i = 0; i < this.numElementos; i++) {
			resultado += this.vectorPrimitivas[i].toString();
		}
		
		return resultado;
	}
}
