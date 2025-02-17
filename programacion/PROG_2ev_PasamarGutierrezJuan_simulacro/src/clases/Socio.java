package clases;

import java.util.Objects;

public abstract class Socio {
    protected String dni;
    protected String nombre;
    protected int edad;
    protected int cuentaBancaria;
    protected boolean entrenador;
    protected DatosEntrenamiento datosEntrenamiento;

    public Socio(String dni, String nombre, int edad, int cuentaBancaria, boolean entrenador, DatosEntrenamiento datosEntrenamiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.cuentaBancaria = cuentaBancaria;
        this.entrenador = entrenador;
        this.datosEntrenamiento = datosEntrenamiento;
    }

    public abstract double calcularCuotaMensual();

    @Override
    public String toString() {
        return "\tdni='" + dni + '\'' + "\n" +
                "\tnombre='" + nombre + '\'' + "\n" +
                "\tedad=" + edad + "\n" +
                "\tcuentaBancaria=" + cuentaBancaria + "\n" +
                "\tentrenador=" + entrenador + "\n" +
                "\tdatosEntrenamiento=" + datosEntrenamiento + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socio socio = (Socio) o;
        return Objects.equals(dni, socio.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCuentaBancaria() {
        return cuentaBancaria;
    }

    public void setCuentaBancaria(int cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }

    public boolean isEntrenador() {
        return entrenador;
    }

    public void setEntrenador(boolean entrenador) {
        this.entrenador = entrenador;
    }

    public DatosEntrenamiento getDatosEntrenamiento() {
        return datosEntrenamiento;
    }

    public void setDatosEntrenamiento(DatosEntrenamiento datosEntrenamiento) {
        this.datosEntrenamiento = datosEntrenamiento;
    }
}
