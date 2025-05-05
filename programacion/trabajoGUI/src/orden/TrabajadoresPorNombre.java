package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorNombre implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getNombre().toLowerCase().compareTo(t2.getNombre().toLowerCase());
    }
}
