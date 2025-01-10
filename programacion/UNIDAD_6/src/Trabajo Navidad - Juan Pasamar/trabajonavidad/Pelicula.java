package trabajonavidad;

import java.util.Random;

public class Pelicula extends Video {
    private int añoEstreno;
    private int duracion;
    private String director;

    private static final Random R = new Random();

    private static final String[] DIRECTORES = {
      "Manuel",
      "Alicia",
      "Alfonso",
      "Marina",
      "Inés",
      "Kevin"
    };

    public static String getStringDirectores() {
        String directores = "Directores disponibles:\n";
        for (int i = 0; i < Pelicula.getDirectores().length; i++) {
            directores += Pelicula.getDirectores()[i] + "\n";
        }
        directores += "-+-+-+-+-+-+-+-+-+-+-+-";

        return directores;
    }

    /**
     * Busca si un director existe en la lista de directores disponibles.
     * @param director
     * @return
     */
    public static boolean buscarDirector(String director) {
        boolean existe = false;
        for (int i = 0; i < Pelicula.getDirectores().length && !existe; i++) {
            if (director.equalsIgnoreCase(Pelicula.getDirectores()[i])) {
                existe = true;
            }
        }

        return existe;
    }

    private static String generarDirector() {
        int i = Pelicula.R.nextInt(Pelicula.DIRECTORES.length);
        return Pelicula.DIRECTORES[i];
    }

    public Pelicula(int codigo) {
        super(codigo);
        this.añoEstreno = Pelicula.R.nextInt(2025 - 1950 + 1) + 1950;
        this.duracion = Pelicula.R.nextInt(150);
        this.director = Pelicula.generarDirector();
    }

    @Override
    public String toString() {
        return super.toString() + this.añoEstreno + ", " + this.duracion + ", " + this.director + "],";
    }

    public static String[] getDirectores() {
        return Pelicula.DIRECTORES;
    }

    public String getDirector() {
        return this.director;
    }
}
