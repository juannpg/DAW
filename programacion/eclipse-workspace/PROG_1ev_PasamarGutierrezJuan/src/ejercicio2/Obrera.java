package ejercicio2;
import java.util.Arrays;
import java.util.Random;

public class Obrera {
	private static int total;
	
	private String codigo;
	private int[] comidaAcumulada;
	
	/**
	 * constructor que inicializa el codigo dependiendo del total de homrigas,
	 * la comida a un string vacio de los siete dias dela semana
	 */
	public Obrera() {
		Obrera.total++;
		
		this.codigo = "OBRN" + Obrera.total;
		this.comidaAcumulada = new int[7];
	}
	
	/**
	 * en un dia determinado añade una cantidad de comida del 0 al 9
	 * @param dia
	 */
	public void conseguirComida(int dia) {
		Random r = new Random();
		int random = r.nextInt(8);
		
		this.comidaAcumulada[dia] += random;
	}
	
	/**
	 * devuelve toda la comida acumulada
	 * @return
	 */
	public int totalAcumulada() {
		int acumulada = 0;
		for (int i = 0; i < this.comidaAcumulada.length; i++) {
			acumulada += this.comidaAcumulada[i];
		}
		
		return acumulada;
	}
	
	public String toString() {
		return "Obrera [ codigo=" + this.codigo + 
				", comidaAcumulada=" + Arrays.toString(this.comidaAcumulada) + "]";
	}
}
