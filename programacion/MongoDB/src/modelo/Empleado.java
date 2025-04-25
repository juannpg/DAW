package modelo;

public class Empleado {

    private String nombre;
    private int edad;
    private String puesto;
    private double salario;
    private boolean activo;

    public Empleado(String nombre, int edad, String puesto, double salario, boolean activo) {
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
        this.activo = activo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public boolean isActivo() {
        return activo;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                ", activo=" + activo +
                '}';
    }
}
