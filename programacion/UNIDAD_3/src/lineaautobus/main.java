package lineaautobus;

import entrada.Teclado;

public class main {
    public static LineaAutobus[] crearLineas(int numLineas) {
        LineaAutobus[] vectorLineas = new LineaAutobus[numLineas];

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

        // crea un vector que contiene cinco lienas de autobús y las añade a avanza.
        LineaAutobus[] vectorLineas = crearLineas(5);
        Avanza avanza = new Avanza(20);
        for (int i = 0; i < vectorLineas.length; i++) {
            avanza.addLinea(vectorLineas[i]);
        }

        for (int i = 0; i < vectorLineas.length; i++) {
            if (avanza.getLineas()[i].tieneParada(numParada)) {
                System.out.println(vectorLineas[i].toString());
            }
        }

        final int LINEA_A_BORRAR = 2;
        avanza.borrarLinea(vectorLineas[LINEA_A_BORRAR]);

        System.out.println(avanza.toString());
    }
}
