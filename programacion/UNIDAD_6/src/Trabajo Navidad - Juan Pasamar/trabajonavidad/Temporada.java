package trabajonavidad;

public class Temporada {
    private String codigo;
    private Episodio[] episodios;
    private int numEpisodios;

    public Temporada(int codigo) {
        this.codigo = "TEMP" + codigo;
    }

    public Temporada generarEpisodios(int capacidadEpisodios) {
        this.episodios = new Episodio[capacidadEpisodios];
        for (int i = 0; i < capacidadEpisodios; i++) {
            this.numEpisodios++;
            this.episodios[i] = new Episodio(this.numEpisodios);
        }

        return this;
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
}
