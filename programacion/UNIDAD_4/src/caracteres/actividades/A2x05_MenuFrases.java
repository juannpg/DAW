package caracteres.actividades;

import entrada.Teclado;

public class A2x05_MenuFrases {
    public static int menu() {
        int opcion;
        do {
            System.out.println("(0) Salir del programa.\n" +
                    "(1) Convertir todos los caracteres de la frase a letras mayúsculas.\n" +
                    "(2) Convertir todos los caracteres de la frase a letras minúsculas.\n");

             opcion = Teclado.leerEntero("Opción: ");
        } while (opcion != 0 && opcion != 1 && opcion != 2);
        return opcion;
    }

    public static void main(String[] args) {
        int opcion = menu();
    }
}
