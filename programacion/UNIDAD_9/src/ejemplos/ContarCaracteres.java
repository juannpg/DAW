package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import entrada.Teclado;

public class ContarCaracteres {

    /**
     * Mostrar por pantalla las líneas de un fichero de texto
     * @param args
     */
    public static void main(String[] args) {

        String nombreFichero = Teclado.leerCadena("Diga el nombre del fichero");
        int numCaracteres = leerCaracteres(nombreFichero);
        System.out.println("numero de caracteres: " + numCaracteres);

    }

    /**
     *
     * @param nombreFichero
     */
    private static int leerCaracteres(String nombreFichero) {
        BufferedReader br = null;
        int numCaracteres = 0;
        try {
            File archivo = new File(nombreFichero);
            FileReader fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero línea por línea
            String linea = br.readLine();
            while (linea != null) {
                numCaracteres += linea.length();
                linea = br.readLine();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error al abrir el fichero"+ e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Error al leer del fichero"+ e.getMessage());
            e.printStackTrace();
        }
        finally {
            // Cierra el fichero
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException e) {
                System.out.println("Error al cerrar el fichero: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return numCaracteres;
    }
}