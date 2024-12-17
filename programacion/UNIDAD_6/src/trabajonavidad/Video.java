package trabajonavidad;

import java.util.Random;

public abstract class Video {
    private static int numElementos;

    private static final String[] TITULOS = {
            "El Mago de Oz",
            "Harry Potter",
            "Mary Poppins",
            "Hércules"
    };

    private static final String[] GENEROS = {
            "Accion",
            "Comedia",
            "Crimen",
            "Ciencia",
            "Ficcion",
            "Animacion",
            "Drama",
            "Misterio",
            "Documental"
    };

    protected String codigo;
    protected String titulo;
    protected String genero;
    protected int puntuacion;

    private static String generarTitulo() {
        int i = new Random().nextInt(5);
        return Video.TITULOS[i];
    }

    private static String generarGenero() {
        int i = new Random().nextInt(10);
        return Video.GENEROS[i];
    }


    private static int generarPuntuacion() {
        return new Random().nextInt(10) + 1;
    }

    public Video() {
        this.codigo = "VID" + Video.numElementos;
        this.titulo = generarTitulo();
        this.genero = generarGenero();
        this.puntuacion = generarPuntuacion();
        Video.numElementos++;
    }
}
