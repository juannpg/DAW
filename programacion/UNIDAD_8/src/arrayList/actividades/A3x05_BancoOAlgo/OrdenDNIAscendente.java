package arrayList.actividades.A3x05_BancoOAlgo;

import java.util.Comparator;

public class OrdenDNIAscendente implements Comparator<Cliente> {

    @Override
    public int compare(Cliente o1, Cliente o2) {
        return o1.getDni().compareTo(o2.getDni());
    }
}
