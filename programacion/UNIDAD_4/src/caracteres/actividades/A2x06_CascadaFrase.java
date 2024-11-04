package caracteres.actividades;
import entrada.Teclado;

public class A2x06_CascadaFrase {
    public static String leerFrase() {
        final int MAXIMO = 40;
        final int MINIMO = 5;

        String frase;
        do {
            frase = Teclado.leerCadena("¿Frase? ");
            if (frase.length() <= MINIMO || frase.length() > MAXIMO) {
                System.out.println("La frase debe tener 5 caracteres como mínimo.\n" +
                                   "La frase debe tener 40 caracteres como máximo.");
            }
        } while (frase.length() <= MINIMO || frase.length() > MAXIMO);

        return frase;
    }

    public static void cascada(String frase) {
        String cascada = "";
        for (int i = 0; i < frase.length(); i++) {
           cascada += frase.charAt(i);
           System.out.println(cascada);
        }
    }

    public static void main(String[] args) {
        String frase = leerFrase();

        cascada(frase);
    }
}
