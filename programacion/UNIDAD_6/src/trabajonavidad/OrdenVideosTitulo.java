package trabajonavidad;

import java.util.Comparator;

public class OrdenVideosTitulo implements Comparator<Video> {
    @Override
    public int compare(Video v1, Video v2) {
        return v1.getTitulo().compareTo(v2.getTitulo());
    }
}
