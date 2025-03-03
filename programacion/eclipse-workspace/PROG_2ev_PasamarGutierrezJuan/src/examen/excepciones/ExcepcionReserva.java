package examen.excepciones;

public class ExcepcionReserva extends Exception {
	public static final String VUELO_LLENO = "El vuelo está lleno.";
	public static final String NO_RESERVA = "No existe ninguna reserva con ese DNI.";
	public static final String NO_TURISTA = "La reserva no se corresponde a un turista.";

	
	public ExcepcionReserva(String mensaje) {
		super("Error: " + mensaje);
	}
}
