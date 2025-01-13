package trabajonavidad;

import java.util.Random;

public class Temporada {
    private String codigo;
    private Episodio[] episodios;
    private int numEpisodios;

    public Temporada(int codigo) {
        this.codigo = "TEMP" + codigo;
        generarEpisodios();
    }

    public void generarEpisodios() {
        int cantidadEpisodios = new Random().nextInt(7) + 1;
        this.episodios = new Episodio[cantidadEpisodios];
        for (int i = 0; i < cantidadEpisodios; i++) {
            this.numEpisodios++;
            this.episodios[i] = new Episodio(this.numEpisodios);
        }
    }

    public String generarStringEpisodios() {
        String strEpisodios = "";
        for (int i = 0; i < this.numEpisodios; i++) {
            strEpisodios += this.episodios[i].toString() + "\n";
        }

        return strEpisodios;
    }

    @Override
    public String toString() {
        return "\t\t\t\t[" + this.codigo + ", Episodios {\n" + this.generarStringEpisodios() + "\n\t\t\t\t}]";
    }

    public int getNumEpisodios() {
        return this.numEpisodios;
    }
}
