package lineaautobus;

import java.util.Arrays;

public class LineaAutobus {
    private String numLinea;
    private float precio;
    private int frecuencia;
    private int[] paradas;

    public LineaAutobus(String numLinea, float precio, int frecuencia, int[] paradas) {
        this.numLinea = numLinea;
        this.precio = precio;
        this.frecuencia = frecuencia;
        this.paradas = paradas;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getNumLinea() {
        return numLinea;
    }

    public float getPrecio() {
        return precio;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public int[] getParadas() {
        return paradas;
    }

    public String toString() {
        return "LineaAutobus{" +
                "numLinea='" + numLinea + '\'' +
                ", precio=" + precio + '\n' +
                ", frecuencia=" + frecuencia +
                ", paradas=" + Arrays.toString(paradas) +
                '}';
    }

    public boolean tieneParada(int parada) {
        boolean tieneParada = false;

        for (int i = 0; i < paradas.length; i++) {
            if (paradas[i] == parada) {
                tieneParada = true;
            }
        }

        return tieneParada;
    }
}
