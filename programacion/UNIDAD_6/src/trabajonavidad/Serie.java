package trabajonavidad;

import java.util.GregorianCalendar;
import java.util.Random;

public class Serie extends Video {
    private GregorianCalendar añoInicio;
    private GregorianCalendar añoFin;
    private Temporada[] temporadas;
    private int numTemporadas;

    private static GregorianCalendar generarAño() {
        int i = new Random().nextInt(Video.AÑOS.length);
        return Video.getAño(i);
    }

    public Serie(int codigo) {
        super(codigo);
        this.añoInicio = generarAño();
        this.añoFin = generarAño();
        generarTemporadas();
    }

    public void generarTemporadas() {
        this.temporadas = new Temporada[new Random().nextInt(8)];

        for (int i = 0; i < this.temporadas.length; i++) {
            this.numTemporadas++;
            this.temporadas[i] = new Temporada(this.numTemporadas);
        }
    }

    private String generarStringTemporadas() {
        String strTemporadas = "";
        for (int i = 0; i < this.numTemporadas; i++) {
            strTemporadas += this.temporadas[i].toString() + "\n";
        }

        return strTemporadas;
    }

    @Override
    public String toString() {
        return super.toString() + this.añoInicio.get(GregorianCalendar.YEAR) + "-" +
                this.añoFin.get(GregorianCalendar.YEAR) + ", Temporadas {\n" + this.generarStringTemporadas() + "\n\t\t}]";
    }
}
