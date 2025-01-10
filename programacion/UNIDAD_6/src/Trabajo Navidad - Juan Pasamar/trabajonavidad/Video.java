package trabajonavidad;

import java.util.Random;

public abstract class Video {
    private static final String[] TITULOS = {
            "El Mago de Oz",
            "Harry Potter",
            "Mary Poppins",
            "Hércules"
    };

    private static final String[] GENEROS = {
            "Acción",
            "Comedia",
            "Crimen",
            "Ciencia",
            "Ficción",
            "Animación",
            "Drama",
            "Misterio",
            "Documental"
    };

    private static final String[] PAISES = {
            "España",
            "Francia",
            "Italia",
            "Alemania",
            "Moldavia",
            "Argentina",
            "Reino Unido"
    };

    protected String codigo;
    protected String titulo;
    protected String genero;
    protected String pais;
    protected int puntuacion;

    private static String generarTitulo() {
        int i = new Random().nextInt(Video.TITULOS.length);
        return Video.TITULOS[i];
    }

    private static String generarGenero() {
        int i = new Random().nextInt(Video.GENEROS.length);
        return Video.GENEROS[i];
    }

    private static String generarPais() {
        int i = new Random().nextInt(Video.PAISES.length);
        return Video.PAISES[i];
    }

    private static int generarPuntuacion() {
        return new Random().nextInt(10) + 1;
    }

    public Video(int codigo) {
        this.codigo = "VID" + codigo;
        this.titulo = generarTitulo();
        this.genero = generarGenero();
        this.pais = generarPais();
        this.puntuacion = generarPuntuacion();
    }

    @Override
    public String toString() {
        return "\t\t\t[" + this.codigo + ", "  + this.titulo + ", " + this.genero + ", " + this.pais +
                ", " + this.puntuacion + "/10, ";
    }

    public static String[] getGeneros() {
        return Video.GENEROS;
    }

    public static String getStringGeneros() {
        String generos = "Géneros disponibles:\n";
        for (int i = 0; i < Video.getGeneros().length; i++) {
            generos += Video.getGeneros()[i] + "\n";
        }
        generos += "-+-+-+-+-+-+-+-+-+-+-+-";

        return generos;
    }

    /**
     * busca si un género existe en la lista de géneros disponibles
     * @param genero
     * @return
     */
    public static boolean buscarGenero(String genero) {
        boolean existe = false;
        for (int i = 0; i < Video.getGeneros().length && !existe; i++) {
            if (genero.equalsIgnoreCase(Video.getGeneros()[i])) {
                existe = true;
            }
        }

        return existe;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }
}
