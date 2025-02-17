package clases;

public class DatosEntrenamiento {
    public static final String[] DIAS = {
            "lunes",
            "martes",
            "miercoles",
            "jueves",
            "viernes",
            "sabado",
            "domingo"
    };

    private String[] dias;
    private String[] horas;
    private int[] duraciones;

    public DatosEntrenamiento(String[] dias, String[] horas, int[] duraciones) {
        this.dias = dias;
        this.horas = horas;
        this.duraciones = duraciones;
    }

    public int getDuracionTotal() {
        int duracion = 0;
        for (int i : this.duraciones) {
            duracion += this.duraciones[i];
        }

        return duracion;
    }

    public String[] getDias() {
        return dias;
    }

    public void setDias(String[] dias) {
        this.dias = dias;
    }

    public String[] getHoras() {
        return horas;
    }

    public void setHoras(String[] horas) {
        this.horas = horas;
    }

    public int[] getDuraciones() {
        return duraciones;
    }

    public void setDuraciones(int[] duraciones) {
        this.duraciones = duraciones;
    }
}
