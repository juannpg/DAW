package trabajonavidad;

import java.util.Random;

public class Serie extends Video {
    private int añoInicio;
    private int añoFin;
    private Temporada[] temporadas;
    private int numTemporadas;

    private static int[] generarAños() {
        int añoInicio = new Random().nextInt(2025 - 1950 + 1) + 1950;
        int añoFin;
        do {
            añoFin = new Random().nextInt(2025 - 1950 + 1) + 1950;
        } while (añoFin <= añoInicio);

        return new int[] {añoInicio, añoFin};
    }

    public Serie(int codigo) {
        super(codigo);
        this.añoInicio = generarAños()[0];
        this.añoFin = generarAños()[1];
        generarTemporadas();
    }

    public void generarTemporadas() {
        this.temporadas = new Temporada[new Random().nextInt(7) + 1];

        for (int i = 0; i < this.temporadas.length; i++) {
            this.numTemporadas++;
            this.temporadas[i] = new Temporada(this.numTemporadas);
        }
    }

    private String generarStringTemporadas() {
        String strTemporadas = "";
        for (int i = 0; i < this.numTemporadas; i++) {
            if (this.temporadas[i] != this.temporadas[this.numTemporadas - 1]) {
                strTemporadas += this.temporadas[i].toString() + "\n";
            } else {
                strTemporadas += this.temporadas[i].toString();
            }
        }

        return strTemporadas;
    }

    @Override
    public String toString() {
        return super.toString() + this.añoInicio+ "-" +
                this.añoFin + ", Temporadas {\n" + this.generarStringTemporadas() + "\n\t\t\t}]";
    }

    public int getAñoInicio() {
        return this.añoInicio;
    }
}
