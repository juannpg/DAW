package lineaautobus;

import java.util.Arrays;

public class Avanza {
    private LineaAutobus[] lineas;
    private int numElementos;

    public Avanza(int maxLineas) {
        this.lineas = new LineaAutobus[maxLineas];
        numElementos = 0;
    }

    public void addLinea(LineaAutobus linea) {
        this.lineas[this.numElementos] = linea;
        this.numElementos++;
    }

    public LineaAutobus[] getLineas() {
        return lineas;
    }

    public String toString() {
        return "Avanza{" +
                "lineas=" + Arrays.toString(lineas) +
                '}';
    }

    public void borrarLinea(LineaAutobus linea) {
        boolean borrado = false;
        for (int i = 0; i < this.numElementos && !borrado; i++) {
            if (this.lineas[i].getNumLinea().equals(linea.getNumLinea())) {
                this.lineas[i] = null;
                borrado = true;
            }
        }
    }

    public void modificarLinea(LineaAutobus linea) {
        boolean modificado = false;
        for (int i = 0; i < this.numElementos && !modificado; i++) {
            if (this.lineas[i].getNumLinea().equals(linea.getNumLinea())) {
                this.lineas[i] = linea;
                modificado = true;
            }
        }
    }
}