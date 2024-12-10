package videojuego;

import entrada.Teclado;

import java.util.Arrays;

public class main {
    /**
     * menu con opciones del 0 al 6 que pide una entrada siempre que no sea correcta
     * @return opcion
     */
    public static int menu() {
        int opcion;
        do {
            System.out.println("\n(0) Salir del programa.\n" +
                    "(1) Insertar un videojuego.\n" +
                    "(2) Eliminar un videojuego, por posición, del almacén.\n" +
                    "(3) Consultar un videojuego, por código, del almacén.\n" +
                    "(4) Consultar todos los videojuegos del almacén.\n" +
                    "(5) Modificar las cantidades dado un precio.\n" +
                    "(6) Busca un videojuego.\n");

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > 6) {
                System.out.println("la opcion debe estar entre 0 y 6");
            }
        } while (opcion < 0 || opcion > 6);
        return opcion;
    }

    /**
     * crea un alamacen con capacidad 20
     * muestra el menu hasta que se salga de el
     * hace las opciones del menu
     * @param args argumentos
     */
    public static void main(String[] args) {
        final int CAPACIDAD = 20;
        Almacen almacen = new Almacen(CAPACIDAD);

        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    String titulo = Teclado.leerCadena("¿Nombre? ");
                    double precio = Teclado.leerReal("¿Precio? ");

                    Videojuego insertarVideojuego = new Videojuego(titulo, precio);
                    if (almacen.insertar(insertarVideojuego)) {
                        System.out.println("Se ha insertado el videojuego");
                    } else {
                        System.out.println("Error: almacén lleno");
                    }
                    break;

                case 2:
                    int pos = Teclado.leerEntero("Posición a eliminar: ");
                    if (almacen.eliminar(pos)) {
                        System.out.println("Videojuego eliminado");
                    } else {
                        System.out.println("Error al eliminar");
                    }
                    break;

                case 3:
                    int cod = Teclado.leerEntero("¿Código? ");

                    Videojuego consultarVideojuego = almacen.consultar(cod);
                    if (consultarVideojuego == null) {
                        System.out.println("No encontrado");
                    } else {
                        System.out.println(consultarVideojuego);
                    }
                    break;

                case 4:
                    String videojuegos = almacen.toString();

                    if (videojuegos.isEmpty()) {
                        System.out.println("Almacén vacío");
                    } else {
                        System.out.println(videojuegos);
                    }
                    break;

                case 5:
                    double modificarVideojuego = Teclado.leerReal("¿Precio? ");
                    System.out.println("Vidoejuegos modificados: " + almacen.modificaCantidad(modificarVideojuego));
                    break;

                case 6:
                    int buscarVideojuego = Teclado.leerEntero("¿Cantidad? ");
                    System.out.println(Arrays.toString(almacen.buscaVideojuegos(buscarVideojuego)));
                    break;

                default:
                    System.out.println("La opción dee estar entre 0 y 6");
            }
        } while (opcion != 0);
    }
}
