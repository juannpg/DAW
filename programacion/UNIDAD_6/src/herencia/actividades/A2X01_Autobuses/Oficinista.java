package herencia.actividades.A2X01_Autobuses;

import java.util.GregorianCalendar;

public class Oficinista extends Empleado {
    private String titulacion;
    private int turno;

    public Oficinista(int nif, String nombre, GregorianCalendar fechaNacimiento, String direccion, int numTfno, String correo, String titulacion, int turno) {
        super(nif, nombre, fechaNacimiento, direccion, numTfno, correo);
        this.titulacion = titulacion;
        if (turno >= 0 && turno <= 2) {
            this.turno = turno;
        } else {
            this.turno = 1;
        }
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return  "Oficinista{" +
                super.toString() +
                "titulacion='" + titulacion + '\'' +
                ", turno=" + turno +
                '}';
    }
}
