package actividad1x02;

import entrada.Teclado;

public class Actividad_1x02 {
    public static void main(String[] args) {
        System.out.println("PERSONA 1");
        String nombre = Teclado.leerCadena("Nombre: ");
        String apellido = Teclado.leerCadena("Apellido: ");
        int edad = Teclado.leerEntero("Edad: ");
        int altura = Teclado.leerEntero("Altura: ");
        boolean activo = Teclado.leerBooleano("Activo: ");

        Persona p = new Persona(nombre, apellido, edad, altura, activo);

        System.out.println(p.obtenerEstado());

        System.out.println("PERSONA 2");
        nombre = Teclado.leerCadena("Nombre: ");
        apellido = Teclado.leerCadena("Apellido: ");
        edad = Teclado.leerEntero("Edad: ");
        altura = Teclado.leerEntero("Altura: ");

        p = new Persona(nombre, apellido, edad, altura);

        System.out.println(p.obtenerEstado());

        System.out.println("PERSONA 3");
        p = new Persona();

        System.out.println(p.obtenerEstado());
    }
}
