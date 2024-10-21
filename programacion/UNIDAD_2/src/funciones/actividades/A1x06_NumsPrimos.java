package funciones.actividades;
import java.util.Scanner;

public class A1x06_NumsPrimos {
    /**
     * acepta un parametro entero y devuelve su numero de divisores
     * @param num
     * @return
     */
    public static int contarNumeroDivisores(int num) {
        int divisores = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisores++;
            }
        }
        return divisores;
    }

    /**
     * acetpa un parametro entero y comprueba si es un numero primo
     * @param num
     * @return
     */
    public static boolean esPrimo(int num) {
        return contarNumeroDivisores(num) == 2;
    }

    /**
     * pide dos limites por teclado e imprime por consola
     * los numeros primos entre ellos
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número inicial? ");
        int numInicial = sc.nextInt();
        System.out.print("¿Número final? " );
        int numFinal = sc.nextInt();

        boolean err = false;
        if (numFinal < numInicial) {
            err = true;
            System.out.println("El número inicial debe ser menor o igual que el número final.");
        }

        if (numFinal <= 0 || numInicial <= 0) {
            err = true;
            System.out.println("Los números deben ser positivos.");
        }

        if (!err) {
            int numPrimos = 0;
            for (int i = numInicial; i <= numFinal; i++) {
                if (esPrimo(i)) {
                    System.out.printf("%d ", i);
                    numPrimos++;
                    if (numPrimos % 15 == 0) {
                        System.out.println();
                    }
                }
            }
            System.out.println();
            System.out.printf("Numero de primos: %d", numPrimos);
        }
    }
}
