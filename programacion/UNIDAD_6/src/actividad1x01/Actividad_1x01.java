package actividad1x01;

import entrada.Teclado;

public class Actividad_1x01 {
    public static void main(String[] args) {
        System.out.println("VIDEOJUEGO 1");
        String nombre = Teclado.leerCadena("Nombre: ");
        String desarrollador = Teclado.leerCadena("Desarrollador: ");
        int anyoLanzamiento = Teclado.leerEntero("Año de lanzamiento: ");
        int maxJugadores = Teclado.leerEntero("Máximo de jugadores: ");

        Videojuego vj = new Videojuego(nombre, desarrollador, anyoLanzamiento, maxJugadores);

        System.out.println(vj.obtenerEstado());

        System.out.println("VIDEOJUEGO 2");
        nombre = Teclado.leerCadena("Nombre: ");
        desarrollador = Teclado.leerCadena("Desarrollador: ");
        anyoLanzamiento = Teclado.leerEntero("Año de lanzamiento: ");

        vj = new Videojuego(nombre, desarrollador, anyoLanzamiento);

        System.out.println(vj.obtenerEstado());

        System.out.println("VIDEOJUEGO 3");
        nombre = Teclado.leerCadena("Nombre: ");
        desarrollador = Teclado.leerCadena("Desarrollador: ");

        vj = new Videojuego(nombre, desarrollador);

        System.out.println(vj.obtenerEstado());
    }
}
