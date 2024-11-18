package actividad2x03;

import entrada.Teclado;

public class Actividad_2x03 {
    public static int menu() {
        int opcion;
        do {
            System.out.println("""
                    0) Salir del programa
                    1) Leer por teclado un tiempo válido
                    2) Visualizar en consola el tiempo
                    3) Sumar al tiempo otro tiempo
                    4) Restar al tiempo otro tiempo
                    """);
            opcion = Teclado.leerEntero("Opcion: ");

            if (opcion < 0 || opcion > 4) {
                System.out.println("Opcion invalida");
            }
        } while (opcion != 0);
        return opcion;
    }

    public static boolean validar(int horas, int minutos, int segundos) {
        return horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60 && segundos >= 0 && segundos < 60;
    }

    public static Tiempo crearTiempo() {
        int horas, minutos, segundos;

        do {
            horas = Teclado.leerEntero("Horas: ");
            minutos = Teclado.leerEntero("Minutos: ");
            segundos = Teclado.leerEntero("Segundos: ");

            if (!validar(horas, minutos, segundos)) {
                System.out.println("""
                                Los datos del tiempo no son válidos:
                                Las horas deben estar comprendidas entre 0 y 23.
                                Los minutos deben estar comprendidos entre 0 y 59.
                                Los segundos deben estar comprendidos entre 0 y 59.
                                """);
            }
        } while (horas < 0 || horas >= 24 || minutos < 0 || minutos >= 60 || segundos < 0 || segundos >= 60);

        return new Tiempo(horas, minutos, segundos);
    }

    public static void main(String[] args) {
        int opcion = menu();

        Tiempo tiempo = new Tiempo(-1, -1, -1);
        switch (opcion) {
            case 1:
                tiempo = crearTiempo();
                System.out.println("Se ha creado un tiempo válido");

                break;

            case 2:
                if (!validar(tiempo)) {
                    System.out.println("no existe ningun tiempo válido creado");
                } else {
                    System.out.println(tiempo.toString());
                }
                break;

            case 3:
                if (!validar(tiempo)) {
                    System.out.println("no existe ningun tiempo válido creado");
                } else {
                    Tiempo tiempo2 = crearTiempo();
                    System.out.println("Se ha creado un tiempo válido");

                    System.out.println(tiempo.toString());
                    System.out.println(tiempo2.toString());

                    if (tiempo.sumar(tiempo2)) {
                        System.out.println(tiempo.toString());
                    } else {
                        System.out.println("Error al sumar el tiempo más otro tiempo:\n" +
                                "La suma debe ser igual o inferior a 23h:59m:59s.");
                    }
                }
                break;

            case 4:
                if (!validar(tiempo)) {
                    System.out.println("no existe ningun tiempo válido creado");
                } else {
                    Tiempo tiempo2 = crearTiempo();
                    System.out.println("Se ha creado un tiempo válido");

                    System.out.println(tiempo.toString());
                    System.out.println(tiempo2.toString());

                    if (tiempo.restar(tiempo2)) {
                        System.out.println(tiempo.toString());
                    } else {
                        System.out.println("Error al resar el tiempo más otro tiempo:\n" +
                                "La resta debe ser igual o inferior a 23h:59m:59s.");
                    }
                }
                break;

            default:
                System.out.println("la opcion debe estar entre 0 y 4");
        }
    }
}
