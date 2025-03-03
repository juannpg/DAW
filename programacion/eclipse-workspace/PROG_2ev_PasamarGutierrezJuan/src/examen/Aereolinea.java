package examen;

import java.util.HashMap;
import java.util.TreeSet;

import examen.excepciones.ExcepcionReserva;
import examen.excepciones.ExcepcionVuelo;

public class Aereolinea {
    private String nombre;
    private HashMap<Integer, Vuelo> coleccionVuelos;
    
	public Aereolinea(String nombre) {
		super();
		this.nombre = nombre;
		this.coleccionVuelos = new HashMap<>();
	}
	
    @Override
	public String toString() {
		return this.nombre
			   + "\n\tVuelos:"
			   + "\n" + this.coleccionVuelos.toString();
	}

    /**
     * da de alta un vuelo, insertandolo en el conjunto. 
     * Si ya existia un vuelo con ese id, lo sobree escribe
     * @param v
     * @return si ha machacado el valor o no
     */
	public boolean altaVuelo(Vuelo v) {
    	// si devuelve true, no ha machacado el valor
    	return this.coleccionVuelos.put(v.getIdVuelo(), v) == null;
    }
    
	/**
	 * crea una reserva dado un id vuelo y los datos de la reserva
	 * @param idVuelo
	 * @param ra
	 * @return
	 * @throws ExcepcionVuelo si no existe dicho vuelo
	 * @throws ExcepcionReserva si el vuelo está lleno
	 */
    public boolean anadirReserva(int idVuelo, ReservaAsiento ra) throws ExcepcionVuelo, ExcepcionReserva {
    	if (!this.coleccionVuelos.containsKey(idVuelo)) {
    		throw new ExcepcionVuelo(ExcepcionVuelo.NO_EXISTE);
    	}
    	
    	Vuelo v = this.coleccionVuelos.get(idVuelo);
		return v.anadirReserva(ra);
    }
    
    /**
     * devuelve un listado de las reservas preferentes superiores a 300€ ordenadas por dni
     * @param idVuelo
     * @return
     * @throws ExcepcionVuelo si no existe el vuelo
     */
    public TreeSet<ReservaPreferente> listarReservasPreferentes(int idVuelo) throws ExcepcionVuelo {
    	if (!this.coleccionVuelos.containsKey(idVuelo)) {
    		throw new ExcepcionVuelo(ExcepcionVuelo.NO_EXISTE);
    	}
    	
    	Vuelo v = this.coleccionVuelos.get(idVuelo);
    	return v.listarReservasPreferentes();
    }
}