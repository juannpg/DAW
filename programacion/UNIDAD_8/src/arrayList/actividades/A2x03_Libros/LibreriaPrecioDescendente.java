package arrayList.actividades.A2x03_Libros;

import java.util.Comparator;

public class LibreriaPrecioDescendente implements Comparator<Libro> {
    @Override
    public int compare(Libro o1, Libro o2) {
        if (o1.getEuros() > o2.getEuros()) {
            return -1;
        } else if (o1.getEuros() < o2.getEuros()) {
            return 1;
        } else {
            return 0;
        }
    }
}
