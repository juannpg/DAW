package caracteres.actividades;
import entrada.Teclado;

public class A2x08_IntercambiarNombreApellido {
    public static int contarEspacios(String frase) {
        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                contador++;
            }
        }
        return contador;
    }

    public static String leerNombreApellido(int num) {
        String nombreApellido;
        boolean error = false;
        do {
            nombreApellido = Teclado.leerCadena("¿Nombre completo " + num + "? ");
            if (nombreApellido.startsWith(" ") || nombreApellido.endsWith(" ") || contarEspacios(nombreApellido) != 1) {
                System.out.println("El nombre completo debe tener 1 espacio en blanco.\n" +
                        "El nombre completo no debe comenzar con un espacio en blanco.\n" +
                        "El nombre completo no debe terminar con un espacio en blanco.");
                error = true;
            }
        } while (error);

        return nombreApellido;
    }

    public static void intercambiarNombreApellido(String nombreApellido1, String nombreApellido2) {
        String nombre1 = nombreApellido1.substring(0, nombreApellido1.indexOf(' '));
        String apellido1 = nombreApellido1.substring(nombreApellido1.indexOf(' ') + 1);
        String nombre2 = nombreApellido2.substring(0, nombreApellido2.indexOf(' '));
        String apellido2 = nombreApellido2.substring(nombreApellido2.indexOf(' ') + 1);

        System.out.println(nombre1 + " " + apellido2 + "\n" + nombre2 + " " + apellido1);
    }

    public static void main(String[] args) {
        String nombreApellido1 = leerNombreApellido(1);
        String nombreApellido2 = leerNombreApellido(2);

        intercambiarNombreApellido(nombreApellido1, nombreApellido2);
    }
}
