package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorApellidos implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getApellidos().toLowerCase().compareTo(t2.getApellidos().toLowerCase());
    }
}
