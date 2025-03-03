import java.util.Comparator;

public class Orden implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 == o2) {
            // si son iguales devolvemos comparador por clave para poder tener duplicados
            return 0;
        } else if (o1 < o2) {
            return 1;
        } else {
            return -1;
        }
    }
}
