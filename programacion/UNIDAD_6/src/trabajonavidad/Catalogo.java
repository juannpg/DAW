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

    public int getNumElementos() {
        return numElementos;
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
        String strPeliculas = "\t\tPelículas {\n";
        String strSeries = "\t\tSeries {\n";
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i] instanceof Pelicula) {
                strPeliculas += this.videos[i].toString() + "\n";
            } else {
                strSeries += this.videos[i].toString() + "\n";
            }
        }

        strPeliculas += "\t\t}\n";
        strSeries += "\t\t}";

        return strPeliculas + strSeries;
    }

    @Override
    public String toString() {
        return this.nombre + " {\n\tVideos {\n" + this.generarStringVideos() + "\n\t}\n}";
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

    public Video getVideo(int indice) {
        return this.videos[indice];
    }

    public boolean eliminarVideo(int pos) {
        if (pos < 0 || pos >= this.numElementos) {
            return false;
        }

        boolean borrado = false;
        for (int i = 0; i < this.numElementos && !borrado; i++) {
            if (this.videos[i] != null && i == pos) {
                this.videos[i] = null;
                borrado = true;
            }
        }

        for (int i = 0; i < this.numElementos; i++) {
            boolean movido = false;
            if (this.videos[i] == null) {
                for (int j = i + 1; j < this.numElementos && !movido; j++) {
                    if (this.videos[j] != null) {
                        this.videos[i] = this.videos[j];
                        this.videos[j] = null;
                        movido = true;
                    }
                }
            }
        }

        this.numElementos--;
        return true;
    }
}
