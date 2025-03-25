package ejemplos.ejemploBD.excepciones;

public class CSVException extends RuntimeException {
    public static final String ERROR_ESCRITURA = "Error al escribir el fichero";
    public static final String ERROR_CIERRE = "Error al cerrar el fichero";

    public CSVException(String message) {
        super("Error: " + message);
    }
}
