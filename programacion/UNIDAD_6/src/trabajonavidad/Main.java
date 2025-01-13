package trabajonavidad;

import entrada.Teclado;

public class Main {
    /**
     * menú de opciones parametrizado
     * @param NUM_OPCIONES
     * @param MENSAJE
     * @return
     */
    public static int menu(int NUM_OPCIONES, String MENSAJE) {
        int opcion;
        do {
            System.out.println("\n---------------------------------"
                    + MENSAJE
                    + "---------------------------------");

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > NUM_OPCIONES) {
                System.out.println("la opcion debe estar entre 0 y " + NUM_OPCIONES);
            }
        } while (opcion < 0 || opcion > NUM_OPCIONES);
        return opcion;
    }

    /**
     * programa que muestra la interfaz de usuario, con un menú de opciones y varias posibilidades para trabajar con varios catálogos.
     * @param args
     */
    public static void main(String[] args) {
        int numCatalogos;
        do {
            System.out.println("******************************************" +
                    "*\n*¿Cuántos catálogos desea tener? (2 o más)*" +
                    "\n*******************************************\n");
            numCatalogos = Teclado.leerEntero("Número de catálogos: ");
        } while (numCatalogos < 2);
        Catalogo[] vectorCatalogos = new Catalogo[numCatalogos];

        int opcion;

        do {
            int indiceCatalogo;
            do {
                indiceCatalogo = Teclado.leerEntero("\n---------------------------------\n" +
                        "Tienes " + numCatalogos + " catálogos (0 - " + (numCatalogos - 1) + ")" +
                    "\n¿Sobre cuál deseas trabajar? ");
            } while  (indiceCatalogo < 0 || indiceCatalogo >= numCatalogos);

            boolean error;
            do {
                opcion = menu(16, "\n(0) Salir del programa.\n" +
                        "(1) Generar catálogo.\n" +
                        "(2) Insertar una película/serie en el catálogo.\n" +
                        "(3) Consultar todo el catálogo.\n" +
                        "(4) Consultar las películas de un director.\n" +
                        "(5) Consultar las series por año de inicio.\n" +
                        "(6) Consultar videos por género.\n" +
                        "(7) Modificar el género de un vídeo por código.\n" +
                        "(8) Eliminar una pelicla/serie por código.\n" +
                        "(9) Indicar el número de episodios de una temporada de una serie.\n" +
                        "(10) Indicar episodios totales de una serie.\n" +
                        "(11) Ordenar catálogo primero películas y luego series.\n" +
                        "(12) Ordenar catálogo por título.\n" +
                        "(13) Ordenar catálogo por género.\n" +
                        "(14) Ordenar catálogo por puntuación y título.\n" +
                        "(15) Consultar los 10 vídeos con más puntuación.\n" +
                        "(16) Catálogo con más series entre 2.\n");

                error = false;
                if (vectorCatalogos[indiceCatalogo] == null && opcion != 1 && opcion != 0) {
                    System.out.println("Antes debes crear el catálogo.");
                    error = true;
                } else {
                    switch (opcion) {
                        case 1:
                            if (vectorCatalogos[indiceCatalogo] != null) {
                                System.out.println("Este catálogo ya existe.");
                                error = true;
                            } else {
                                int tamañoCreacion = Teclado.leerEntero("¿Cuál será el tamaño del catálogo? ");
                                vectorCatalogos[indiceCatalogo] = new Catalogo("Catalogo " + indiceCatalogo, tamañoCreacion);
                                int numVideosCreacion = Teclado.leerEntero("¿Cuántos vídeos desea crear? ");
                                vectorCatalogos[indiceCatalogo].generarVideosAleatorios(numVideosCreacion);
                            }
                            break;
                        case 2:
                            int opcionVideo = menu(1, "\n(0) Crear película.\n" +
                                    "(1) Crear serie.\n");
                            boolean insertado = vectorCatalogos[indiceCatalogo].insertarVideo(opcionVideo);
                            if (!insertado) {
                                System.out.println("No se pudo insertar en el catálogo.");
                                error = true;
                            } else {
                                System.out.println("Insertado con éxito.");
                            }
                            break;
                        case 3:
                            System.out.println(vectorCatalogos[indiceCatalogo].toString());
                            break;
                        case 4:
                            System.out.println(Pelicula.getStringDirectores());
                            String director = Teclado.leerCadena("Director: ");

                            boolean existeDirector = Pelicula.buscarDirector(director);
                            if (!existeDirector) {
                                System.out.println("Director no encontrado");
                                error = true;
                            } else {
                                Pelicula[] peliculas = vectorCatalogos[indiceCatalogo].consultarPeliculasPorDirector(director);
                                if (peliculas.length == 0) {
                                    System.out.println("No hay películas del director " + director + ".");
                                } else {
                                    System.out.println("Películas del director " + director + ":");
                                    for (int i = 0; i < peliculas.length; i++) {
                                        System.out.println(peliculas[i].toString());
                                    }
                                }
                            }
                            break;
                        case 5:
                            int añoInicio = Teclado.leerEntero("Año de inicio: ");

                            Serie[] series = vectorCatalogos[indiceCatalogo].seriePorAñoInicio(añoInicio);
                            if (series.length == 0) {
                                System.out.println("No hay series del año " + añoInicio + ".");
                            } else {
                                System.out.println("Series del año " + añoInicio + ":");
                                for (int i = 0; i < series.length; i++) {
                                    System.out.println(series[i].toString());
                                }
                            }
                            break;
                        case 6:
                            System.out.println(Video.getStringGeneros());
                            String genero = Teclado.leerCadena("Género: ");

                            boolean existeGenero = Video.buscarGenero(genero);
                            if (!existeGenero) {
                                System.out.println("Genero no encontrado");
                                error = true;
                            } else {
                                Video[] videos = vectorCatalogos[indiceCatalogo].consultarVideosPorGenero(genero);
                                if (videos.length == 0) {
                                    System.out.println("No hay videos del género " + genero + ".");
                                } else {
                                    System.out.println("Vídeos del género " + genero + ":");
                                    for (int i = 0; i < videos.length; i++) {
                                        System.out.println(videos[i].toString());
                                    }
                                }
                            }
                            break;
                        case 7:
                            int codigo = Teclado.leerEntero("Código de video: ");
                            Video videoModificarVideoGenero = vectorCatalogos[indiceCatalogo].encontrarVideoPorCodigo(codigo);
                            if (videoModificarVideoGenero == null) {
                                System.out.println("No encontrado.");
                                error = true;
                            } else {
                                System.out.println(Video.getStringGeneros());
                                String generoModificacionVideoGenero = Teclado.leerCadena("Género: ");
                                if (vectorCatalogos[indiceCatalogo].modificarVideoPorGenero(videoModificarVideoGenero.getCodigo(), generoModificacionVideoGenero)) {
                                    System.out.println("Vídeo modificado con éxito.");
                                } else {
                                    System.out.println("Debes introducir un género existente y distinto al del vídeo.");
                                    error = true;
                                }
                            }
                            break;
                        case 8:
                            int codigoBorrar = Teclado.leerEntero("Código del vídeo (0 - " + (vectorCatalogos[indiceCatalogo].getNumElementos() - 1) + "): ");
                            if (vectorCatalogos[indiceCatalogo].eliminarVideo(codigoBorrar)) {
                                System.out.println("Vídeo borrado con éxito.");
                            } else {
                                System.out.println("Código no válido.");
                                error = true;
                            }
                            break;
                        case 9:
                            int codigoIndicarEpisodiosTemporada = Teclado.leerEntero("Código del vídeo (0 - " + (vectorCatalogos[indiceCatalogo].getNumElementos() - 1) + "): ");
                            Video v = vectorCatalogos[indiceCatalogo].encontrarVideoPorCodigo(codigoIndicarEpisodiosTemporada);
                            if (v == null) {
                                System.out.println("Código no válido.");
                                error = true;
                            } else if (!(v instanceof Serie)) {
                                System.out.println("Solo se pueden indicar episodios de series.");
                                error = true;
                            } else {
                                int indiceTemporada = Teclado.leerEntero("Indice de la temporada (0 - " + (((Serie) v).getNumTemporadas() - 1) + "): ");
                                if (indiceTemporada < 0 || indiceTemporada > ((Serie) v).getNumTemporadas()) {
                                    System.out.println("Indice no válido.");
                                    error = true;
                                } else {
                                    int numEpisodios = vectorCatalogos[indiceCatalogo].cantidadEpisodiosTemporada(indiceTemporada, codigoIndicarEpisodiosTemporada);
                                    System.out.println("Cantidad de episodios de la temporada:\n" + numEpisodios);
                                }
                            }
                            break;
                        case 10:
                            int codigoSerie = Teclado.leerEntero("Código del vídeo (0 - " + (vectorCatalogos[indiceCatalogo].getNumElementos() - 1) + "): ");
                            Video v2 = vectorCatalogos[indiceCatalogo].encontrarVideoPorCodigo(codigoSerie);
                            if (v2 == null) {
                                System.out.println("Código no válido.");
                                error = true;
                            } else if (!(v2 instanceof Serie)) {
                                System.out.println("Solo se pueden indicar episodios de series.");
                                error = true;
                            } else {
                                int numEpisodios = 0;
                                for (int i = 0; i < ((Serie) v2).getNumTemporadas(); i++) {
                                    numEpisodios += vectorCatalogos[indiceCatalogo].cantidadEpisodiosTemporada(i, codigoSerie);
                                }
                                System.out.println("Cantidad de episodios de todas las temporadas:\n" + numEpisodios);
                            }
                            break;
                        case 11:
                            if (vectorCatalogos[indiceCatalogo].getNumElementos() < vectorCatalogos[indiceCatalogo].getVideos().length) {
                                System.out.println("No se puede ordenar el catálogo primero películas y luego series. El catálogo debe estar completo.");
                                error = true;
                            } else {
                                vectorCatalogos[indiceCatalogo].ordenarCatalogoPelisSeries();
                                System.out.println(vectorCatalogos[indiceCatalogo].toString());
                            }
                            break;
                        case 12:
                            if (vectorCatalogos[indiceCatalogo].getNumElementos() < vectorCatalogos[indiceCatalogo].getVideos().length) {
                                System.out.println("No se puede ordenar el catálogo por título. El catálogo debe estar completo.");
                                error = true;
                            } else {
                                vectorCatalogos[indiceCatalogo].ordenarCatalogoTitulo();
                                System.out.println(vectorCatalogos[indiceCatalogo].toString());
                            }
                            break;
                        case 13:
                            if (vectorCatalogos[indiceCatalogo].getNumElementos() < vectorCatalogos[indiceCatalogo].getVideos().length) {
                                System.out.println("No se puede ordenar el catálogo por género. El catálogo debe estar completo.");
                                error = true;
                            } else {
                                vectorCatalogos[indiceCatalogo].ordenarCatalogoGenero();
                                System.out.println(vectorCatalogos[indiceCatalogo].toString());
                            }
                            break;
                        case 14:
                            if (vectorCatalogos[indiceCatalogo].getNumElementos() < vectorCatalogos[indiceCatalogo].getVideos().length) {
                                System.out.println("No se puede ordenar el catálogo por puntuación. El catálogo debe estar completo.");
                                error = true;
                            } else {
                                vectorCatalogos[indiceCatalogo].ordenarCatalogoPuntuacion();
                                System.out.println(vectorCatalogos[indiceCatalogo].toString());
                            }
                            break;
                        case 15:
                            Catalogo catalogoMasPuntuacion = vectorCatalogos[indiceCatalogo].videosConMasPuntuacion(10);
                            System.out.println(catalogoMasPuntuacion.toString());
                            break;
                        case 16:
                            int catalogoComparar;
                            do {
                                catalogoComparar = Teclado.leerEntero("¿Con qué catálogo lo quieres comparar (0 - " + (numCatalogos - 1) + " excepto " + indiceCatalogo + ")? ");
                            } while (catalogoComparar == indiceCatalogo || catalogoComparar < 0 || catalogoComparar >= numCatalogos);

                            if (vectorCatalogos[catalogoComparar] == null) {
                                System.out.println("Antes debes crear el catálogo " + catalogoComparar);
                            } else {
                                int identificadorMayor = vectorCatalogos[indiceCatalogo].catalogoConMasSeries(vectorCatalogos[catalogoComparar]);
                                if (identificadorMayor == 1) {
                                    System.out.println("El catálogo " + indiceCatalogo + " tiene más series.");
                                } else if (identificadorMayor == -1) {
                                    System.out.println("El catálogo " + catalogoComparar + " tiene más series.");
                                } else {
                                    System.out.println("Los catálogos tienen la misma cantidad de series.");
                                }
                            }
                            break;
                    }
                }
            } while (error);
        } while (opcion != 0);
    }
}
