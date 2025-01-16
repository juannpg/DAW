package excepciones.actividades.A2x01_ExcepcionesPersonalizadas.excepciones;

public class ExcepcionClientela extends RuntimeException {
    public static final String EXCEPCION_INSERTAR = "Error al insertar usuario: ";
    public static final String EXCEPCION_ELIMINAR = "Error al eliminar usuario: ";
    public static final String EXCEPCION_INSERTAR_LLENO = "vector de usuarios lleno";
    public static final String EXCEPCION_INSERTAR_REPETIDO = "nombre de usuario repetido";
    public static final String EXCEPCION_ELIMINAR_VACIO = "vector de usuarios vacío.";
    public static final String EXCEPCION_ELIMINAR_NO_ENCONTRADO = "posición no indica usuario en la clientela.";


    public ExcepcionClientela(String mensaje) {
        super(mensaje);
    }
}
