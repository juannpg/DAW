package funciones.actividades;
import java.util.Scanner;

public class A1x03_CapicuasEntreNums {
    /*
     * esta función inverte un número.
     */
    public static int invertir(int num) {
        int invertido = 0, digito;
        /*
         * este bucle invierte el numero de la siguiente manera:
         * consigue el resto de dividir el numero entre 10, de tal manera que obtenemos su ultimo digito:
         *          num = 1234 -> num % 10 = 4 <------ ultimo digito
         * además, multiplica invertido (cuyo valor en la primera iteracion
         * es 0) por 10 para "dejarle hueco" al ultimo digito y se lo añadimos:
         *          invertido = 0 * 10 + ultimo digito = 4
         * ahora, divide el numero por 10 para ir a por el siguiente digito.
         *          num = 1234 -> num / 10 = 123
         *
         * AHORA INVERTIDO VALE 4
         * multiplicamos invertido por 10 para dejarle hueco al ultimo digito
         *          invertido = 4 * 10 = 40
         * hacemos el modulo de num para obtener el ultimo digito
         *          num = 123 -> num % 10 = 3
         * le añadimos el ultimo digito al invertido
         *          invertido = 40 + 3 = 43
         * dividimos num por 10 para ir a por el siguiente digito
         *          num = 123 -> num / 10 = 12
         *
         * y así hasta que num valga 0 o menos, lo que detiene el bucle ya que no tenemos más digitos,
         */
        while (num > 0) {
            invertido *= 10;
            digito = num % 10;
            invertido = invertido + digito;
            num /= 10;
        }

        return invertido;
    }

    /*
     * el programa pide por teclado un numero inicial y uno final,
     * y calcula las capicúas entre ellos para imprimir las capicuas
     * y el numero de capicuas encontradas por consola
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Número Inicial? ");
        int numInicial = sc.nextInt();
        System.out.print("¿Número Final? ");
        int numFinal = sc.nextInt();
        sc.close();

        boolean err = false;
        if (numInicial > numFinal) {
            System.out.println("El número inicial debe ser menor o igual que el número final.");
            err = true;
        }

        if (numInicial < 1 || numFinal < 1) {
            System.out.println("El número inicial y final deben ser mayores que 0.");
            err = true;
        }

        if (!err) {
            int numCapicuas = 0;
            // por cada numero entre el inicial y el final, lo comprueba con su invertido.
            // si coinciden, lo imprime por consola.
            for (int i = numInicial; i <= numFinal; i++) {
                if (i == invertir(i)) {
                    System.out.printf("%d ", i);
                    numCapicuas++;
                }
            }
            System.out.println();
            System.out.printf("Número de Capicúas: %d", numCapicuas);
        }
    }
}
