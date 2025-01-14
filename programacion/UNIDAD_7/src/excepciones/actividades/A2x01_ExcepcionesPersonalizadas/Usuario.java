package excepciones.actividades.A2x01_ExcepcionesPersonalizadas;

public class Usuario {
    private String nombre;
    private String contraseña;
    private int numPuntos;

    public Usuario(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", numPuntos=" + numPuntos +
                '}';
    }
}
