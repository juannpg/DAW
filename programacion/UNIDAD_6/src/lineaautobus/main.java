package lineaautobus;

import entrada.Teclado;

public class main {
    public static LineaAutobus[] crearLineas(int numLineas) {
        LineaAutobus[] vectorLineas = new LineaAutobus[5];

        for (int i = 0; i < numLineas; i++) {
            LineaAutobus linea =  PrincipalLineaAutobus.crearLineaAleatoria();
            comprobarParadas(linea);
            vectorLineas[i] = linea;
        }

        return vectorLineas;
    }

    public static void comprobarParadas(LineaAutobus linea) {
        for (int i = 20; i <= 200; i += 10) {
            if (linea.tieneParada(i)) {
                linea.setFrecuencia(linea.getFrecuencia() + 5);
            }
        }
    }

    public static void main(String[] args) {
        int numParada = Teclado.leerEntero("¿Número de parada? ");

        LineaAutobus[] vectorLineas = crearLineas(5);

        for (int i = 0; i < vectorLineas.length; i++) {
            if (vectorLineas[i].tieneParada(numParada)) {
                System.out.println(vectorLineas[i].toString());
            }
        }
    }
}
