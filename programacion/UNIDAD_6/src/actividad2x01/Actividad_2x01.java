package actividad2x01;

import entrada.Teclado;

public class Actividad_2x01 {
    /**
     * menu con opciones que se reptie hasta que la opcion sea valida
     * @return
     */
    public static int menu() {
        int opcion;

        do {
            System.out.println("(0) Salir del programa.\n" +
                    "(1) Visualizar en consola las dos cuentas.\n" +
                    "(2) Ingresar un importe en la cuenta 1.\n" +
                    "(3) Retirar un importe de la cuenta 1.\n" +
                    "(4) Ingresar un importe en la cuenta 2.\n" +
                    "(5) Retirar un importe de la cuenta 2.\n" +
                    "(6) Transferir un importe de la cuenta 1 a la 2.\n" +
                    "(7) Transferir un importe de la cuenta 2 a la 1.\n");

            opcion = Teclado.leerEntero("Opción: ");
            if (opcion < 0 || opcion > 7) {
                System.out.println("la opcion debe estar entre 0 y 7");
            }
        } while (opcion < 0 || opcion > 7);
        return opcion;
    }

    /**
     * pide una cantidad y la ingresa en una cuenta
     * @param c
     * @return
     */
    public static boolean ingresar(Cuenta c) {
        double importe = Teclado.leerReal("Importe a retirar: ");
        return c.ingresar(importe);
    }

    /**
     * pide una cantidad y la retira de una cuenta
     * @param c
     * @return
     */
    public static boolean retirar(Cuenta c) {
        double importe = Teclado.leerReal("Importe a retirar: ");
        return c.retirar(importe);
    }

    /**
     * pide una cantidad y la transifere de una cuenta a otra
     * @param transfiere
     * @param transferida
     * @return
     */
    public static boolean transferir(Cuenta transfiere, Cuenta transferida) {
        double importe = Teclado.leerReal("Importe a trasnferir de " + transfiere + " a " + transferida);
        return transfiere.transferir(importe, transferida);
    }

    /**
     * crea dos cuentas y ofrece varias operaicones con ellas
     * @param args
     */
    public static void main(String[] args) {
        Cuenta c1 = new Cuenta(1, "Francisco");
        Cuenta c2 = new Cuenta(2, "Victoria");

        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    System.out.println(c1.obtenerEstado());
                    System.out.println(c2.obtenerEstado());
                    System.out.println();
                    break;
                case 2:
                    if (ingresar(c1)) {
                        System.out.println("Se ha ingresado un importe de la cuenta 1");
                    } else {
                        System.out.println("el importe debe ser positivo");
                    }
                    break;
                case 3:
                    if (retirar(c1)) {
                        System.out.println("Se ha retirado un importe de la cuenta 1");
                    } else {
                        System.out.println("Error al retirar un importe de la cuenta 1:\n" +
                                "El importe debe ser positivo.\n" +
                                "El importe debe ser menor o igual que el saldo de la cuenta 1");
                    }
                    break;
                case 4:
                    if (ingresar(c2)) {
                        System.out.println("Se ha ingresado un importe de la cuenta 2");
                    } else {
                        System.out.println("el importe debe ser positivo");
                    }
                    break;
                case 5:
                    if (retirar(c2)) {
                        System.out.println("Se ha retirado un importe de la cuenta 2");
                    } else {
                        System.out.println("Error al retirar un importe de la cuenta 2:\n" +
                                "El importe debe ser positivo.\n" +
                                "El importe debe ser menor o igual que el saldo de la cuenta 2");
                    }
                    break;
                case 6:
                    if (transferir(c1, c2)) {
                        System.out.println("Transferencia correcta de c1 a c2");
                    } else {
                        System.out.println("Error al transferir un importe de la cuenta 1 a la cuenta 2:\n" +
                                "El importe debe ser positivo.\n" +
                                "El importe debe ser menor o igual que el saldo de la cuenta 1");
                    }
                    break;
                case 7:
                    if (transferir(c2, c1)) {
                        System.out.println("Transferencia correcta de c2 a c1");
                    } else {
                        System.out.println("Error al transferir un importe de la cuenta 2 a la cuenta 1:\n" +
                                "El importe debe ser positivo.\n" +
                                "El importe debe ser menor o igual que el saldo de la cuenta 2");
                    }
                    break;
            }
        } while (opcion > 0 && opcion <= 7);
    }
}
