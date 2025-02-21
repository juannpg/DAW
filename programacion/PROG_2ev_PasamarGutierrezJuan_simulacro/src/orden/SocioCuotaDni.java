package orden;

import clases.Socio;

import java.util.Comparator;

public class SocioCuotaDni implements Comparator<Socio> {

    @Override
    public int compare(Socio o1, Socio o2) {
        if (o1.calcularCuotaMensual() == o2.calcularCuotaMensual()) {
            return o1.getDni().compareTo(o2.getDni());
        } else if (o1.calcularCuotaMensual() < o2.calcularCuotaMensual()) {
            return 1;
        } else {
            return -1;
        }
    }
}
