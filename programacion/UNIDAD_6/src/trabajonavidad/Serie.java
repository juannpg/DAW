package trabajonavidad;

import java.util.GregorianCalendar;
import java.util.Random;

public class Serie extends Video {
    private GregorianCalendar añoInicio;
    private GregorianCalendar añoFin;
    private Temporada[] temporadas;
    private int numTemporadas;

    private static GregorianCalendar generarAño() {
        int i = new Random().nextInt(8);
        return Video.getAño(i);
    }

    private static int generarCapacidadTemporadas() {
        return new Random().nextInt(8);
    }

    public Serie(int codigo) {
        super(codigo);
        this.añoInicio = generarAño();
        this.añoFin = generarAño();
        this.temporadas = new Temporada[generarCapacidadTemporadas()];
    }

    public void generarTemporadas() {
        for (int i = 0; i < this.temporadas.length; i++) {
            this.temporadas[i] = new Temporada(this.numTemporadas);
        }
    }
}
