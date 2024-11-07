package ejemplos;

public class Coche {
	private String matricula;
	private String motor;
	private String color;
	private String marca;
	private int numPuertas;
	private boolean tunned;
	
	public Coche(String matricula, String motor, String color, String marca, int numPuertas, boolean tunned) {
		this.matricula = matricula;
		this.motor = motor;
		this.color = color;
		this.marca = marca;
		this.numPuertas = numPuertas;
		this.tunned = tunned;
	}
	
	String getMatricula() {
		return this.matricula;
	}
	
	void cambiarMatricula(String newMatricula) {
		this.matricula = newMatricula;
	}
	
	public static void main(String[] args) {
		Coche elCoche = new Coche("2501 FRR", "V8", "rojo", "citroen", 4, true);
		
		String matricula = elCoche.getMatricula();
		System.out.println(matricula);
		
		elCoche.cambiarMatricula("6789 ZYK");
		matricula = elCoche.getMatricula();
		System.out.println(matricula);
	}
}
