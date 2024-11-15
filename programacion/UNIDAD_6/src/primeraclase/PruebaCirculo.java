package primeraclase;

public class PruebaCirculo {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(3.4, "azul");

        System.out.println(c1.calcularArea());

        c1.setColor("rojo");

        System.out.println(c1.getColor());
        System.out.println(c1.calcularPerimetro());

        Circulo c2 = new Circulo(3);

        System.out.println(c2.getColor());

        Circulo c3 = new Circulo("verde");

        c2.setRadio(c1.getRadio());
        c3.setRadio(c1.getRadio());

        System.out.println(c1.getRadio() + "\n" + c2.getRadio() + "\n" + c3.getRadio());

        c2.setColor("negro");

        System.out.println(c1.getRadio());
        System.out.println(c1.getColor());
        System.out.println(c1.toString());
    }
}
