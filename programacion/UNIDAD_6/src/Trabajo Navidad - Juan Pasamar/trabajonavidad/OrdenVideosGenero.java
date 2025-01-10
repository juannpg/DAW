package trabajonavidad;

import java.util.Comparator;

public class OrdenVideosGenero implements Comparator<Video> {
    @Override
    public int compare(Video v, Video v2) {
        return v.getGenero().compareTo(v2.getGenero());
    }
}
