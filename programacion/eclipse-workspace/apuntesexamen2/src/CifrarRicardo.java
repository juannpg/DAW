public class CifrarRicardo {
    public static String cifrar(String frase) {
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cifrado = "";

        //Crear alfabeto cifrado
        int j = 2;
        for (int i = 0; i < alfabeto.length(); i++) {
            if (j == alfabeto.length()) {
                j = 0;
            }
            cifrado = cifrado.concat(String.valueOf(alfabeto.charAt(j)));
            j++;
        }

        //Sustituir cada letra del abecedario por su letra del cifrado
        String mensajeCifrado = "";
        for (int i = 0; i < frase.length(); i++) {
            boolean repetir = true;
            for (j = 0; j < alfabeto.length() && repetir; j++) {
                if (frase.charAt(i) == alfabeto.charAt(j)) {
                    mensajeCifrado = mensajeCifrado.concat(String.valueOf(cifrado.charAt(j)));
                    repetir = false;
                }
            }
        }
        return mensajeCifrado;
    }
}
