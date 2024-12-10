package herencia.actividades.A2X01_Autobuses;

import java.util.GregorianCalendar;

public class Conductor extends Empleado {
    private int numCarnets;
    private GregorianCalendar fechaCap;
    private static int carnetsLimite = 15;

    public Conductor(int nif, String nombre, GregorianCalendar fechaNacimiento, String direccion, int numTfno, String correo, int numCarnets, GregorianCalendar fechaCap) {
        super(nif, nombre, fechaNacimiento, direccion, numTfno, correo);
        if (numCarnets > 0 && numCarnets <= carnetsLimite) {
            this.numCarnets = numCarnets;
        } else {
            this.numCarnets = carnetsLimite;
        }
        this.fechaCap = fechaCap;
    }

    public static int getCarnetsLimite() {
        return carnetsLimite;
    }

    public static void setCarnetsLimite(int carnetsLimite) {
        Conductor.carnetsLimite = carnetsLimite;
    }

    public int getNumCarnets() {
        return numCarnets;
    }

    public void setNumCarnets(int numCarnets) {
        this.numCarnets = numCarnets;
    }

    public GregorianCalendar getFechaCap() {
        return fechaCap;
    }

    public void setFechaCap(GregorianCalendar fechaCap) {
        this.fechaCap = fechaCap;
    }

    @Override
    public String toString() {
        return "Conductor{" +
                super.toString() +
                "numCarnets=" + numCarnets +
                ", fechaCap=" + this.fechaCap.get(GregorianCalendar.DAY_OF_MONTH) +
                "/" + (this.fechaCap.get(GregorianCalendar.MONTH) + 1) +
                "/" + this.fechaCap.get(GregorianCalendar.YEAR) + '\'' +
                "} ";
    }

    public boolean incrementarNumeroCarnets() {
        if (this.numCarnets < Conductor.carnetsLimite) {
            this.numCarnets++;
            return true;
        }

        return false;
    }
}
