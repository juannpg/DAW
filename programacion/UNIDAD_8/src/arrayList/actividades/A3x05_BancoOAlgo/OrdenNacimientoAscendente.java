package arrayList.actividades.A3x05_BancoOAlgo;

import java.util.Comparator;

public class OrdenNacimientoAscendente implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        if (o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento()) == 0) {
            return o1.getDni().compareTo(o2.getDni());
        }
        return o1.getFechaNacimiento().compareTo(o2.getFechaNacimiento());
    }
}
