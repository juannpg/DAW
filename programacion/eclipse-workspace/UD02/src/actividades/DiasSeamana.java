package actividades;
import java.util.Scanner;

public class DiasSeamana {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
		
		int diaNum = teclado.nextInt();
		teclado.close();
		
		if (diaNum <= 0 && diaNum > 7) {
			System.out.print("El día de la semana debe estar entre 1 y 7");
			return;
		}
		
		System.out.print(dias[diaNum - 1]);
	}
}
