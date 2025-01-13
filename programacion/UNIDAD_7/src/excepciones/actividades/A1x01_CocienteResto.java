package excepciones.actividades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1x01_CocienteResto {
    public static String solicitarCadena(String mensaje) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(mensaje);
        return teclado.readLine();
    }

    public static short solicitarEnteroCorto(String mensaje, int numMaxErrores) throws IOException {
        boolean error;
        do {
            try {
                short corto = Short.parseShort(solicitarCadena(mensaje));
            } catch (NumberFormatException) {
                                   
            }
        } while (error && numMaxErrores != 0);
    }
}
