package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorTelefono implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getTelefono().compareTo(t2.getTelefono());
    }
}
