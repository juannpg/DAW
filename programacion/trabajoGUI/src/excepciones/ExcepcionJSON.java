package excepciones;

public class ExcepcionJSON extends Exception {
    public static String errorAbrir = "Error al abrir el fichero.";
    public static String errorCerrar = "Error al cerrar el fichero.";

	public ExcepcionJSON(String mensaje) {
		super(mensaje);
	}
}
