/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package funciones.silani;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class ModularA1x09 {


    public static int calcularMaximoComunDivisor (int num1, int num2){
        int aux;

        while (num2 != 0){
            aux = num2;
            num2 = num1 % num2;
            num1 = aux;
        }
        return num1;
    }

    public static int calcularMinimoComunMultiplo (int num1, int num2){
        int minimoComunMultiplo;

        minimoComunMultiplo = num1 * num2 / calcularMaximoComunDivisor (num1, num2);

        return minimoComunMultiplo;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int num1, num2;
        int respuesta = 1;

        do {
            System.out.println("Introduce el primer numero: ");
            num1 = teclado.nextInt();
            System.out.println("Introdcue el segundo numero: ");
            num2 = teclado.nextInt();

            if (num1 > 0 && num2 > 0){
                System.out.println("Maximo comun divisor de " + num1 + " y " + num2 + ": " + calcularMaximoComunDivisor (num1,num2));
                System.out.println("Minimo comun multiplo de " + num1 + " y " + num2 + ": " + calcularMinimoComunMultiplo (num1,num2));
            } else {
                System.out.println("Introduce numeros positivos");
            }

            System.out.println("Desea procesar otro par de numero (0 para salir)?");
            respuesta = teclado.nextInt();
        } while (respuesta != 0);
    }
}
