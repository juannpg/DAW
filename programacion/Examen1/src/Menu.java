public class Menu {
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

    public static void main(String[] args) {

    }
}
