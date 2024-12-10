package herencia.actividades.A2X01_Autobuses;

import java.util.GregorianCalendar;

public class Empleado {
    protected int nif;
    protected String nombre;
    protected GregorianCalendar fechaNacimiento;
    protected String direccion;
    protected int numTfno;
    protected String correo;

    public Empleado(int nif, String nombre, GregorianCalendar fechaNacimiento, String direccion, int numTfno, String correo) {
        this.nif = nif;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.numTfno = numTfno;
        this.correo = correo;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumTfno() {
        return numTfno;
    }

    public void setNumTfno(int numTfno) {
        this.numTfno = numTfno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nif=" + nif +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + this.fechaNacimiento.get(GregorianCalendar.DAY_OF_MONTH) +
                "/" + (this.fechaNacimiento.get(GregorianCalendar.MONTH) + 1) +
                "/" + this.fechaNacimiento.get(GregorianCalendar.YEAR) + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTfno=" + numTfno +
                ", correo='" + correo + '\'' +
                '}';
    }
}
