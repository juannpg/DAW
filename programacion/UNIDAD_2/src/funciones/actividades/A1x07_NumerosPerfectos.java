package funciones.actividades;

public class A1x07_NumerosPerfectos {
    /**
     * acepta un parametro num entero, y devuelve
     * si es un "numero perfecto"
     * @param num
     * @return
     */
    public static boolean esPerfecto(int num) {
        int sumaDivisores = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                sumaDivisores += i;
            }
        }

        return num == sumaDivisores;
    }

    /**
     * imprime por consola todos los numeros
     * perfectos de 1 a un LIMITE
     * @param args
     */
    public static void main(String[] args) {
        final int LIMITE = 10000;
        for (int i = 1; i <= LIMITE; i++) {
            if (esPerfecto(i)) {
                System.out.printf("El número %d es perfecto.\n", i);
            }
        }
    }
}
