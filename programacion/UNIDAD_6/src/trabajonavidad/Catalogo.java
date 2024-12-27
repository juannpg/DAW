package trabajonavidad;

import java.util.Random;

public class Catalogo {
    private String nombre;
    private Video[] videos;
    private int numElementos;

    public Catalogo(String nombre, int capacidad) {
        this.nombre = nombre;
        this.videos = new Video[capacidad];
    }

    public boolean insertarPelicula(Pelicula p) {
        if (this.numElementos < this.videos.length) {
            this.videos[this.numElementos] = p;
            this.numElementos++;
            return true;
        }

        return false;
    }

    public boolean insertarSerie(Serie s) {
        if (this.numElementos < this.videos.length) {
            this.videos[this.numElementos] = s;
            this.numElementos++;
            return true;
        }

        return false;
    }

    public int[] generarVideosAleatorios(int numVideos) {
        int[] contadorVideos = {0, 0};
        for (int i = 0; i < numVideos && numElementos < this.videos.length; i++) {
            int random = new Random().nextInt(2);
            if (random == 0) {
                this.videos[i] = new Pelicula(this.numElementos);
                contadorVideos[0]++;
            } else {
                this.videos[i] = new Serie(this.numElementos);
                contadorVideos[1]++;
            }

            this.numElementos++;
        }

        return contadorVideos;
    }

    public String generarStringVideos() {
        String strVideos = "";
        for (int i = 0; i < this.numElementos; i++) {
            strVideos += this.videos[i].toString() + "\n";
        }

        return strVideos;
    }

    @Override
    public String toString() {
        return this.nombre + " {\n\tVideos {\n" + this.generarStringVideos() + "\n}";
    }
}
