package arrayList.actividades.A2x03_Libros;

import entrada.Teclado;

public class Principal {
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
        Libreria libreria = new Libreria("Libreria");
        int opcion;
        do {
            opcion = menu("\n(0) Salir del programa.\n" +
                    "(1) Insertar un usuario en la clientela.\n" +
                    "(2) Consultar todos los usuarios de la clientela.\n" +
                    "(3) Eliminar un usuario, por posición, de la clientela.\n", 3);
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
