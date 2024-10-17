package bucles.actividades;

public class A4x04C_Suma50 {
	public static void main(String[] args) {
		int suma = 0;
		final int LIMITE = 50;
		
		for (int i = 1; i <= LIMITE; i++) {
			suma += i;
		}
		
		System.out.printf("Suma: %d", suma);
	}
}
