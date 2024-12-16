package herencia.actividades.A2X02_Bebidas;

import java.util.Arrays;
import java.util.Random;

public class Inventario {
    private Bebida[] bebidas;
    private int numElementos;

    public Inventario(int capacidad) {
        this.bebidas = new Bebida[capacidad];
    }

    @Override
    public String toString() {
        String devolver = "";
        for (int i = 0; i < this.numElementos; i++) {
           devolver += "(" + i + ") " + this.bebidas[i].toString() + "\n";
        }

        return devolver;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public boolean insertarBebida(Bebida bebida) {
        if (this.numElementos < this.bebidas.length) {
            this.bebidas[this.numElementos] = bebida;
            this.numElementos++;
            return true;
        }

        return false;
    }

    public int[] generarBebidasAleatorias(int numBebidas) {
        int[] contadorBebidas = {0, 0, 0};
        for (int i = 0; i < numBebidas && numElementos < this.bebidas.length; i++) {
            int random = new Random().nextInt(3);
            if (random == 0) {
                this.bebidas[i] = new Refresco();
                contadorBebidas[0]++;
            } else if (random == 1) {
                this.bebidas[i] = new Fermentada();
                contadorBebidas[1]++;
            } else {
                this.bebidas[i] = new Destilada();
                contadorBebidas[2]++;
            }

            this.numElementos++;
        }

        return contadorBebidas;
    }

    public Inventario consultarRefrescos() {
        int contadorRefrescos = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (bebidas[i] instanceof Refresco) {
                contadorRefrescos++;
            }
        }

        Inventario inventarioRefrescosEncontrados = new Inventario(contadorRefrescos);
        for (int i = 0; i < this.numElementos; i++) {
            if (bebidas[i] instanceof Refresco) {
                inventarioRefrescosEncontrados.insertarBebida(bebidas[i]);
            }
        }

        return inventarioRefrescosEncontrados;
    }

    public Inventario consultarFermentadas() {
        int contadorFermentadas = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (bebidas[i] instanceof Fermentada) {
                contadorFermentadas++;
            }
        }

        Inventario inventarioFermentadasEncontrados = new Inventario(contadorFermentadas);
        for (int i = 0; i < this.numElementos; i++) {
            if (bebidas[i] instanceof Fermentada) {
                inventarioFermentadasEncontrados.insertarBebida(bebidas[i]);
            }
        }

        return inventarioFermentadasEncontrados;
    }

    public Inventario consultarDestiladas() {
        int contadorDestiladas = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (bebidas[i] instanceof Destilada) {
                contadorDestiladas++;
            }
        }

        Inventario inventarioDestiladasEncontrados = new Inventario(contadorDestiladas);
        for (int i = 0; i < this.numElementos; i++) {
            if (bebidas[i] instanceof Destilada) {
                inventarioDestiladasEncontrados.insertarBebida(bebidas[i]);
            }
        }

        return inventarioDestiladasEncontrados;
    }

    public Inventario consultarBebidasEntreDosPrecios(double min, double max) {
        int contadorBebidas = 0;
        for (int i = 0; i < this.numElementos; i++) {
            double precioBebida = bebidas[i].calcularPrecio();
            if (precioBebida <= max && precioBebida >= min) {
                contadorBebidas++;
            }
        }

        Inventario inventarioBebidasEncontradas = new Inventario(contadorBebidas);
        int numBebidas = 0;
        for (int i = 0; i < this.numElementos; i++) {
            double precioBebida = bebidas[i].calcularPrecio();
            if (precioBebida <= max && precioBebida >= min) {
                inventarioBebidasEncontradas.insertarBebida(bebidas[i]);
                numBebidas++;
            }
        }

        return inventarioBebidasEncontradas;
    }

    public int numeroRefrescosGaseosos() {
        int contadorGaseosos = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (this.bebidas[i] instanceof Refresco && ((Refresco) bebidas[i]).isTieneGas()) {
                contadorGaseosos++;
            }
        }

        return contadorGaseosos;
    }
}