import clases.ClubDeportivo;
import clases.DatosEntrenamiento;
import clases.SocioBasico;
import clases.SocioPremium;
import entrada.Teclado;

public class Principal {
    public static DatosEntrenamiento crearDatosEntrenamiento() {
        String[] dias = new String[7];
        String[] horas = new String[7];
        int[] duraciones = new int[7];

        String diaEntrenar = "";
        while (!diaEntrenar.equals("***")) {
            diaEntrenar = Teclado.leerCadena("¿Qué día/s quieres entrenar (*** para terminar)? ");
            boolean encontrado = false;
            for (int i = 0; i < DatosEntrenamiento.DIAS.length && !encontrado; i++) {
                String s = DatosEntrenamiento.DIAS[i];
                if (diaEntrenar.equalsIgnoreCase(s)) {
                    dias[i] = diaEntrenar.toLowerCase();
                    encontrado = true;
                }
            }
            if (!encontrado && !diaEntrenar.equalsIgnoreCase("***")) {
                System.out.println("dia no valido");
            }
        }

        for (int i = 0; i < dias.length; i++) {
            if (dias[i] != null) {
                String horasDias = Teclado.leerCadena("A qué hora quieres entrenar el " + dias[i] + "? ");
                horas[i] = horasDias;
                int duracionDias = Teclado.leerEntero("Cuantas horas? ");
                duraciones[i] = duracionDias;
            }
        }
        return new DatosEntrenamiento(dias, horas, duraciones);
    }

    public static Object[] datosSocio() {
        String nombre = Teclado.leerCadena("Nombre: ");
        int edad = Teclado.leerEntero("Edad: ");
        int cuenta = Teclado.leerEntero("Cuenta bancaria: ");
        boolean entrenadorBool = Teclado.leerBooleano("¿Quiere entrenador? ");
        DatosEntrenamiento entrenador = null;
        if (entrenadorBool) {
            entrenador = crearDatosEntrenamiento();
        }

        return new Object[]{
                nombre, edad, cuenta, entrenadorBool, entrenador
        };
    }

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
        ClubDeportivo losEnlaces = new ClubDeportivo("Los Enlaces");

        int opcion;

        do {
            opcion = menu("(1) Dar de alta un socio premium en el club\n" +
                    "(2) Dar de alta a un socio básico en el club\n" +
                    "(3) Consultar todos los socios del club ordenados por DNI\n" +
                    "(4) Dar de baja un socio, por DNI, del club\n" +
                    "(5) Cambiar el turno de un socio básico, por DNI, del club\n" +
                    "(6) Consultar los DNI de los socios premium del club que tienen carnet de estudiante\n" +
                    "(7) Consultar los socios que pagan la cuota mensual más alta del club\n" +
                    "(8) Cambiar un socio básico, por DNI, a socio premium\n" +
                    "-----------------------\n", 8);

            switch (opcion) {
                case 1:
                    String dniInsertarSocioPremium = Teclado.leerCadena("DNI: ");
                    if (losEnlaces.estaSocio(dniInsertarSocioPremium)) {
                        System.err.println("ya existe un usuario con ese dni");
                    } else {
                        Object[] datosInsertarPremium = datosSocio();
                        boolean carnetInsertarPremium = Teclado.leerBooleano("Dispone de carnet de estudiante? ");
                        SocioPremium insertarSocioPremium = new SocioPremium(dniInsertarSocioPremium, (String) datosInsertarPremium[0], (int) datosInsertarPremium[1], (int) datosInsertarPremium[2], (boolean) datosInsertarPremium[3], (DatosEntrenamiento) datosInsertarPremium[4], carnetInsertarPremium);
                        losEnlaces.insertarSocio(insertarSocioPremium);
                        System.err.println("inesertado con exito");
                    }
                    break;
                case 2:
                    String dniInsertarSocioBasico = Teclado.leerCadena("DNI: ");
                    if (losEnlaces.estaSocio(dniInsertarSocioBasico)) {
                        System.err.println("ya existe un usuario con ese dni");
                    } else {
                        Object[] datosInsertarPremium = datosSocio();
                        String turnoInsertarBasico = "";
                        while (!turnoInsertarBasico.equalsIgnoreCase("m") && !turnoInsertarBasico.equalsIgnoreCase("t") && !turnoInsertarBasico.equalsIgnoreCase("md")) {
                            turnoInsertarBasico = Teclado.leerCadena("Turno (M, T O MD)? ");
                            if (!turnoInsertarBasico.equalsIgnoreCase("m") && !turnoInsertarBasico.equalsIgnoreCase("t") && !turnoInsertarBasico.equalsIgnoreCase("md")) {
                                System.err.println("turno no valido");
                            }
                        }
                        boolean taquillaInsertarBasico = Teclado.leerBooleano("Usara taquilla? ");
                        SocioBasico insertarSocioBasico = new SocioBasico(dniInsertarSocioBasico, (String) datosInsertarPremium[0], (int) datosInsertarPremium[1], (int) datosInsertarPremium[2], (boolean) datosInsertarPremium[3], (DatosEntrenamiento) datosInsertarPremium[4], turnoInsertarBasico, taquillaInsertarBasico);
                        losEnlaces.insertarSocio(insertarSocioBasico);
                        System.err.println("inesertado con exito");
                    }
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                default:
            }
        } while (opcion != 0);
    }
}
