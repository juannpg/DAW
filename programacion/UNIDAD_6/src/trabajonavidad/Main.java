package trabajonavidad;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo("Catalogo", 10);
        catalogo.generarVideosAleatorios(10);
        System.out.println(catalogo.toString());
    }
}

// TODO: Arreglar los años. Métodos del main.