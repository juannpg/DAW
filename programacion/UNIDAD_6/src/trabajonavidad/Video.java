package trabajonavidad;

import java.util.GregorianCalendar;
import java.util.Random;

public abstract class Video {
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

    private static final String[] PAISES = {
            "España",
            "Francia",
            "Italia",
            "Alemania",
            "Moldavia",
            "Argentina",
            "Reino Unido"
    };

    protected static GregorianCalendar[] AÑOS = {
            new GregorianCalendar(1990, GregorianCalendar.JANUARY, 1),
            new GregorianCalendar(1995, GregorianCalendar.JANUARY, 1),
            new GregorianCalendar(2000, GregorianCalendar.JANUARY, 1),
            new GregorianCalendar(2005, GregorianCalendar.JANUARY, 1),
            new GregorianCalendar(2010, GregorianCalendar.JANUARY, 1),
            new GregorianCalendar(2015, GregorianCalendar.JANUARY, 1),
            new GregorianCalendar(2020, GregorianCalendar.JANUARY, 1)
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

    public static GregorianCalendar getAño(int i) {
        return Video.AÑOS[i];
    }

    @Override
    public String toString() {
        return "\t\t[" + this.codigo + ", " + this.titulo + ", " + this.genero + ", " + this.pais +
                ", " + this.puntuacion + "/10, ";
    }
}
