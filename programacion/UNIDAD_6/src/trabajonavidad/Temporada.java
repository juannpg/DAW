package trabajonavidad;

public class Temporada {
    private String codigo;
    private Episodio[] episodios;
    private int numEpisodios;

    public Temporada(int codigo) {
        this.codigo = "TEMP" + codigo;
    }

    public Temporada generarEpisodios(int numEpisodios) {
        this.episodios = new Episodio[numEpisodios];
        
    }
}
