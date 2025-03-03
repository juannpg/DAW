package examen;

public class ReservaTurista extends ReservaAsiento {
	private static final int PRECIO_BASE = 60;
	
	private boolean llevaEquipajeMano;

	public ReservaTurista(String dni, boolean llevaEquipajeMano) {
		super(dni);
		this.llevaEquipajeMano = llevaEquipajeMano;
	}
	
	@Override
	public String toString() {
		return "\t\t\t\tReserva turista:"
				+ "\n" + super.toString()
				+ "\n\t\t\t\t\tEquipaje de mano: " + this.llevaEquipajeMano;
	}

	public boolean getLlevaEquipajeMano() {
		return llevaEquipajeMano;
	}

	public void setLlevaEquipajeMano(boolean llevaEquipajeMano) {
		this.llevaEquipajeMano = llevaEquipajeMano;
	}

	@Override
	public int calcularPrecioReserva() {
		int precioFinal = PRECIO_BASE;
		
		if (this.llevaEquipajeMano) {
			precioFinal += 25;
		}
		
		return precioFinal;
	}	
}
