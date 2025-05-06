package excepciones;

public class ExcepcionModificar extends RuntimeException {
  public static String dniNueve = "El DNI debe tener longitud 9";
  public static String dniValido = "El DNI debe ser válido";
  public static String nombreVacio = "Debe introducir el nombre del trabajador";
  public static String apellidosVacio = "Debe introducir los apellidos del trabajador";
  public static String direccionVacio = "Debe introducir la dirección del trabajador";
  public static String telefonoValido = "El teléfono debe ser válido";
  public static String telefonoNueve = "El teléfono debe tener longitud 9";
  public static String puestoVacio = "Debe introducir el puesto del trabajador";
  public static String yaExiste = "Ese DNI ya existe";

  public ExcepcionModificar(String message) {
    super(message);
  }
}
