package videojuego;

public class Almacen {
    private Videojuego[] videojuegos;
    private int numElementos;

    public Almacen(int capacidad) {
        this.videojuegos = new Videojuego[capacidad];
        numElementos = 0;
    }

    public String toString() {
        String resultado = "";
        for (int i = 0; i < numElementos; i++) {
            String append = i
                + " Videojuego[Código=" + this.videojuegos[i].getCodigo()
                + ", Título=" + this.videojuegos[i].getTitulo()
                + ", Precio=" + this.videojuegos[i].getPrecio()
                + ", Cantidad=" + this.videojuegos[i].getStock()
            ;

            resultado += append;
        }

        return resultado;
    }

    public boolean insertar(Videojuego videojuego) {
        boolean insertado = false;

        if (this.numElementos < this.videojuegos.length) {
            this.videojuegos[this.numElementos] = videojuego;
            this.numElementos++;
            insertado = true;
        }

        return insertado;
    }

    public Videojuego consultar(int cod) {
        boolean encontrado = false;
        Videojuego videojuego = null;
        for (int i = 0; i < numElementos && !encontrado; i++) {
            if (this.videojuegos[i].getCodigo() == cod) {
                videojuego = this.videojuegos[i];
            }
        }

        return videojuego;
    }

    public boolean eliminar(int pos) {
        boolean borrado = false;
        for (int i = 0; i < this.numElementos && !borrado; i++) {
            if (this.videojuegos[i] != null && i == pos) {
                this.videojuegos[i] = null;
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

    public int modificaCantidad(float precio) {
        int numModif = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videojuegos[i].getPrecio() == precio) {
                int stock = this.videojuegos[i].getStock();
                this.videojuegos[i].setStock(stock + 1);
                numModif++;
            }
        }

        return numModif;
    }

    public Videojuego[] buscaVideojuegos(int stock) {
        int numCoincidencias = 0;
        for (int i = 0; i < numElementos; i++) {
            if (this.videojuegos[i].getStock() == stock) {
                numCoincidencias++;
            }
        }

        Videojuego[] devolver = new Videojuego[numCoincidencias];
        for (int i = 0; i < numElementos; i++) {
            if (this.videojuegos[i].getStock() == stock) {
                devolver[i] = this.videojuegos[i];
            }
        }

        return devolver;
    }
}
