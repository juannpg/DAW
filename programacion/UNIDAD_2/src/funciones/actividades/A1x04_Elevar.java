package funciones.actividades;

public class A1x04_Elevar {
    /**
     * eleva un numero base a un exponente
     * @param base
     * @param exp
     * @return
     */
    public static int elevar(int base, int exp) {
        int elevado = 1;
        for (int i = 1; i <= exp; i++) {
            elevado *= base;
        }

        return elevado;
    }

    /**
     * imprime por pantalla los numeros del 1 al 9 elevados del 2 al 6
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 6; j++) {
                if (j != 6) {
                    System.out.printf("%d ^ %d = %6d, ", i, j, elevar(i, j));
                } else {
                    System.out.printf("%d ^ %d = %6d", i, j, elevar(i, j));
                }
            }
            System.out.println();
        }
    }
}
