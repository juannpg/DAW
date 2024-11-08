public class Motor {
	private String tipo;
	private int caballos;
	
	public Motor(String tipo, int caballos) {
		this.tipo = tipo;
		this.caballos = caballos;
	}
	
	public void inyectarCarburante() {
		System.out.println("Carburante en el motro de tipo " + this.tipo + " inyectado.");
	}	
}
