package examen;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.LinkedHashMap;

import examen.excepciones.ExcepcionReserva;
import examen.orden.OrdenDni;

public class Vuelo {
	private static int numeroVuelos = 0;
	
	private int idVuelo;
    private int numeroAsientos;
    private LinkedHashMap<String, ReservaAsiento> reservasAsientos;
    
	public Vuelo(int numeroAsientos) {
		super();
		this.idVuelo = Vuelo.numeroVuelos + 1;
		this.numeroAsientos = numeroAsientos;
		this.reservasAsientos = new LinkedHashMap<>();
		
		Vuelo.numeroVuelos++;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idVuelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return idVuelo == other.idVuelo;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getNumeroAsientos() {
		return numeroAsientos;
	}

	public void setNumeroAsientos(int numeroAsientos) {
		this.numeroAsientos = numeroAsientos;
	}

	public LinkedHashMap<String, ReservaAsiento> getReservasAsientos() {
		return reservasAsientos;
	}

	public void setReservasAsientos(LinkedHashMap<String, ReservaAsiento> reservasAsientos) {
		this.reservasAsientos = reservasAsientos;
	}
	
	/**
	 * este metodo sirve para darle formato al listado de 
	 * reservas al usarlo en el metodo toString
	 * @return
	 */
	private String generarStringReservas() {
		String stringReservas = "";
		int numAsiento = 0;
		
		for (ReservaAsiento ra : this.reservasAsientos.values()) {
			stringReservas = stringReservas.concat(ra.toString() + "\n\t\t\t\t\tNumero asiento: " + numAsiento + "\n");
			numAsiento++;
		}
		
		return stringReservas;
	}

	@Override
	public String toString() {
		return "\t\tVuelo " + this.idVuelo + ":"
				+ "\n\t\t\tReservas:\n"
				+ this.generarStringReservas();
	}
    
	/**
	 * añade una reserva al vuelo
	 * @param ra
	 * @return
	 * @throws ExcepcionReserva si el vuelo está lleno
	 */
    public boolean anadirReserva(ReservaAsiento ra) throws ExcepcionReserva {
    	if (this.numeroAsientos == this.reservasAsientos.size()) {
    		throw new ExcepcionReserva(ExcepcionReserva.VUELO_LLENO);
    	}
    	
    	return this.reservasAsientos.putIfAbsent(ra.getDni(), ra) == null;
    }
    
    /**
     * elimina una reserva del vuelo por dni
     * @param dni
     * @return si ha sido eliminado
     */
    public boolean eliminarReserva(String dni) {
    	return this.reservasAsientos.remove(dni) != null;
    }
    
    /**
     * cambia una reserva de turista a preferente, con los nuevos datos
     * @param dni
     * @param numMaletas
     * @param tieneComida
     * @throws ExcepcionReserva si no existe la reserva, o si la reserva no era turista
     */
    public void modificarReserva(String dni, int numMaletas, boolean tieneComida) throws ExcepcionReserva {
    	if (!this.reservasAsientos.containsKey(dni)) {
    		throw new ExcepcionReserva(ExcepcionReserva.NO_RESERVA);
    	}
    	
    	if (!(this.reservasAsientos.get(dni) instanceof ReservaTurista)) {
    		throw new ExcepcionReserva(ExcepcionReserva.NO_TURISTA);
    	}
    	
    	ReservaTurista rt = (ReservaTurista) this.reservasAsientos.get(dni);
    	ReservaPreferente rp = new ReservaPreferente(rt.getDni(), numMaletas, rt.getLlevaEquipajeMano(), tieneComida);
    	this.reservasAsientos.replace(dni, rp);
    }
    
    /**
     * devuelve un listado de las reservas preferentes que superen los 300 €, ordenado por dni
     * @return
     */
    public TreeSet<ReservaPreferente> listarReservasPreferentes() {
    	final int UMBRAL = 300;
    	
    	TreeSet<ReservaPreferente> reservas = new TreeSet<>(new OrdenDni());
    	
    	for (ReservaAsiento ra : this.reservasAsientos.values()) {
    		if (ra instanceof ReservaPreferente rp) {
        		if (ra.calcularPrecioReserva() > UMBRAL) {
        			reservas.add(rp);
        		}

    		}
    	}
    	
    	return reservas;
    }
 }