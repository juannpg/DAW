package actividad1x02;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int altura;
    private boolean activo;

    public Persona(String nombre, String apellido, int edad, int altura, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.activo = activo;
    }

    public Persona(String nombre, String apellido, int edad, int altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.altura = altura;
        this.activo = false;
    }

    public Persona() {
        this.nombre = "Recién";
        this.apellido = "Nacido";
        this.edad = 0;
        this.altura = 50;
        this.activo = false;
    }

    public String obtenerEstado() {
        return "Persona [Nombre = " + this.nombre + ", Apellido = " + this.apellido + ", Edad = " + this.edad + ", Altura = " + this.altura + ", Activo = " + this.activo + "]";
    }
}
