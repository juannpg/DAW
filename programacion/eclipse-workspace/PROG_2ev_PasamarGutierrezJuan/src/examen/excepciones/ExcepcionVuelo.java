package examen.excepciones;

public class ExcepcionVuelo extends Exception {
	public static final String NO_EXISTE = "No existe un vuelo con ese identificador.";

	
	public ExcepcionVuelo(String mensaje) {
		super("Error: " + mensaje);
	}
}
