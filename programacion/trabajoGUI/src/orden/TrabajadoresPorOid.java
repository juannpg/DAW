package orden;

import modelo.Trabajador;

import java.util.Comparator;

public class TrabajadoresPorOid implements Comparator<Trabajador> {
    @Override
    public int compare(Trabajador t1, Trabajador t2) {
        return t1.getIdentificador().compareTo(t2.getIdentificador());
    }
}
