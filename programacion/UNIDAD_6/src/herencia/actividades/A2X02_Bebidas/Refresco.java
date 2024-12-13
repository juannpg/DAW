package herencia.actividades.A2X02_Bebidas;

import java.util.Random;

public class Refresco extends Bebida{
    private static final String[] NOMBRES = {
            "limonada",
            "cola",
            "gaseosa",
            "té helado",
            "granizado",
            "ponche"
    };

    private static String generarNombre() {
        int i = new Random().nextInt(NOMBRES.length);
        return NOMBRES[i];
    }

    private static int generarAzucar() {
        return new Random().nextInt(35 - 4 + 1) + 4;
    }

    private boolean tieneGas;
    private int cantidadAzucar;

    public Refresco() {
        super(generarNombre());
        this.tieneGas = new Random().nextBoolean();
        this.cantidadAzucar = generarAzucar();
    }

    public double calcularPrecio() {
        return 1 + ((double) this.cantidadAzucar / 10);
    }
}
