package trabajonavidad;

import java.util.Random;

public class Episodio {
    private String titulo;
    private String descripcion;
    private String codigo;

    private static final String[] TITULOS = {
            "La Ventana Roja", "La Puerta Azul", "El Misterio del Lago",
            "Sombras en la Noche", "La Llamada Perdida", "Secretos del Bosque",
            "El Viaje Prohibido", "La Casa Abandonada", "El Silencio Mortal",
            "Más Allá del Horizonte", "La Huella Invisible", "El Último Pasajero",
            "Ecos del Pasado", "El Portal Desconocido", "Niebla en la Ciudad",
            "El Mensaje Oculto", "La Sombra del Enemigo", "Caminos Cruzados",
            "La Voz en la Oscuridad", "El Laberinto Escondido", "Bajo las Estrellas",
            "La Tormenta Perfecta", "En el Corazón del Mar", "Rastros en la Arena",
            "Luz en la Penumbra", "El Último Refugio", "Recuerdos Olvidados",
            "Atrapados en el Tiempo", "El Sueño Eterno", "El Día que Nunca Llegó"
    };

    private static final String[] DESCRIPCIONES = {
            "Un descubrimiento inesperado cambia la vida de todos.",
            "Un viaje misterioso a través de una puerta mágica.",
            "Algo extraño ocurre en las tranquilas aguas del lago.",
            "Sombras inexplicables acechan en la oscuridad.",
            "Un mensaje extraño llega desde un número desconocido.",
            "El bosque guarda secretos que nadie debería descubrir.",
            "Una expedición a un lugar que no debía ser visitado.",
            "Un grupo de amigos explora una casa con un oscuro pasado.",
            "Un sonido en la noche que conduce a un peligro mortal.",
            "Un nuevo mundo se revela al cruzar el horizonte.",
            "Alguien o algo deja huellas que no deberían existir.",
            "Un pasajero en un tren tiene un destino inesperado.",
            "Memorias que regresan para revelar una verdad oculta.",
            "Un portal hacia otra dimensión aparece misteriosamente.",
            "La ciudad se envuelve en una neblina llena de secretos.",
            "Un mensaje codificado podría salvarlos a todos.",
            "Una sombra amenaza con destruirlo todo.",
            "Vidas que se entrelazan de manera inesperada.",
            "Una voz que guía desde la oscuridad.",
            "Un laberinto oculto guarda la clave para escapar.",
            "Un campamento bajo las estrellas guarda sorpresas.",
            "Una tormenta desata un caos nunca antes visto.",
            "Un viaje marítimo lleno de desafíos y misterios.",
            "Pistas que conducen a un hallazgo asombroso.",
            "Un faro ilumina el camino hacia la verdad.",
            "Un refugio que parece seguro, pero no lo es.",
            "Algo olvidado reaparece para cambiarlo todo.",
            "Un grupo queda atrapado en un bucle temporal.",
            "Un sueño se convierte en una pesadilla interminable.",
            "El día más esperado nunca sucede, y el mundo cambia."
    };

    private static String[] generarTituloYDescripcion() {
        String[] tituloDescripcion = new String[2];
        int i = new Random().nextInt(TITULOS.length);
        tituloDescripcion[0] = TITULOS[i];
        tituloDescripcion[1] = DESCRIPCIONES[i];
        return tituloDescripcion;
    }

    public Episodio(int numEpisodio) {
        String[] tituloDescripcion = generarTituloYDescripcion();
        this.titulo = tituloDescripcion[0];
        this.descripcion = tituloDescripcion[1];
        this.codigo = "EPI" + numEpisodio;
    }

    @Override
    public String toString() {
        return "\t\t\t\t\t[" + this.codigo + ", " + this.titulo + ", " + this.descripcion + "],";
    }
}
