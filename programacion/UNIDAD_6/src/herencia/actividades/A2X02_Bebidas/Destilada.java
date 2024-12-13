package herencia.actividades.A2X02_Bebidas;

import java.util.Random;

public class Destilada extends Alcoholica {
    private static final String[] NOMBRES = {
            "anís",
            "pacharán",
            "ginebra",
            "cognac",
            "rona",
            "vodka",
            "whisky",
            "tequila"
    };

    private static String generarNombre() {
        int i = new Random().nextInt(NOMBRES.length);
        return NOMBRES[i];
    }

    private static double generarGraduacion() {
        return new Random().nextDouble() * ((45.0 - 15.0) + 15.0);
    }

    public Destilada() {
        super(generarNombre(), generarGraduacion());
    }

    public double calcularPrecio() {
        return 12 + (this.graduacion / 10);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Destilada{" +
                "graduacion=" + graduacion +
                "} ";
    }
}
