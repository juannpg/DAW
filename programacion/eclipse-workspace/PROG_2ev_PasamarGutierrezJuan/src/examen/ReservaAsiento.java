package examen;

import java.util.Objects;

public abstract class ReservaAsiento {
	protected String dni;

	public ReservaAsiento(String dni) {
		this.dni = dni;
	}
	
	public String getDni() {
		return this.dni;
	}
	
	public void setDni(String dni) { 
		this.dni = dni;
	}
	
	/**
	 * metodo abstracto que dependiendo del tipo de reserva
	 * calcula su precio segun distintos valores
	 * @return
	 */
	public abstract int calcularPrecioReserva();
	
	@Override
	public String toString() {
		return "\t\t\t\t\tDNI: " + this.dni
				+ "\n\t\t\t\t\tPrecio: " + this.calcularPrecioReserva() + "€";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaAsiento other = (ReservaAsiento) obj;
		return Objects.equals(dni, other.dni);
	}
}