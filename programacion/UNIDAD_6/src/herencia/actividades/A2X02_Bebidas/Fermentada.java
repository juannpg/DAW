package herencia.actividades.A2X02_Bebidas;

import java.util.Random;

public class Fermentada extends Alcoholica{
    private static final String[] NOMBRES = {
            "sidra",
            "cerveza",
            "vino",
            "sake",
            "hidromiel"
    };

    private static String generarNombre() {
        int i = new Random().nextInt(NOMBRES.length);
        return NOMBRES[i];
    }

    private static double generarGraduacion() {
        return new Random().nextDouble() * ((15.0 - 3.5) + 3.5);
    }

    public Fermentada() {
        super(generarNombre(), generarGraduacion());
    }

    public double calcularPrecio() {
        return 5 + (this.graduacion / 10);
    }
}
