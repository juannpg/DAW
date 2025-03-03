import java.util.Comparator;

public class ComparatorC implements Comparator<String> {
    @Override
    public int compare(String string1, String string2) {
        return string2.compareTo(string1);
    }
}
