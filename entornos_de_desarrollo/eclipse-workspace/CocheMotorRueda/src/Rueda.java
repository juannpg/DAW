public class Rueda {
	private double diametro;
	private String fabricante;
	
	public Rueda(double diametro, String fabricante) {
		this.diametro = diametro;
		this.fabricante = fabricante;
	}
	
	public void avanzar() {
		System.out.println("Rueda de fabricante " + this.fabricante + " de diametro " + this.diametro + " avanza.");
	}
}