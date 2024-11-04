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

    public static String leerFrase() {
        String frase = Teclado.leerCadena("Frase: ");
        do {
            if (frase.length() <= 0 || frase.length() > 60) {
                System.out.println("La frase no puede ser vacía ni más de 60 caracteres");
            }
        } while (frase.length() <= 0 || frase.length() > 60);

        return frase;
    }

    public static void main(String[] args) {
        String frase;
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    frase = leerFrase();
                    String mayusculas = frase.toUpperCase();
                    System.out.println("Frase convertida a mayúsculas: " + mayusculas);
                    break;
                case 2:
                    frase = leerFrase();
                    String minusculas = frase.toLowerCase();
                    System.out.println("Frase convertida a minúsculas: " + minusculas);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
