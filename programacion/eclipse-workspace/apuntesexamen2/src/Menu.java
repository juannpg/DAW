import entrada.Teclado;

public class Menu {
    public static int menu(String mensaje, int numOpciones) {
        int opcion;
        do {
            System.out.println(mensaje);

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > numOpciones) {
                System.out.println("la opcion debe estar entre 0 y " + numOpciones);
            }
        } while (opcion < 0 || opcion > numOpciones);
        return opcion;
    }

    public static void main(String[] args) {
        int opcion;

        do {
            opcion = menu("\n(0) Salir del programa.\n" +
                    "(1) Insertar un administrador\n" +
                    "(2) Insertar un comprador\n" +
                    "(3) Borrar producto favorito", 3);

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }

        } while (opcion != 0);
    }
}
