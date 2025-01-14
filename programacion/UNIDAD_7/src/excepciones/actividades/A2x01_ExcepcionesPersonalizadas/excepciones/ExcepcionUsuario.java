package excepciones.actividades.A2x01_ExcepcionesPersonalizadas.excepciones;

public class ExcepcionUsuario extends RuntimeException {
    public ExcepcionUsuario(String mensaje) {
        super(mensaje);
    }
}
