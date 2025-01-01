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
                opcion = menu(3, "\n(0) Salir del programa.\n" +
                        "(1) Generar catálogo.\n" +
                        "(2) Insertar una película/serie en el catálogo.\n" +
                        "(3) Consultar catálogo.\n");

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
                        default:
                    }
                }
            } while (error);

        } while (opcion != 0);
    }
}
