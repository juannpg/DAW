package herencia.actividades.A2X02_Bebidas;

import java.util.Arrays;
import java.util.Random;

public class Inventario {
    private Bebida[] bebidas;
    private static int numElementos;

    public Inventario(int capacidad) {
        this.bebidas = new Bebida[capacidad];
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "bebidas=" + Arrays.toString(bebidas) +
                '}';
    }

    public int[] generarBebidasAleatorias(int numBebidas) {
        int[] devolver = {0, 0, 0};
        for (int i = 0; i < numBebidas && numElementos < this.bebidas.length; i++) {
            int random = new Random().nextInt(3);
            if (random == 1) {
                this.bebidas[i] = new Refresco();
                devolver[0]++;
            } else if (random == 2) {
                this.bebidas[i] = new Fermentada();
                devolver[1]++;
            } else {
                this.bebidas[i] = new Fermentada();
                devolver[2]++;
            }

            Inventario.numElementos++;
        }

        return devolver;
    }

    
}
