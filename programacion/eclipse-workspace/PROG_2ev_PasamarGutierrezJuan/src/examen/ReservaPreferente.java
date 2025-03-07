package examen;

public class ReservaPreferente extends ReservaAsiento {
	private static final int PRECIO_BASE = 150;
	
	private int numMaletas;
	private boolean llevaEquipajeMano;
	private boolean tieneComida;
	
	public ReservaPreferente(String dni, int numMaletas, boolean llevaEquipajeMano, boolean tieneComida) {
		super(dni);
		this.numMaletas = numMaletas;
		this.llevaEquipajeMano = llevaEquipajeMano;
		this.tieneComida = tieneComida;
	}

	@Override    
	public String toString() {
		return "\t\t\t\tReserva preferente:"
				+ "\n" + super.toString()
				+ "\n\t\t\t\t\tNumero de maletas: " + this.numMaletas
				+ "\n\t\t\t\t\tEquipaje de mano: " + this.llevaEquipajeMano
				+ "\n\t\t\t\t\tComida: " + this.tieneComida;
	}

	public int getNumMaletas() {
		return numMaletas;
	}

	public void setNumMaletas(int numMaletas) {
		this.numMaletas = numMaletas;
	}

	public boolean isLlevaEquipajeMano() {
		return llevaEquipajeMano;
	}

	public void setLlevaEquipajeMano(boolean llevaEquipajeMano) {
		this.llevaEquipajeMano = llevaEquipajeMano;
	}

	public boolean isTieneComida() {
		return tieneComida;
	}

	public void setTieneComida(boolean tieneComida) {
		this.tieneComida = tieneComida;
	}

	@Override
	public int calcularPrecioReserva() {
		int precioFinal = PRECIO_BASE;
		
		if (this.tieneComida) {
			precioFinal += 20;
		}
		
		precioFinal += (this.numMaletas -1) * 50;
		
		return precioFinal;
	}
}
