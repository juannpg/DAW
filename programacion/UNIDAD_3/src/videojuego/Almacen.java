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
     * inserta un videojego al inicio del vector. Para ello
     * desplaza todos los elementos del vector una poiscion hacia delante
     * @param videojuego
     * @return
     */
    public boolean insertarPrincipio(Videojuego videojuego) {
        boolean insertado = false;

        if (this.numElementos < this.videojuegos.length) {
            for (int i = numElementos; i > 0; i--) {
                videojuegos[i + 1] = videojuegos[i];
            }

            this.videojuegos[0] = videojuego;
            this.numElementos++;
            insertado = true;
        }

        return insertado;
    }

    /**
     * elimina un videojuego dada su posicion en el vector almacen y disminuye en 1 el total.
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
                encontrado = true;
            }
        }

        return videojuego;
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
            boolean insertado = false;
            for (int j = 0; j < numCoincidencias && !insertado; j++) {
                if (devolver[j] == null) {
                    if (this.videojuegos[i].getStock() == stock) {
                        devolver[j] = this.videojuegos[i];
                        insertado = true;
                    }
                }
            }
        }

        return devolver;
    }

    /**
     * buscar videojuegos con stock a 1
     */
    public Videojuego[] buscaVideojuegosStock(int stock) {
        int numCoincidencias = 0;
        for (int i = 0; i < numElementos; i++) {
            if (this.videojuegos[i].getStock() == stock) {
                numCoincidencias++;
            }
        }

        Videojuego[] devolver = new Videojuego[numCoincidencias];
        for (int i = 0; i < numElementos; i++) {
            boolean insertado = false;
            for (int j = 0; j < numCoincidencias && !insertado; j++) {
                if (devolver[j] == null) {
                    if (this.videojuegos[i].getStock() == stock) {
                        devolver[j] = this.videojuegos[i];
                        insertado = true;
                    }
                }
            }
        }

        return devolver;
    }

    /**
     * devolver vidoejugo de mayor precio
     */
    public Videojuego buscarMayorPrecio() {
        if (numElementos == 0) {
            return null;
        }

        Videojuego precioMayor = this.videojuegos[0];
        for (int i = 0; i < numElementos; i++) {
            if (this.videojuegos[i].getPrecio() > precioMayor.getPrecio()) {
                precioMayor = this.videojuegos[i];
            }
        }

        return precioMayor;
    }

    /**
     * Devolver la cantidad de vieojuegos con prcio menor al pasado
     */
    public int buscarMenorPrecio(double precio) {
        int numMenores = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videojuegos[i].getPrecio() < precio) {
                numMenores++;
            }
        }

        return numMenores;
    }
}
