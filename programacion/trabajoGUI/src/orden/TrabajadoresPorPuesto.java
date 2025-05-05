package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorPuesto implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getPuesto().toLowerCase().compareTo(t2.getPuesto().toLowerCase());
    }
}
