package trabajonavidad;

import entrada.Teclado;

public class Main {
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
                opcion = menu(7, "\n(0) Salir del programa.\n" +
                        "(1) Generar catálogo.\n" +
                        "(2) Insertar una película/serie en el catálogo.\n" +
                        "(3) Consultar todo el catálogo.\n" +
                        "(4) Consultar las películas de un director.\n" +
                        "(5) Consultar las series por año de inicio.\n" +
                        "(6) Consultar videos por género.\n" +
                        "(7) Modificar el género de un vídeo por código.\n");

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
                                break;
                            }
                        case 2:
                            int opcionVideo = menu(1, "\n(0) Crear película.\n" +
                                    "(1) Crear serie.\n");
                            if (opcionVideo == 0) {
                                Pelicula pelicula = new Pelicula(vectorCatalogos[indiceCatalogo].getNumElementos());
                                if (vectorCatalogos[indiceCatalogo].insertarPelicula(pelicula)) {
                                    System.out.println("Pelicula insertada con éxito.");
                                } else {
                                    System.out.println("No se pudo insertar la película en el catálogo.");
                                    error = true;
                                }
                            } else {
                                Serie serie = new Serie(vectorCatalogos[indiceCatalogo].getNumElementos());
                                if (vectorCatalogos[indiceCatalogo].insertarSerie(serie)) {
                                    System.out.println("Serie insertada con éxito.");
                                } else {
                                    System.out.println("No se pudo insertar la serie en el catálogo.");
                                    error = true;
                                }
                            }
                            break;
                        case 3:
                            System.out.println(vectorCatalogos[indiceCatalogo].toString());
                            break;
                        case 4:
                            System.out.println("Directores disponibles:");
                            for (int i = 0; i < Pelicula.getDirectores().length; i++) {
                                System.out.println(Pelicula.getDirectores()[i]);
                            }
                            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
                            boolean encontradoPelicula;
                            String director;
                            do {
                                encontradoPelicula = false;
                                director = Teclado.leerCadena("Director: ");
                                for (int i = 0; i < Pelicula.getDirectores().length && !encontradoPelicula; i++) {
                                    if (director.equalsIgnoreCase(Pelicula.getDirectores()[i])) {
                                        encontradoPelicula = true;
                                    }
                                }

                                if (!encontradoPelicula) {
                                    System.out.println("Director no encontrado.");
                                }
                            } while (!encontradoPelicula);
                            System.out.println("Peliculas del director " + director + ":");

                            boolean tienePeliculas = false;
                            for (int i = 0; i < vectorCatalogos[indiceCatalogo].getNumElementos(); i++) {
                                if (vectorCatalogos[indiceCatalogo].getVideo(i) instanceof Pelicula
                                        && ((Pelicula) vectorCatalogos[indiceCatalogo].getVideo(i)).getDirector().equalsIgnoreCase(director)) {
                                    System.out.println(vectorCatalogos[indiceCatalogo].getVideo(i).toString());
                                    tienePeliculas = true;
                                }
                            }

                            if (!tienePeliculas) {
                                System.out.println("No hay películas del director " + director + ".");
                                error = true;
                            }
                            break;
                        case 5:
                            boolean encontradoSerie;
                            int añoInicio;
                            encontradoSerie = false;
                            añoInicio = Teclado.leerEntero("Año de inicio: ");
                            for (int i = 0; i < vectorCatalogos[indiceCatalogo].getNumElementos(); i++) {
                                if (vectorCatalogos[indiceCatalogo].getVideo(i) instanceof Serie
                                        && ((Serie) vectorCatalogos[indiceCatalogo].getVideo(i)).getAñoInicio() == añoInicio) {
                                    System.out.println(vectorCatalogos[indiceCatalogo].getVideo(i).toString());
                                    encontradoSerie = true;
                                }
                            }

                            if (!encontradoSerie) {
                                System.out.println("No hay series del año " + añoInicio + ".");
                                error = true;
                            }
                            break;
                        case 6:
                            System.out.println("Géneros disponibles:");
                            for (int i = 0; i < Video.getGeneros().length; i++) {
                                System.out.println(Video.getGeneros()[i]);
                            }
                            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");
                            boolean encontradoVideo;
                            String genero;
                            do {
                                encontradoVideo = false;
                                genero = Teclado.leerCadena("Género: ");
                                for (int i = 0; i < Video.getGeneros().length && !encontradoVideo; i++) {
                                    if (genero.equalsIgnoreCase(Video.getGeneros()[i])) {
                                        encontradoVideo = true;
                                    }
                                }

                                if (!encontradoVideo) {
                                    System.out.println("Género no encontrado.");
                                }
                            } while (!encontradoVideo);
                            System.out.println("Vídeos del género " + genero + ":");

                            boolean hayVideos = false;
                            for (int i = 0; i < vectorCatalogos[indiceCatalogo].getNumElementos(); i++) {
                                if (vectorCatalogos[indiceCatalogo].getVideo(i).getGenero().equalsIgnoreCase(genero)) {
                                    System.out.println(vectorCatalogos[indiceCatalogo].getVideo(i).toString());
                                    hayVideos = true;
                                }
                            }

                            if (!hayVideos) {
                                System.out.println("No hay vídeos del género " + genero + ".");
                                error = true;
                            }
                            break;
                        case 7:
                            int codigoModificacion;
                            do {
                                codigoModificacion = Teclado.leerEntero("Código del vídeo (0 - " + (vectorCatalogos[indiceCatalogo].getNumElementos() - 1) + "): ");
                                if (codigoModificacion < 0 || codigoModificacion > vectorCatalogos[indiceCatalogo].getNumElementos()) {
                                    System.out.println("Código no válido.");
                                }
                            } while (codigoModificacion < 0 || codigoModificacion > vectorCatalogos[indiceCatalogo].getNumElementos());

                            System.out.println("Géneros disponibles:");
                            for (int i = 0; i < Video.getGeneros().length; i++) {
                                System.out.println(Video.getGeneros()[i]);
                            }
                            System.out.println("-+-+-+-+-+-+-+-+-+-+-+-");

                            Video videoModificacion = vectorCatalogos[indiceCatalogo].getVideo(codigoModificacion);
                            String generoModificacion;
                            boolean coincideGenero;
                            do {
                                coincideGenero = false;
                                generoModificacion = Teclado.leerCadena("Género: ");
                                for (int i = 0; i < Video.getGeneros().length && !coincideGenero; i++) {
                                    if (generoModificacion.equalsIgnoreCase(Video.getGeneros()[i]) && !generoModificacion.equalsIgnoreCase(videoModificacion.getGenero())) {
                                        videoModificacion.setGenero(Video.getGeneros()[i]);
                                        coincideGenero = true;
                                    }
                                }

                                if (!generoModificacion.equalsIgnoreCase(videoModificacion.getGenero())) {
                                    System.out.println("Debes introducir un género distinto al del vídeo.");
                                    error = true;
                                }

                                if (!coincideGenero) {
                                    System.out.println("Género no encontrado.");
                                }
                            } while (!coincideGenero);
                        default:
                    }
                }
            } while (error);
        } while (opcion != 0);
    }
}
