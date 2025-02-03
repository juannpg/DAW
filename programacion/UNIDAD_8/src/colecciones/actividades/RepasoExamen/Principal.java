package colecciones.actividades.RepasoExamen;

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

    private static String[] datosUsuarioComun() {
        String correo = Teclado.leerCadena("Correo: ");
        String nombre = Teclado.leerCadena("Nombre: ");
        String apellido1 = Teclado.leerCadena("Apellido1: ");
        String apellido2 = Teclado.leerCadena("Apellido2: ");
        String contraseña = Teclado.leerCadena("Contraseña: ");
        return new String[]{correo, nombre, apellido1, apellido2, contraseña};
    }

    public static void main(String[] args) {
        GestionUsuarios gestion = new GestionUsuarios();
        int opcion;

        do {
            opcion = menu("\n(0) Salir del programa.\n" +
                    "(1) Insertar un administrador\n" +
                    "(2) Insertar un comprador\n" +
                    "(3) Ver todo", 3);

            switch (opcion) {
                case 1:
                    String[] datosNormales = datosUsuarioComun();
                    String categoriaAdmin = Teclado.leerCadena("Categoria: ");
                    boolean escritosAdmin = Teclado.leerBooleano("Escritos: ");
                    Usuario a = new Administrador(datosNormales[0], datosNormales[1], datosNormales[2], datosNormales[3], datosNormales[4], categoriaAdmin, escritosAdmin);
                    if (gestion.insertarUsuario(a)) {
                        System.out.println("añadido");
                    } else {
                        System.out.println("no añadido, ya existe con ese correo");
                    }
                    break;
                case 2:
                    String[] datosNormales2 = datosUsuarioComun();
                    String tarjetapago = Teclado.leerCadena("Tarjeta: ");
                    String direccionEnvio = Teclado.leerCadena("Direccion: ");
                    Usuario u = new Comprador(datosNormales2[0], datosNormales2[1], datosNormales2[2], datosNormales2[3], datosNormales2[4], tarjetapago, direccionEnvio);
                    if (gestion.insertarUsuario(u)) {
                        System.out.println("añadido");
                    } else {
                        System.out.println("no añadido, ya existe con ese correo");
                    }
                    break;
                case 3:
                    System.out.println(gestion);
            }
        } while (opcion != 0);
    }
}
