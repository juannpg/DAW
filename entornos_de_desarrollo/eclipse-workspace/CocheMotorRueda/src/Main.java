public class Main {
	public static void main(String[] args) {
		Rueda[] ruedas = {
			new Rueda(20, "Dunlop"),
			new Rueda(20, "Dunlop"),
			new Rueda(22, "Dunlop"),
			new Rueda(22, "Dunlop"),
		};
		
		Motor motor  = new Motor("Diesel", 100);	
		Coche miCoche = new Coche("verde", 80, 3.2f, ruedas, motor);
		
		miCoche.avanzar();
	}
}
