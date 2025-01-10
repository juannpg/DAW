package trabajonavidad;

import java.util.Comparator;

public class OrdenVideosPuntuacionTitulo implements Comparator<Video>{
    @Override
    public int compare(Video v1, Video v2) {
        if (v1.getPuntuacion() > v2.getPuntuacion()) {
            return 1;
        } else if (v1.getPuntuacion() < v2.getPuntuacion()) {
            return -1;
        } else {
            return v1.getTitulo().compareTo(v2.getTitulo());
        }
    }
}
