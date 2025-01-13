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
            Video v = this.videos[i];

            int random = new Random().nextInt(2);
            if (random == 0) {
                v = new Pelicula(this.numElementos);
            } else {
                v = new Serie(this.numElementos);
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
            Video v = this.videos[i];

            if (v instanceof Pelicula) {
                strPeliculas += v + "\n";
            } else {
                strSeries += v + "\n";
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
            Video v = this.videos[i];

            if (v != null && i == pos) {
                v = null;
                borrado = true;
            }
        }

        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];

            boolean movido = false;
            if (v == null) {
                for (int j = i + 1; j < this.numElementos && !movido; j++) {
                    Video v2 = this.videos[j];
                    if (v2 != null) {
                        v = v2;
                        v2 = null;
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
                insertado = true;
            } else {
                insertado = false;
            }
        } else {
            Serie serie = new Serie(this.numElementos);
            if (this.insertarVideoAlFinal(serie)) {
                insertado = true;
            } else {
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
    public Pelicula[] consultarPeliculasPorDirector(String director) {
        String strPeliculas = "";
        int contadorPeliculas = 0;
        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];
            if (v instanceof Pelicula
                    && ((Pelicula) v).getDirector().equalsIgnoreCase(director)) {
                contadorPeliculas++;
            }
        }

        Pelicula[] peliculas = new Pelicula[contadorPeliculas];
        contadorPeliculas = 0;
        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];
            if (v instanceof Pelicula
                    && ((Pelicula) v).getDirector().equalsIgnoreCase(director)) {
                peliculas[contadorPeliculas] = (Pelicula) v;
                contadorPeliculas++;
            }
        }
        return peliculas;
    }

    /**
     * case 5. busca una serie por año de inicio
     * @param añoInicio
     * @return
     */
    public Serie[] seriePorAñoInicio(int añoInicio) {
        int contadorSeries = 0;
        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];
            if (v instanceof Serie
                    && ((Serie) v).getAñoInicio() == añoInicio) {
                contadorSeries++;
            }
        }

        Serie[] series = new Serie[contadorSeries];
        contadorSeries = 0;
        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];
            if (v instanceof Serie
                    && ((Serie) v).getAñoInicio() == añoInicio) {
                series[contadorSeries] = (Serie) v;
                contadorSeries++;
            }
        }

        return series;
    }

    /**
     * case 6. consultar por genero
     * @param genero
     * @return
     */
    public Video[] consultarVideosPorGenero(String genero) {
        int contadorVideos = 0;
        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];
            if (v.getGenero().equalsIgnoreCase(genero)) {
                contadorVideos++;
            }
        }

        Video[] videos = new Video[contadorVideos];
        contadorVideos = 0;
        for (int i = 0; i < this.numElementos; i++) {
            Video v = this.videos[i];
            if (v.getGenero().equalsIgnoreCase(genero)) {
                videos[contadorVideos] = v;
                contadorVideos++;
            }
        }
        return videos;
    }

    /**
     * encuentra un video de cualquier tipo por su código
     *
     * @return
     */
    public Video encontrarVideoPorCodigo(int codigo) {
        for (int i = 0; i < this.numElementos; i++) {
            if (this.videos[i].getCodigo().equals("VID" + codigo)) {
                return this.videos[i];
            }
        }

        return null;
    }

    /**
     * case 7. modifica el genero de un video encontrado por codigo
     * @param codigoModificacion
     * @param generoModificacion
     * @return
     */
    public boolean modificarVideoPorGenero(String codigoModificacion, String generoModificacion) {
        int codigo = Integer.parseInt(codigoModificacion.substring(3));
        Video videoModificacion = this.videos[codigo];
        for (int i = 0; i < Video.getGeneros().length; i++) {
            if (generoModificacion.equalsIgnoreCase(Video.getGeneros()[i]) && !generoModificacion.equalsIgnoreCase(videoModificacion.getGenero())) {
                videoModificacion.setGenero(Video.getGeneros()[i]);
                return true;
            }
        }
        return false;
    }

    /**
     * case 9. cuenta episodios de una temporada
     * @return
     */
    public int cantidadEpisodiosTemporada(int indiceTemporada, int codigoSerie) {
        Serie v = (Serie) this.videos[codigoSerie];
        return v.getTemporada(indiceTemporada).getNumEpisodios();
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
