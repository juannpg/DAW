import java.util.LinkedList;
import java.util.TreeSet;

public class DoubleCuotaMaxima {
    public LinkedList<Socio> obtenerSociosMaxCuotas() {
        TreeSet<Socio> setSocios = new TreeSet<>(new SocioCuotaDni());
        setSocios.addAll(this.mapaSocios.values());

        double cuotaMax = setSocios.getFirst().calcularCuotaMensual();
        LinkedList<Socio> linked = new LinkedList<>();
        for (Socio s : setSocios) {
            if (s.calcularCuotaMensual() == cuotaMax) {
                linked.add(s);
            } else break;
        }

        return linked;
    }
}
