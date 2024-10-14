package bucles.actividades;

public class A4x04B_Suma50 {
	public static void main(String[] args) {
		int num = 1, suma = 0;
		
		do {
			suma += num;
			num++;
		} while (num <= 50);
		
		System.out.printf("Suma: %d", suma);
	}
}
