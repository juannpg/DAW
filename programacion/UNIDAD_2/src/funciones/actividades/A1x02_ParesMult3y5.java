package funciones.actividades;

public class A1x02_ParesMult3y5 {
    /*
     * comprueba si un número es par
     */
    public static boolean esPar(int num) {
        return num % 2 == 0;
    }

    /*
     * comprueba si un número es multiplo de un determinado número
     */
    public static boolean esMultiplo(int dividendo, int divisor) {
        return dividendo % divisor == 0;
    }

    /*
      * imprime por consola los números pares y los multiplos de 3 y 5 entre 1 y 20
     */
    public static void main(String[] args) {
       System.out.println("Números Pares entre 1 y 20");
       for (int i = 1; i <= 20; i++) {
           if (esPar(i)) {
               System.out.printf("%d ", i);
           }
       }

       System.out.println("\nNumeros Múltiplos de 3 entre 1 y 20");
       for (int i = 1; i <= 20; i++) {
           if (esMultiplo(i, 3)) {
               System.out.printf("%d ", i);
           }
       }

       System.out.println("\nNumeros Múltiplos de 5 entre 1 y 20");
       for (int i = 1; i <= 20; i++) {
           if (esMultiplo(i, 5)) {
               System.out.printf("%d ", i);
           }
       }
    }

}
