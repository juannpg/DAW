package trabajonavidad;

import java.util.Comparator;

public class OrdenVideosPelisSeries implements Comparator<Video> {
    @Override
    public int compare(Video v1, Video v2) {
        if (v1 instanceof Pelicula && v2 instanceof Serie) {
            return 1;
        } else if (v1 instanceof Serie && v2 instanceof Pelicula) {
            return -1;
        } else {
            return v1.getTitulo().compareTo(v2.getTitulo());
        }
    }
}
