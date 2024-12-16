package herencia.actividades.A2X02_Bebidas;

import entrada.Teclado;

public class Main {
    public static int menu(int LIMITE) {
        int opcion;
        do {
            System.out.println("\n(0) Salir del programa.\n" +
                    "(1) Rellenar el inventario con bebidas generadas de manera aleatoria.\n" +
                    "(2) Consultar bebidas del inventario.\n" +
                    "(3) Consultar los refrescos del inventario.\n" +
                    "(4) Consultar las bebidas fermentadas del inventario\n" +
                    "(5) Consultar las bebidas destiladas del inventario\n" +
                    "(6) Consultar las bebidas con precio comprendido estre dos límites\n" +
                    "(7) Consultar el número de refrescos gaseosos del inventario\n"
            );

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > LIMITE) {
                System.out.println("la opcion debe estar entre 0 y " + LIMITE);
            }
        } while (opcion < 0 || opcion > LIMITE);
        return opcion;
    }

    public static void main(String[] args) {
        int opcion;
        Inventario inventario = new Inventario(20);

        do {
            opcion = menu(7);

            switch (opcion) {
                case 1:
                    int numBebidas = Teclado.leerEntero("¿Número de Bebidas? ");
                    int[] vectorRellenarInventario = inventario.generarBebidasAleatorias(numBebidas);
                    System.out.printf("Se han insertado %d refrescos en el inventario\n" +
                            "Se han insertado %d fermentadas\n" +
                            "Se han insertado %d destiladas\n", vectorRellenarInventario[0], vectorRellenarInventario[1], vectorRellenarInventario[2]);
                    break;
                case 2:
                    System.out.println(inventario.toString());
                    break;
                case 3:
                    Inventario inventarioRefrescosEncontrados = inventario.consultarRefrescos();
                    System.out.println(inventarioRefrescosEncontrados.toString());
                    System.out.println("Se han encontrado " + inventarioRefrescosEncontrados.getNumElementos() + " refrescos\n");
                    break;
                case 4:
                    Inventario inventarioFermentadasEncontrados = inventario.consultarFermentadas();
                    System.out.println(inventarioFermentadasEncontrados.toString());
                    System.out.println("Se han encontrado " + inventarioFermentadasEncontrados.getNumElementos() + " fermentadas\n");
                    break;
                case 5:
                    Inventario inventarioDestiladasEncontrados = inventario.consultarDestiladas();
                    System.out.println(inventarioDestiladasEncontrados.toString());
                    System.out.println("Se han encontrado " + inventarioDestiladasEncontrados.getNumElementos() + " destiladas\n");
                    break;
                case 6:
                    double precioMin = Teclado.leerReal("¿Precio minimo?" );
                    double precioMax = Teclado.leerReal("¿Precio máximo? ");
                    Inventario bebidasPorPrecios = inventario.consultarBebidasEntreDosPrecios(precioMin, precioMax);
                    System.out.println(bebidasPorPrecios.toString());
                    System.out.println("Se han encontrado " + bebidasPorPrecios.getNumElementos() + " bebidas\n");
                    break;
                case 7:
                    int contadorGaseosos = inventario.numeroRefrescosGaseosos();
                    System.out.println("El inventario tiene " + contadorGaseosos + " refrescos gaseosos");
                    break;
                default:

            }
        } while (opcion != 0);
    }
}
