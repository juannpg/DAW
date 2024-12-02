package examen;

public class InsertarInicio {
	public boolean insertarPrincipio(Videojuego videojuego) {
	    boolean insertado = false;

	    if (this.numElementos < this.videojuegos.length) {
	        for (int i = numElementos - 1; i >= 0; i--) {
	            videojuegos[i + 1] = videojuegos[i];
	        }

	        this.videojuegos[0] = videojuego;
	        this.numElementos++;
	        insertado = true;
	    }

	    return insertado;
	}
}
