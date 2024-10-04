package bucles.actividades;

public class Suma1a50 {
	public static void main(String[] args) {
		int num = 1, suma = 0;
		
		while (num <= 50) {
			suma += num;
			num++;
		}
		
		System.out.printf("Suma: %d", suma);
	}
}
