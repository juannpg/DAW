package herencia.actividades.A2X02_Bebidas;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Refresco r = new Refresco();
        Destilada d = new Destilada();
        Fermentada f = new Fermentada();

        System.out.println(r.toString());
        System.out.println(d.toString());
        System.out.println(f.toString());
    }
}
