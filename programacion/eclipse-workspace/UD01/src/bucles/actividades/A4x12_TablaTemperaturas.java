package bucles.actividades;

public class A4x12_TablaTemperaturas {
	public static void main(String[] args) {
		System.out.println("Celsius Fahrenheit Kelvin");
		
		int celsius = -20;
		
		while (celsius <= 100) {
			int fahrenheit = (celsius * 9) / 5 + 32;
			double kelvin = (celsius + 273.15);
			
			System.out.printf("%7d %10d %6.0f\n", celsius, fahrenheit, kelvin);
			
			celsius += 10;
		}
	}
}
