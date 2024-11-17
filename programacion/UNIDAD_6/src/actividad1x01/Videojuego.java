package actividad1x01;

public class Videojuego {
    private String nombre;
    private String desarrollador;
    private int anyoLanzamiento;
    private int maxJugadores;

    public Videojuego(String nombre, String desarrollador, int anyoLanzamiento, int maxJugadores) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.anyoLanzamiento = anyoLanzamiento;
        this.maxJugadores = maxJugadores;
    }

    public Videojuego(String nombre, String desarrollador, int anyoLanzamiento) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.anyoLanzamiento = anyoLanzamiento;
        this.maxJugadores = 1;
    }

    public Videojuego(String nombre, String desarrollador) {
        this.nombre = nombre;
        this.desarrollador = desarrollador;
        this.anyoLanzamiento = 2021;
        this.maxJugadores = 1;
    }

    public String obtenerEstado() {
        return "Videojuego [Título = " + this.nombre + ", Desarrollador = " + this.desarrollador + ", Año de lanzamiento = " + this.anyoLanzamiento + ", Máximo de jugadores = " + this.maxJugadores + "]";
    }
}
