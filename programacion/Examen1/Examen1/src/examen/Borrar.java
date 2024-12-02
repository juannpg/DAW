package examen;

public class Borrar {
	 public boolean eliminar(int pos) {
	        boolean borrado = false;
	        for (int i = 0; i < this.numElementos && !borrado; i++) {
	            if (this.videojuegos[i] != null && i == pos) {
	                this.videojuegos[i] = null;
	                Videojuego.setTotal(Videojuego.getTotal() - 1);
	                borrado = true;
	            }
	        }

	        for (int i = 0; i < this.numElementos; i++) {
	            boolean movido = false;
	            if (this.videojuegos[i] == null) {
	                for (int j = i + 1; j < this.numElementos && !movido; j++) {
	                    if (this.videojuegos[j] != null) {
	                        this.videojuegos[i] = this.videojuegos[j];
	                        this.videojuegos[j] = null;
	                        movido = true;
	                    }
	                }
	            }
	        }

	        this.numElementos--;
	        return borrado;
	    }
}
