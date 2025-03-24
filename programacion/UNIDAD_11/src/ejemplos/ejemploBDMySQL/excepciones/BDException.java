package ejemplos.ejemploBDMySQL.excepciones;

public class BDException extends Exception {

    public static final String ERROR_ABRIR_CONEXION = "Error al abrir conexion ";
    public static final String ERROR_QUERY = "Error en la consulta ";
    public static final String ERROR_CERRAR_CONEXION = "Error al cerrar conexion ";
    public static final String ERROR_CARGAR_DRIVER = "Error al cargar driver";
    public static final String ERROR_CANCELAR_SETCONTRASENA = "Se canceló el inicio de sesión";

    public BDException(String mensaje) {
        super("Error: " + mensaje);
    }

}
