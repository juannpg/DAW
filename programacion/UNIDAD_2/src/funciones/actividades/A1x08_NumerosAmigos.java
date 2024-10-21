package funciones.actividades;

public class A1x08_NumerosAmigos {
    /**
     * suma todos los divisores de un parametro entero y la devuelve
     * @param num
     * @return
     */
    public static int sumarDivisores(int num) {
        int sumaDivisores = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores;
    }

    /**
     * comprueba si dos numeros "son amigos" (cuando la suma de los divisores
     * de uno es igual al otro numero, y viceversa)
     * @param num1
     * @param num2
     * @return
     */
    public static boolean sonAmigos(int num1, int num2) {
        return sumarDivisores(num1) == num2 && sumarDivisores(num2) == num1;
    }

    /**
     * imprime por consola los numeros amigos del 1 a un limite.
     * @param args
     */
    public static void main(String[] args) {
        final int LIMITE = 500;
        for (int i = 1; i <= LIMITE; i++) {
            for (int j = 1; j <= LIMITE; j++) {
                if (sonAmigos(i, j)) {
                    System.out.printf("Los números %d y %d son amigos\n", i, j);
                }
            }
        }
    }
}
