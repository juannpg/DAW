package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorDni implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getDni().toLowerCase().compareTo(t2.getDni().toLowerCase());
    }
}
