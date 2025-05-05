package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorDireccion implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getDireccion().toLowerCase().compareTo(t2.getDireccion().toLowerCase());
    }
}
