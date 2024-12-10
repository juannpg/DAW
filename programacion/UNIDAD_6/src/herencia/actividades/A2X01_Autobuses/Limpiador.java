package herencia.actividades.A2X01_Autobuses;

import java.util.GregorianCalendar;

public class Limpiador extends Empleado {
    private boolean limpiaOficinas;
    private boolean limpiaAutobuses;
    private boolean limpiaGarajes;

    public Limpiador(int nif, String nombre, GregorianCalendar fechaNacimiento, String direccion, int numTfno, String correo, boolean limpiaOficinas, boolean limpiaAutobuses, boolean limpiaGarajes) {
        super(nif, nombre, fechaNacimiento, direccion, numTfno, correo);
        this.limpiaOficinas = limpiaOficinas;
        this.limpiaAutobuses = limpiaAutobuses;
        this.limpiaGarajes = limpiaGarajes;
    }

    public boolean isLimpiaOficinas() {
        return limpiaOficinas;
    }

    public void setLimpiaOficinas(boolean limpiaOficinas) {
        this.limpiaOficinas = limpiaOficinas;
    }

    public boolean isLimpiaAutobuses() {
        return limpiaAutobuses;
    }

    public void setLimpiaAutobuses(boolean limpiaAutobuses) {
        this.limpiaAutobuses = limpiaAutobuses;
    }

    public boolean isLimpiaGarajes() {
        return limpiaGarajes;
    }

    public void setLimpiaGarajes(boolean limpiaGarajes) {
        this.limpiaGarajes = limpiaGarajes;
    }

    @Override
    public String toString() {
        return "Limpiador{" +
                super.toString() +
                "limpiaOficinas=" + limpiaOficinas +
                ", limpiaAutobuses=" + limpiaAutobuses +
                ", limpiaGarajes=" + limpiaGarajes +
                "} ";
    }
}
