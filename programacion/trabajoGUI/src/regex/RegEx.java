package regex;

public class RegEx {
    public static boolean dniBien(String dni) {
        if (dni.length() != 9 || !dni.substring(0, 8).matches("\\d{8}")) {
            return false;
        }

        String numeroDni = dni.substring(0, 8);
        char letraDni = dni.charAt(8);

        int numero = Integer.parseInt(numeroDni);
        int resto = numero % 23;

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

        return letraDni == letras.charAt(resto);
    }

    public static boolean telefonoBien(String telefono) {
        if (telefono.length() != 9) {
            return false;
        }

        if (telefono.matches("^([6-7]\\d{8}|91\\d{7}|93\\d{7}|95\\d{7}|96\\d{7}|97\\d{7})$")) {
            return true;
        }

        return false;
    }
}
