package trabajonavidad;

import entrada.Teclado;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase que representa un catálogo de videos.
 */
public class Catalogo {
    private String nombre;
    private Video[] videos;
    private int numElementos;

    public Catalogo(String nombre, int capacidad) {
        this.nombre = nombre;
        this.videos = new Video[capacidad];

    }

    /**
     * añade al catalogo un numero de videos porporcionado, decidiendo
     * aleatoriamente si son películas o series, pero asegurando que haya al menos
     * un video de cada tipo
     * @param numVideos
     */
    public void generarVideosAleatorios(int numVideos) {
        numVideos -= 2;
        for (int i = 0; i < numVideos && numElementos < this.videos.length; i++) {
            int random = new Random().nextInt(2);
            if (random == 0) {
                this.videos[i] = new Pelicula(this.numElementos);
            } else {
                this.videos[i] = new Serie(this.numElementos);
            }

            this.numElementos++;
        }

        this.insertarVideoAlFinal(new Serie(this.numElementos));
        this.insertarVideoAlFinal(new Pelicula(this.numElementos));
    }

    /**
     * genera un string con los videos del catálogo formateado
     * @return
     */
    public String generarStringVideos() {
        String strPeliculas = "\t\tPelículas {\n";
        String strSeries = "\t\tSeries {\n";
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i] instanceof Pelicula) {
                strPeliculas += this.videos[i].toString() + "\n";
            } else {
                strSeries += this.videos[i].toString() + "\n";
            }
        }

        strPeliculas += "\t\t}\n";
        strSeries += "\t\t}";

        return strPeliculas + strSeries;
    }

    @Override
    public String toString() {
        return this.nombre + " {\n\tVideos {\n" + this.generarStringVideos() + "\n\t}\n}";
    }

    public int getNumElementos() {
        return numElementos;
    }

    public boolean insertarVideoAlFinal(Video v) {
        if (this.numElementos < this.videos.length) {
            this.videos[this.numElementos] = v;
            this.numElementos++;
            return true;
        }

        return false;
    }

    /**
     * elimina un video por posicion determinada, moviendo los siguientes videos una posicion atras
     * @param pos
     * @return
     */
    public boolean eliminarVideo(int pos) {
        if (pos < 0 || pos >= this.numElementos) {
            return false;
        }

        boolean borrado = false;
        for (int i = 0; i < this.numElementos && !borrado; i++) {
            if (this.videos[i] != null && i == pos) {
                this.videos[i] = null;
                borrado = true;
            }
        }

        for (int i = 0; i < this.numElementos; i++) {
            boolean movido = false;
            if (this.videos[i] == null) {
                for (int j = i + 1; j < this.numElementos && !movido; j++) {
                    if (this.videos[j] != null) {
                        this.videos[i] = this.videos[j];
                        this.videos[j] = null;
                        movido = true;
                    }
                }
            }
        }

        this.numElementos--;
        return true;
    }


    /**
     * case 2. insertar video escogiendo tipo
     * @param opcionVideo
     * @return
     */
    public boolean insertarVideo(int opcionVideo) {
        boolean insertado;
        if (opcionVideo == 0) {
            Pelicula pelicula = new Pelicula(this.numElementos);
            if (this.insertarVideoAlFinal(pelicula)) {
                System.out.println("Pelicula insertada con éxito.");
                insertado = true;
            } else {
                System.out.println("No se pudo insertar la película en el catálogo.");
                insertado = false;
            }
        } else {
            Serie serie = new Serie(this.numElementos);
            if (this.insertarVideoAlFinal(serie)) {
                System.out.println("Serie insertada con éxito.");
                insertado = true;
            } else {
                System.out.println("No se pudo insertar la serie en el catálogo.");
                insertado = false;
            }
        }

        return insertado;
    }

    /**
     * inserta un video en el catalogo
     * @param v
     */
    public void insertarVideo(Video v) {
        this.videos[this.numElementos] = v;
        this.numElementos++;
    }

    /**
     * case 4. consulta todas las peliculas de un director
     * @param director
     * @return
     */
    public String consultarPeliculasPorDirector(String director) {
        String strPeliculas = "";
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i] instanceof Pelicula
                    && ((Pelicula) this.videos[i]).getDirector().equalsIgnoreCase(director)) {
                strPeliculas += this.videos[i].toString() + "\n";
            }
        }

        return strPeliculas;
    }

    /**
     * case 5. busca una serie por año de inicio
     * @param añoInicio
     * @return
     */
    public boolean seriePorAñoInicio(int añoInicio) {
        boolean encontradoSerie;
        encontradoSerie = false;
        for (int i = 0; i < this.numElementos && !encontradoSerie; i++) {
            if (this.videos[i] instanceof Serie
                    && ((Serie) this.videos[i]).getAñoInicio() == añoInicio) {
                System.out.println(this.videos[i].toString());
                encontradoSerie = true;
            }
        }

        return encontradoSerie;
    }

    /**
     * case 6. consultar por genero
     * @param genero
     * @return
     */
    public String consultarVideosPorGenero(String genero) {
        String strVideos = "";
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i].getGenero().equalsIgnoreCase(genero)) {
                strVideos += this.videos[i].toString() + "\n";
            }
        }

        return strVideos;
    }

    /**
     * encuentra un video de cualquier tipo por su código
     * @param tipo
     * @return
     */
    public int encontrarVideoPorCodigo(String tipo) {
        int codigo;
        boolean encontrado;
        do {
            encontrado = false;
            codigo = Teclado.leerEntero("Código de " + tipo + " (0 - " + (this.numElementos - 1) + "): ");
            for (int i = 0; i < this.numElementos && !encontrado; i++) {
                if (this.videos[i].getCodigo().equals("VID" + codigo)) {
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No encontrado.");
            }
        } while (!encontrado);

        return codigo;
    }

    /**
     * encuentra una serie por su código
     * @return
     */
    public int encontrarSeriePorCodigo() {
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i] instanceof Serie) {
                System.out.println(((Serie) this.videos[i]).toStringNoTemporadas());
            }
        }

        boolean encontradaSerie = false;
        int codigo;
        do {
            codigo = Teclado.leerEntero("Código de la serie: ");
            for (int i = 0; i < this.numElementos  && !encontradaSerie; i++) {
                if (this.videos[i] instanceof Serie && this.videos[i].getCodigo().equals("VID" + codigo)) {
                    codigo = i;
                    encontradaSerie = true;
                }
            }

            if (!encontradaSerie) {
                System.out.println("Serie no encontrada.");
            }
        } while (!encontradaSerie);

        return codigo;
    }

    /**
     * case 7. modifica el genero de un video encontrado por codigo
     * @param codigoModificacion
     * @param generoModificacion
     * @return
     */
    public boolean modificarVideoPorGenero(int codigoModificacion, String generoModificacion) {
        Video videoModificacion = this.videos[codigoModificacion];
        boolean coincideGenero =  false;
        for (int i = 0; i < Video.getGeneros().length && !coincideGenero; i++) {
            if (generoModificacion.equalsIgnoreCase(Video.getGeneros()[i]) && !generoModificacion.equalsIgnoreCase(videoModificacion.getGenero())) {
                videoModificacion.setGenero(Video.getGeneros()[i]);
                coincideGenero = true;
            }
        }

        return coincideGenero;
    }

    /**
     * genera los episodios de una temporada
     * @param indiceTemporada
     * @param codigoSerie
     * @return
     */
    public Temporada generarEpisodios(int indiceTemporada, int codigoSerie) {
        int numEpisodios;
        do {
            numEpisodios = Teclado.leerEntero("Número de episodios de la temporada " + indiceTemporada + ": ");
            if (numEpisodios < 1) {
                System.out.println("La temporada debe tener al menos 1 episodio");
            }
        } while (numEpisodios < 1);
        return ((Serie) this.videos[codigoSerie]).getTemporada(indiceTemporada).generarEpisodios(numEpisodios);
    }

    /**
     * case 9. genera episodios de una temporada
     * @return
     */
    public Temporada generarEpisodiosTemporada() {
        System.out.println("\tSeries:");
        int codigoSerie = encontrarSeriePorCodigo();
        Serie s = (Serie) this.videos[codigoSerie];
        System.out.println(s.toString());

        // seleccionar temporada de la serie
        int indiceTemporada;
        do {
            indiceTemporada = Teclado.leerEntero("Indice de la temporada (0 - " + (s.getNumTemporadas() - 1) + "): ");
            if (indiceTemporada < 0 || indiceTemporada > s.getNumTemporadas()) {
                System.out.println("Indice no válido.");
            }
        } while (indiceTemporada < 0 || indiceTemporada > s.getNumTemporadas());

        return generarEpisodios(indiceTemporada, codigoSerie);
    }

    /**
     * case 10. genera episodios de todas las temporadas de una serie
     * @param codigoSerie
     * @return
     */
    public String generarEpisodiosTemporadas(int codigoSerie) {
        String strEpisodios = "";
        for (int i = 0; i < ((Serie) this.videos[codigoSerie]).getNumTemporadas(); i++) {
            Temporada episodiosGenerados = generarEpisodios(i, codigoSerie);
            strEpisodios += episodiosGenerados.toString() + "\n";
        }

        return strEpisodios;
    }

    // case 11
    public void ordenarCatalogoPelisSeries() {
        Arrays.sort(this.videos, new OrdenVideosPelisSeries());
    }

    // case 12
    public void ordenarCatalogoTitulo() {
        Arrays.sort(this.videos, new OrdenVideosTitulo());
    }

    // case 13
    public void ordenarCatalogoGenero() {
        Arrays.sort(this.videos, new OrdenVideosGenero());
    }

    // case 14
    public void ordenarCatalogoPuntuacion() {
        Arrays.sort(this.videos, new OrdenVideosPuntuacionTitulo());
    }

    /**
     * case 15. busca una cantidad de videos con más puntuación
     * @param cantidadVideos
     * @return
     */
    public Catalogo videosConMasPuntuacion(int cantidadVideos) {
        Catalogo catalogo = new Catalogo("Videos con más puntuación", cantidadVideos);
        Arrays.sort(this.videos, new OrdenVideosPuntuacionTitulo());
        for (int i = 0; i < cantidadVideos && i < this.numElementos; i++) {
            catalogo.insertarVideo(this.videos[i]);
        }

        return catalogo;
    }

    /**
     * case 16. compara el catalogo a otro para ver cual tiene más series
     * @param c
     * @return
     */
    public int catalogoConMasSeries(Catalogo c) {
        int contadorThis = 0, contadorC = 0;
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i] instanceof Serie) {
                contadorThis++;
            }
        }

        for (int i = 0; i < c.numElementos; i++) {
            if (c.videos[i] instanceof Serie) {
                contadorC++;
            }
        }

        return Integer.compare(contadorThis, contadorC);
    }

    public Video[] getVideos() {
        return this.videos;
    }
}
