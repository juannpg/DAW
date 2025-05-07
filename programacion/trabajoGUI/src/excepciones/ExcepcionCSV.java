package excepciones;

public class ExcepcionCSV extends Exception {
    public static String errorAbrir = "Error al abrir el fichero.";
    public static String errorCerrar = "Error al cerrar el fichero.";

	public ExcepcionCSV(String mensaje) {
		super(mensaje);
	}
}
