package arrays.ejemplos;

public class NombresClase {
    public static boolean estaPepe(String[] alumnos) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].equalsIgnoreCase("Pepe")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] alumnos = new String[3];

        alumnos[0] = "Iria";
        alumnos[1] = "Juan";
        alumnos[2] = "Pepe";

        System.out.println(estaPepe(alumnos));
    }
}
