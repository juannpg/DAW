package videojuego;

public class Almacen {
    private Videojuego[] videojuegos;
    private int numElementos;

    /**
     * constructor con capacidad como parametro
     * @param capacidad capacidad
     */
    public Almacen(int capacidad) {
        this.videojuegos = new Videojuego[capacidad];
        numElementos = 0;
    }

    /**
     * por cada elemento lo suma a un String con sus atributos
     * @return
     */
    public String toString() {
        String resultado = "";
        for (int i = 0; i < numElementos; i++) {
            String append = this.videojuegos[i].toString() + "\n";

            resultado += append;
        }

        return resultado;
    }

    /**
     * inserta un videojuego en el almacen si no está lleno
     * @param videojuego videojuego a insertar
     * @return si ha sido insertado
     */
    public boolean insertar(Videojuego videojuego) {
        boolean insertado = false;

        if (this.numElementos < this.videojuegos.length) {
            this.videojuegos[this.numElementos] = videojuego;
            this.numElementos++;
            insertado = true;
        }

        return insertado;
    }

    /**
     * consulta un videojuego mediante su código
     * @param cod código
     * @return videojuego consultado
     */
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

    /**
     * elimina un videojuego dada su posicion en el vector almacen.
     * los siguientes a ellos los desplaza para agruparlos todos al principio
     * y dejar los nulls al final.
     * @param pos posicion
     * @return si ha sido borrado.
     */
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

    /**
     * suma 1 al stock de los elementos que sean menores que un precio
     * @param precio precio
     * @return numero de modificados
     */
    public int modificaCantidad(double precio) {
        int numModif = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videojuegos[i].getPrecio() < precio) {
                int stock = this.videojuegos[i].getStock();
                this.videojuegos[i].setStock(stock + 1);
                numModif++;
            }
        }

        return numModif;
    }

    /**
     * busca todos los videojuegos dado un stock
     * @param stock stock
     * @return vector de videojuegos
     */
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
