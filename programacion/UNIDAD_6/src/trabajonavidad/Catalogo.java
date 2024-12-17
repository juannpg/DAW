package trabajonavidad;

public class Catalogo {
    private Video[] videos;
    private int numElementos;

    public Catalogo(int capacidad) {
        this.videos = new Video[capacidad];
    }
}
