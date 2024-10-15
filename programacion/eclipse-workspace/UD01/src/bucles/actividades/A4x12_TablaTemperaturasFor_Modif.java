package bucles.actividades;

/*
 * este programa imprime por consola una tabla de temperaturas
 */
public class A4x12_TablaTemperaturasFor_Modif {
	public static void main(String[] args) {
		System.out.println("Celsius Fahrenheit Kelvin");

		for (int celsius = -20; celsius <= 100; celsius += 10) {
			final double K = 273.15;
			int fahrenheit = (celsius * 9) / 5 + 32;
			int kelvin = (int) (celsius + K);
			
			System.out.printf("%7d %10d %6d\n", celsius, fahrenheit, kelvin);

		}
	}
}
