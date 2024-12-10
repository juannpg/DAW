package lineaautobus;

import java.util.Arrays;

public class prueba {
    public static void main(String[] args) {
        int[] lineas = new int[10];
        int numElementos = 10;

        // seis 1s y cuatro 0s
        lineas[0] = 1;
        lineas[1] = 1;
        lineas[2] = 0;
        lineas[3] = 0;
        lineas[4] = 1;
        lineas[5] = 1;
        lineas[6] = 0;
        lineas[7] = 1;
        lineas[8] = 0;
        lineas[9] = 1;

        System.out.println("SIN MOVER HACIA ATRÁS LOS NO NULOS");
        System.out.println(Arrays.toString(lineas));

        for (int i = 0; i < numElementos; i++) {
            boolean movido = false;
            if (lineas[i] == 0) {
                for (int j = i + 1; j < numElementos && !movido; j++) {
                    if (lineas[j] != 0) {
                        lineas[i] = lineas[j];
                        lineas[j] = 0;
                        movido = true;
                    }
                }
            }
        }

        System.out.println("MOVIDOS");
        System.out.println(Arrays.toString(lineas));
    }
}
